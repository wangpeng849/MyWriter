package com.wangp.myaop.s_graph;

import com.wangp.myaop.union_find.GenericUnionFind;
import com.wangp.myaop.union_find.UnionFind;
import org.thymeleaf.model.IStandaloneElementTag;

import java.util.*;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class ListGraph<V, E> extends Graph<V, E> {

    public ListGraph() {
        super();
    }

    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }

    /**
     * 顶点
     */
    private static class Vertex<V, E> {
        V value;
        //入度
        Set<Edge<V, E>> inEdges = new HashSet<>();
        //出度
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>) obj).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
//            return "Vertex [Value=" + valueString + ",inEdges=" + inEdges + ",outEdges=" + outEdges + "]";
        }
    }

    /**
     * 边
     */
    private static class Edge<V, E> {
        //起点
        Vertex<V, E> from;

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        //终点
        Vertex<V, E> to;
        //权值
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        EdgeInfo<V, E> info() {
            return new EdgeInfo<V, E>(from.value, to.value, weight);
        }
    }

    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();
    private Comparator<Edge<V, E>> edgeComparator = (Edge<V, E> e1, Edge<V, E> e2) -> weightManager.compare(e1.weight, e2.weight);

    public void print() {
        System.out.println("[顶点]");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("OutEdges = " + vertex.outEdges);
            System.out.println("InEdges = " + vertex.inEdges);
        });
        System.out.println("[边]");
        edges.forEach(System.out::println);
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int vertices() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        //判断顶点是否存在
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }
        //判断有没有已经存在一条边
        Edge<V, E> edge = new Edge(fromVertex, toVertex);
        edge.weight = weight;
        //删除这条边
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        //在加入
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;
        //删除顶点所在边
        //一边遍历一边删除禁止
//        vertex.inEdges.forEach((Edge<V,E> edge)->{
//            removeEdge(edge.from.value,edge.to.value);
//        });
//        vertex.outEdges.forEach((Edge<V,E> edge)->{
//            removeEdge(edge.from.value,edge.to.value);
//        });
        //一边删除一边遍历使用 迭代器
        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            //找到终点
            edge.to.inEdges.remove(edge);
            //当前遍历到的元素edge从集合vertex.outEdges中删除
            iterator.remove();
            edges.remove(edge);
        }
        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            //找到起点
            edge.from.outEdges.remove(edge);
            //当前遍历到的元素edge从集合vertex.inEdges
            iterator.remove();
            edges.remove(edge);
        }
    }

    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        Vertex<V, E> toVertex = vertices.get(to);
        //判断顶点是否存在
        if (fromVertex == null || toVertex == null) return;
        //判断边是否存在
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }


//    @Override
//    public void bfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//
//        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
//        Queue<Vertex<V, E>> queue = new LinkedList<>();
//        queue.offer(beginVertex);
//        visitedVertices.add(beginVertex);
//
//        while (!queue.isEmpty()) {
//            Vertex<V, E> vertex = queue.poll();
//            System.out.println(vertex.value);
//            for (Edge<V, E> outEdge : vertex.outEdges) {
//                if (visitedVertices.contains(outEdge.to)) continue;
//                queue.offer(outEdge.to);
//                visitedVertices.add(outEdge.to);
//            }
//        }
//    }

//    @Override
//    public void dfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
////        dfs(beginVertex,new HashSet<>());
//        dfs(beginVertex);
//    }
//
//    private void dfs(Vertex<V, E> vertex,HashSet<Vertex<V,E>> visitedVertex) {
//        System.out.println(vertex.value);
//        visitedVertex.add(vertex);
//        for (Edge<V, E> outEdge : vertex.outEdges) {
//            if(visitedVertex.contains(outEdge.to)) continue;
//            dfs(outEdge.to,visitedVertex);
//        }
//    }
//
//    //非递归实现
//    private void dfs(Vertex<V,E> beginVertex){
//        HashSet<Vertex<V,E>> visitedVertex = new HashSet<Vertex<V,E>>();
//        Stack<Vertex<V,E>> stack = new Stack<>();
//        //先访问起点
//        stack.push(beginVertex);
//        visitedVertex.add(beginVertex);
//        System.out.println(beginVertex.value);
//        while(!stack.isEmpty()){
//            Vertex<V, E> vertex = stack.pop();
//            for (Edge<V, E> outEdge : vertex.outEdges) {
//                if(visitedVertex.contains(outEdge.to)){
//                    continue;
//                }
//                stack.push(outEdge.from);
//                stack.push(outEdge.to);
//                visitedVertex.add(outEdge.to);
//                System.out.println(outEdge.to.value);
//                break;
//            }
//        }
//    }


    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertices.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            if (visitor.visit(vertex.value)) break;
            for (Edge<V, E> outEdge : vertex.outEdges) {
                if (visitedVertices.contains(outEdge.to)) continue;
                queue.offer(outEdge.to);
                visitedVertices.add(outEdge.to);
            }
        }
    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        HashSet<Vertex<V, E>> visitedVertex = new HashSet<Vertex<V, E>>();
        Stack<Vertex<V, E>> stack = new Stack<>();
        //先访问起点
        stack.push(beginVertex);
        visitedVertex.add(beginVertex);
        if (visitor.visit(begin)) return;
        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();
            for (Edge<V, E> outEdge : vertex.outEdges) {
                if (visitedVertex.contains(outEdge.to)) {
                    continue;
                }
                stack.push(outEdge.from);
                stack.push(outEdge.to);
                visitedVertex.add(outEdge.to);
                if (visitor.visit(outEdge.to.value)) return;
                break;
            }
        }
    }

    @Override
    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Map<Vertex<V, E>, Integer> ins = new HashMap<>();

        //将度为0的节点都放入队列
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            if (vertex.inEdges.size() == 0) {
                queue.offer(vertex);
            } else {
                ins.put(vertex, vertex.inEdges.size());
            }
        });
        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);
            for (Edge<V, E> outEdge : vertex.outEdges) {
                Integer toIn = ins.get(outEdge.to) - 1;
                if (toIn == 0) {
                    queue.offer(outEdge.to);
                } else {
                    ins.put(outEdge.to, toIn);
                }
            }
        }
        return list;
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return kruskal();
    }

    private Set<EdgeInfo<V, E>> prim() {
        Iterator<Vertex<V, E>> it = vertices.values().iterator();
        if (!it.hasNext()) return null;

        Vertex<V, E> vertex = it.next();
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        Set<Vertex<V, E>> addedVertex = new HashSet<>();
        //PriorityQueue底层就是最小堆  但是PriorityQueue构造函数只能传比较器或者Collections 所以自实现一个MinHeap来实现传两个
//        PriorityQueue<Edge<V, E>> heap = new PriorityQueue<>((Edge<V, E> e1, Edge<V, E> e2) -> {
//            return 0;
//        });
//      for循环效率太低 一次性建堆更好
//        for (Edge<V, E> edge : vertex.outEdges) {
//            heap.offer(edge);
//        }

        MinHeap<Edge<V, E>> heap = new MinHeap<>(vertex.outEdges, edgeComparator);
        addedVertex.add(vertex);
        while (!heap.isEmpty() && addedVertex.size() < vertices()) {
            Edge<V, E> edge = heap.remove();
            if (addedVertex.contains(edge.to)) continue;
            edgeInfos.add(edge.info());
            addedVertex.add(edge.to);
            heap.addAll(edge.to.outEdges);
        }
        return edgeInfos;
    }

    private Set<EdgeInfo<V, E>> kruskal() {
        int edgeSize = vertices.size() -1;
        if(edgeSize == -1) return null;

        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        //放入所有边
        MinHeap<Edge<V, E>> heap = new MinHeap<>(edges, edgeComparator);
        GenericUnionFind uf = new GenericUnionFind<Vertex<V, E>>();
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            uf.makeSet(vertex);
        });
        while (!heap.isEmpty() && edgeInfos.size() < edgeSize) {
            Edge<V, E> edge = heap.remove();
            //如果构成环就continue
            //判断构成环 使用并查集 本来在一个集合的就会构成环
            if (uf.isSame(edge.from, edge.to)) continue;
            edgeInfos.add(edge.info());
            uf.union(edge.from,edge.to);
        }
        return edgeInfos;
    }

}
