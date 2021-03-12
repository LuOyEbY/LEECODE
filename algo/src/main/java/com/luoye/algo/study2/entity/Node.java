package com.luoye.algo.study2.entity;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 4:46 下午
 * @Version: 1.0
 * @Description: 链表的单个单元
 */
public class Node<E> {

    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> next, Node<E> prev, E item){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
