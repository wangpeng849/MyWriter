package com.wangp.myaop.s_graph;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
//        test();
//        testNoDirect();
//        testBfs();
//        testDfs();
        testTopological();
    }

    static void testTopological(){
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> list = graph.topologicalSort();
        System.out.println(list);
    }

    private static void testDfs() {
        Graph<Object, Double> graph = directedGraph(Data.DFS_02);
        graph.dfs("c", o -> {
            System.out.println(o);
            return false;
        });
    }

    static void testBfs(){
        Graph<Object, Double> graph = directedGraph(Data.BFS_02);
        graph.bfs(5,o->{
            System.out.println(o);
            return false;
        });
    }

    //无向图
    private static void testNoDirect() {
        ListGraph<String,Integer> graph = new ListGraph<>();
        graph.addEdge("V0","V1");
        graph.addEdge("V1","V0");

        graph.addEdge("V0","V2");
        graph.addEdge("V2","V0");
    }


    static void test(){
        ListGraph<String,Integer> graph = new ListGraph<>();
        graph.addEdge("V1","V0",9);
        graph.addEdge("V2","V0",2);
        graph.addEdge("V1","V2",3);
        graph.addEdge("V2","V3",5);
        graph.addEdge("V3","V4",1);
        graph.addEdge("V0","V4",6);
//        graph.print();

//        graph.removeEdge("V0","V4");
//        graph.print();
//        graph.removeVertex("V0");
//        graph.print();
//        graph.bfs("V1");
    }

    /**
     * 有向图
     */
    private static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

    /**
     * 无向图
     * @param data
     * @return
     */
    private static Graph<Object, Double> undirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }
}
