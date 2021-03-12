package com.luoye.algo.study5;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/25 3:20 下午
 * @Version: 1.0
 * @Description: 只有五行的算法
 */
public class FloydWarshall {
    private static int[][] e = new int[5][5];
    private static int[] book = new int[10];
    private static int a = 4;


    public static void floydWarshall() {

        for (int k = 1; k <= a; k++) {
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a; j++) {
                    if(e[i][j] >  e[i][k] + e[k][j] || e[i][j]==0){
                        if(i == j){
                            e[i][j] = 0;
                        }else{
                            e[i][j] = e[i][k] + e[k][j];
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        e[1][2] = 2;
        e[1][3] = 6;
        e[1][4] = 4;
        e[2][3] = 3;
        e[3][1] = 7;
        e[3][4] = 1;
        e[4][1] = 5;
        e[4][3] = 12;
        book[1] = 1;
        floydWarshall();
        for (int i = 1; i <= a ; i++) {
            for (int j = a; j <= a ; j++) {
                System.out.println(e[i][j]);
            }
        }
        System.out.println("跑完了");
    }
}
