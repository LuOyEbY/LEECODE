package com.luoye.algo.study2;

import com.luoye.algo.study2.entity.QueueEntity;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 5:23 下午
 * @Version: 1.0
 * @Description: 队列
 */
public class Queue {

    public static void queue() {
        int[] a = {0, 6, 3, 1, 7, 5, 8, 9, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        QueueEntity queueEntity = new QueueEntity();
        queueEntity.setHead(1);
        queueEntity.setTail(10);
//        queueEntity.setData(a);

        while (queueEntity.getHead() < queueEntity.getTail()) {
            System.out.print(a[queueEntity.getHead()] + " ");
            queueEntity.setHead(queueEntity.getHead() + 1);
            a[queueEntity.getTail()] = a[queueEntity.getHead()];
            queueEntity.setTail(queueEntity.getTail() + 1);
            queueEntity.setHead(queueEntity.getHead() + 1);
        }

    }

    public static void main(String[] args) {
        queue();
    }
}
