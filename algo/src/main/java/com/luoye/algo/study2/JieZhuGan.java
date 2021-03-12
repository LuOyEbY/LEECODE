package com.luoye.algo.study2;

import com.luoye.algo.study2.entity.QueueEntity;

import java.util.*;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 10:48 上午
 * @Version: 1.0
 * @Description: 接竹竿
 */
public class JieZhuGan {

    public static void JieZhuGan() {
        QueueEntity queueEntity1 = new QueueEntity();
        queueEntity1.setHead(0);
        queueEntity1.setTail(5);
        int[] a ={2, 4, 1, 2, 5, 6};
        List<Integer> arrayList1 =new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(4);
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(5);
        arrayList1.add(6);
        queueEntity1.setData(arrayList1);
        QueueEntity queueEntity2 = new QueueEntity();
        queueEntity2.setHead(0);
        queueEntity2.setTail(5);
        int[] b = {3, 1, 3, 5, 6, 4};
        List<Integer> arrayList2 =new ArrayList<>();
        arrayList2.add(3);
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(5);
        arrayList2.add(6);
        arrayList2.add(4);
        queueEntity2.setData(arrayList2);

        List<Integer> stack = new ArrayList<>();
        while(queueEntity1.getHead() != queueEntity1.getTail() && queueEntity2.getHead() != queueEntity2.getTail() ){
            //q1先出牌
            if(queueEntity1.getHead() <= queueEntity1.getTail()){
                Integer value = queueEntity1.getData().get(queueEntity1.getHead());
                queueEntity1.setHead(queueEntity1.getHead() + 1);
                int flag = 0;
                for (int i = 0; i < stack.size(); i++) {
                    //有相同的牌，
                    if(stack.get(i).equals(value)){
                        flag = 1;
                        //把出的牌放在手里
                        queueEntity1.getData().add(value);
                        queueEntity1.setTail(queueEntity1.getTail() + 1);
                        List<Integer> newList = stack.subList(0, i);
                        for (int j = stack.size() - 1; j >= i  ; j--) {
                            queueEntity1.getData().add(stack.get(j));
                            queueEntity1.setTail(queueEntity1.getTail() + 1);
                        }
                        stack = newList;
                    }
                }
                if(flag == 0){
                    stack.add(value);
                }
            }
            //q2出牌
            if(queueEntity2.getHead() <= queueEntity2.getTail()){
                Integer value = queueEntity2.getData().get(queueEntity2.getHead());
                queueEntity2.setHead(queueEntity2.getHead() + 1);
                int flag = 0;
                for (int i = 0; i < stack.size(); i++) {
                    //有相同的牌，
                    if(stack.get(i).equals(value)){
                        flag = 1;
                        //把出的牌放在手里
                        queueEntity2.getData().add(value);
                        queueEntity2.setTail(queueEntity2.getTail() + 1);
                        List<Integer> newList = stack.subList(0, i);
                        for (int j = stack.size() - 1; j >= i  ; j--) {
                            queueEntity2.getData().add(stack.get(j));
                            queueEntity2.setTail(queueEntity2.getTail() + 1);
                        }
                        stack = newList;
                    }
                }
                if(flag == 0){
                    stack.add(value);
                }
            }
        }
        if (queueEntity1.getHead() == queueEntity1.getTail()) {
            System.out.println("q2获胜，q1输了");
            System.out.println("q2手中的牌是：");
            for (int i = queueEntity2.getHead(); i <= queueEntity2.getTail() ; i++) {
                System.out.println(queueEntity2.getData().get(i));
            }
            System.out.println("桌面上的牌是：");
            stack.stream().forEach(x -> System.out.print(x + ""));
        }
        if (queueEntity2.getHead() == queueEntity2.getTail()) {
            System.out.println("q1获胜，q2输了");
            System.out.println("q1手中的牌是：");
            for (int i = queueEntity1.getHead(); i <= queueEntity1.getTail() ; i++) {
                System.out.println(queueEntity1.getData().get(i));
            }
            System.out.println("桌面上的牌是：");
            stack.stream().forEach(x -> System.out.print(x + ""));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> a = new LinkedList<Integer>();//A手中的牌
        LinkedList<Integer> b = new LinkedList<Integer>();//B手中的牌
        Stack<Integer> stack = new Stack<>();//记录桌面上的牌
        int[] book = new int[10];//用来标记哪些牌已经在桌上
        int n,t,s;
        for(int i = 0; i < 10; i++){
            book[i] = 0;
        }
        System.out.println("输入手中牌的个数");
        n = scanner.nextInt();
        System.out.println("输入A君手中牌的大小");
        for(int i = 1; i<=n; i++){
            a.addLast(scanner.nextInt());
        }
        System.out.println("输入B君手中牌的大小");
        for(int i = 1; i<=n; i++){
            b.addLast(scanner.nextInt());
        }
        System.out.println("输入完毕开始游戏");
        while (!a.isEmpty() && !b.isEmpty()) {//当有人手中没牌游戏结束
            t = a.removeFirst();
            if (book[t] == 0) {//A没有赢
                stack.push(t);//桌面上加一张牌
                book[t] = 1;//记录桌面上已经有这张牌了
            }else {//A赢了
                a.addLast(t);//将打出的牌到到末尾
                while (!stack.peek().equals(t)) {//将桌面上的牌按顺序放到A的末尾
                    s = stack.pop();
                    a.addLast(s);
                    book[s] = 0;
                }
            }

            //同上B取出牌
            t = b.removeFirst();
            if (book[t] == 0) {
                stack.push(t);
                book[t] = 1;
            } else {
                b.addLast(t);
                while (!stack.peek().equals(t)) {
                    s = stack.pop();
                    b.addLast(s);
                    book[s]= 0;
                }
            }
        }

        if (!a.isEmpty()) {//A胜利
            System.out.println("A君胜利！A手中的牌是");
            while (!a.isEmpty()) {
                System.out.print(a.removeFirst()+ " ");
            }
            System.out.println();
            if (!stack.isEmpty()) {//桌面上有牌
                System.out.println("桌面上的牌是");
                for (Integer x : stack) {
                    System.out.print(x + " ");
                }
            } else {
                System.out.println("桌面没有牌了");
            }
        } else {//B胜利
            System.out.println("B君胜利！B手中的牌是");
            while (!b.isEmpty()) {
                System.out.print(b.removeFirst()+ " ");
            }
            System.out.println();
            if (!stack.isEmpty()) {//桌面上有牌
                System.out.println("桌面上的牌是");
                for (Integer x : stack) {
                    System.out.print(x + " ");
                }
            } else {
                System.out.println("桌面没有牌了");
            }
        }
        return;//结束
    }
}
