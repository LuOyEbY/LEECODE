package com.luoye.algo.study4;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/23 12:04 下午
 * @Version: 1.0
 * @Description: 深度优先遍历图
 */
public class DFS_graph {
    private static int sum = 0;
    private static int n = 5;

    public static int[][] e = new int[10][10];
    public static int[] book = new int[50];

    public static void dfs(int cur){

        System.out.println(cur);
        if(sum == n){
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(e[cur][i]==1 && book[i] ==0){
                book[i] = 1;
                dfs(i);
            }
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
        dfs(1);
    }
}
