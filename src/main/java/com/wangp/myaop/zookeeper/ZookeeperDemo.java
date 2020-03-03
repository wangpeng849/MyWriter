package com.wangp.myaop.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/21 11:36
 */
public class ZookeeperDemo {
    private static final String CONNECT_STRING = "120.77.212.61:2181";
    private static final int SESSION_TIMEOUT = 5000;
    //信号量 阻塞程序执行 用户等待zookeeper连接成功，发送成功信号
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            // 1. zookeeper创建了一个连接
            zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    //监听节点是否变化
                    //获取事件状态
                    Event.KeeperState state = watchedEvent.getState();
                    //获取事件类型
                    Event.EventType type = watchedEvent.getType();
                    if (Event.KeeperState.SyncConnected == state) {
                        if (Event.EventType.None == type) {
                            countDownLatch.countDown();
                            System.out.println("zk 启动连接。。。");
                        }
                    }
                }
            });

            // 2.
            //节点类型:
            // 1. CreateMode . EPHEMERAL创建- -个临时节点
            // 2.CreateMode. EPHEMERAL _SEQUENTIAL 如果节点发生重复的情况下，会自动id自增保证唯- -性
            // 3.CreateMode . PERSISTENT持久类型永久保存在硬盘上
            // 4.CreateMode. PERSISTENT SEQUENTIAL持久类型如果节点发生重复的情况下,会自动id自增保证唯一性

            countDownLatch.await();//如果计数器不为0则一直等待
            /**
             * 创建节点(znode) 方法:
             * create(String path, byte[] data, List<ACL> acl, CreateMode createMode) throws KeeperException, InterruptedException
             *
             * 提供了两套创建节点的方法，同步和异步创建节点方式。
             * 同步方式:
             * * 参数1，节点路径名称 : InodeName (不允许递归创建节点，也就是说在父节点不存在的情况下，不允许创建子节点)
             * * 参数2，节点内容: 要求类型是字节数组(也就是说，不支持序列化方式，如果需要实现序列化，可使用java相关序列化框架，如Hessian、Kryo框架)
             * * 参数3，节点权限: 使用Ids.OPEN_ACL_UNSAFE开放权限即可。(这个参数一般在权展
             * 没有太高要求的场景下，没必要关注)
             * * 参数4,节点类型: 创建节点的类型: CreateMode，提供四种节点类型
             *    * PERSISTENT                   持久化节点
             *    * PERSISTENT_SEQUENTIAL        顺序自动编号持久化节点，这种节点会根据当前已存在的节点数自动加 1
             *    * EPHEMERAL                    临时节点， 客户端session超时这类节点就会被自动删除
             *    * EPHEMERAL_SEQUENTIAL         临时自动编号节点
             */
            String nodeResult = zooKeeper.create("/test", "zhangsan".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("节点名称：" + nodeResult);
        } catch (Exception e) {

        } finally {
            if (zooKeeper != null) {
                try {
                    zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

