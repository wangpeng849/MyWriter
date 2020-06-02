package com.wangp.myaop.s_graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * 图
 */
public abstract class  Graph<V,E> {

   protected WeightManager<E> weightManager;

   public Graph() {
   }

   public Graph(WeightManager<E> weightManager) {
      this.weightManager = weightManager;
   }

   //边的数量
   public abstract int edgesSize();
   //顶点数量
   public abstract int vertices();

   //添加顶点
   public abstract void addVertex(V v);
   //添加边
   public abstract void addEdge(V from,V to);
   //添加带权重的边
   public abstract void addEdge(V from,V to,E weight);


   //删除顶点
   public abstract void removeVertex(V v);
   //删除边
   public abstract void removeEdge(V from,V to);

   //遍历 广度优先（层次遍历）
   public abstract  void bfs(V begin,VertexVisitor<V> visitor);

   //遍历 深度优先
   public abstract  void dfs(V begin,VertexVisitor<V> visitor);


   //最小生成树
   public abstract Set<EdgeInfo<V,E>> mst();

   public static class EdgeInfo<V,E>{
      private V from;
      private V to;
      private E weight;

      public V getFrom() {
         return from;
      }

      public void setFrom(V from) {
         this.from = from;
      }

      public V getTo() {
         return to;
      }

      public void setTo(V to) {
         this.to = to;
      }

      public E getWeight() {
         return weight;
      }

      public void setWeight(E weight) {
         this.weight = weight;
      }

      protected EdgeInfo(V from, V to, E weight) {
         this.from = from;
         this.to = to;
         this.weight = weight;
      }

      @Override
      public String toString() {
         return "EdgeInfo{" +
                 "from=" + from +
                 ", to=" + to +
                 ", weight=" + weight +
                 '}';
      }
   }

   public interface VertexVisitor<V>{
      boolean visit(V v);
   }

   //拓扑排序 (必须是有向五环图)
   public abstract List<V> topologicalSort();

   public interface WeightManager<E> {
      int compare(E w1,E w2);
      E add(E w1,E w2);
   }

   public abstract Map<V,E> shortestPath(V begin);
}
