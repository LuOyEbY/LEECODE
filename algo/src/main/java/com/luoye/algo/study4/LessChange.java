package com.luoye.algo.study4;

import com.luoye.algo.study4.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/23 5:28 下午
 * @Version: 1.0
 * @Description: 最少转机--图的广度优先遍历
 */
public class LessChange {

    private static int sum = 0;
    private static int n = 5;
    private static int flag = 0;
    private static int min = 999999;

    public static int[][] e = new int[10][10];
    public static int[] book = new int[50];

    public static int head = 0;
    public static int tail = 0;
    public static List<Node> queue = new ArrayList<>();

    public static void bfs(int cur) {

        queue.get(tail).setX(cur);
        tail++;
        while(head< tail){
            cur = queue.get(head).getX();
            for (int i = 1; i <= n; i++) {
                if (e[cur][i] == 1 && book[i] == 0) {
                    queue.get(tail).setX(i);
                    queue.get(tail).setS(queue.get(tail).getS() + 1);
                    tail++;
                    book[i] = 1;
                }
                if(queue.get(tail).getX() == 5){
                    flag =1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            head++;
        }
    }


    public static void main(String[] args) {
        e[1][2] = 1;
        e[1][3] = 1;
        e[1][5] = 1;
        e[2][3] = 1;
        e[2][4] = 1;
        e[3][4] = 1;
        e[3][5] = 1;
        e[4][5] = 1;
        book[1] = 1;
        bfs(1);
        System.out.println(queue.get(tail-1).getS());
    }
}
