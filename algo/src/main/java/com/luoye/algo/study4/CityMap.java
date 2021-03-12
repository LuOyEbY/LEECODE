package com.luoye.algo.study4;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/23 2:22 下午
 * @Version: 1.0
 * @Description: 城市地图--图的深度优先遍历
 */
public class CityMap {

    private static int sum = 0;
    private static int n = 5;
    private static int min = 999999;

    public static int[][] e = new int[10][10];
    public static int[] book = new int[50];


    public static void dfs(int start, int end, int diss) {

        if(start == end){
            if(diss < min){
                min = diss;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(e[start][i] > 0 && book[i] == 0){
                book[i]=1;
                dfs(i, end, diss + e[start][i]);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        e[1][2] = 2;
        e[2][1] = 2;
        e[1][5] = 10;
        e[5][1] = 10;
        e[2][3] = 3;
        e[3][2] = 3;
        e[2][5] = 7;
        e[5][2] = 7;
        e[3][1] = 4;
        e[1][3] = 4;
        e[3][4] = 4;
        e[4][3] = 4;
        e[4][5] = 5;
        e[5][4] = 5;
        e[5][3] = 3;
        e[3][5] = 3;
        book[1] = 1;
        dfs(1, 5, 0);
        System.out.println(min);
    }
}
