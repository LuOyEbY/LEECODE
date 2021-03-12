package com.luoye.algo.study4;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/23 1:39 下午
 * @Version: 1.0
 * @Description: 广度优先遍历图
 */
public class BFS_graph {


    private static int sum = 0;
    private static int n = 5;

    public static int[][] e = new int[10][10];
    public static int[] book = new int[50];
    public static int[] queue = new int[10];
    public static int head = 0;
    public static int tail = 0;

    public static void bfs(int cur){
        if(sum == n){
            return;
        }
        queue[tail] = cur;
        tail++;
        book[1] = 1;
        while(head < tail){
            cur = queue[head];
            for (int j = 1; j <= n; j++) {
                if(e[cur][j]==1 && book[j] == 0){
                    book[j] = 1;
                    queue[tail] = j;
                    tail++;
                }
                if(tail > n){
                    break;
                }
            }
            head++;
        }

    }


    public static void main(String[] args) {
        e[1][2] = 1;
        e[2][1] = 1;
        e[1][3] = 1;
        e[3][1] = 1;
        e[1][5] = 1;
        e[5][1] = 1;
        e[2][4] = 1;
        e[4][2] = 1;
        e[3][5] = 1;
        e[5][3] = 1;
        book[1] = 1;
        bfs(1);
        for (int i = 0; i < queue.length - 1; i++) {
            System.out.println(queue[i]);
        }
    }
}
