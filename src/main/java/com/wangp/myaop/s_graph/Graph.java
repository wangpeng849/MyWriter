package com.wangp.myaop.s_graph;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * 图
 */
public interface Graph<V,E> {
   //边的数量
   int edgesSize();
   //顶点数量
   int vertices();

   //添加顶点
   void addVertex(V v);
   //添加边
   void addEdge(V from,V to);
   //添加带权重的边
   void addEdge(V from,V to,E weight);


   //删除顶点
   void removeVertex(V v);
   //删除边
   void removeEdge(V from,V to);

   //遍历 广度优先（层次遍历）
   void bfs(V begin,VertexVisitor<V> visitor);

   //遍历 深度优先
   void dfs(V begin,VertexVisitor<V> visitor);

   interface VertexVisitor<V>{
      boolean visit(V v);
   }

   //拓扑排序 (必须是有向五环图)
   List<V> topologicalSort();
}
