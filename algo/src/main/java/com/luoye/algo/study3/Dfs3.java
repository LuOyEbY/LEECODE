package com.luoye.algo.study3;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 6:28 下午
 * @Version: 1.0
 * @Description: 深度优先搜索算法3
 */
public class Dfs3 {

    public static int a=3;
    public static int b=2;
    public static int min= 9999999;
    public static int[][] aInt = new int[][]{
            {0,0,1,0},{0,0,0,0},{0,0,1,0},{0,1,0,0},{0,0,0,1}
    };
    public static int[][] book = new int[50][50];


    public static void dfs(int x, int y, int step) {
        int[][] next = {{0,1},//向右走
                        {1,0},//向下走
                        {0,-1},//向左走
                        {-1,0}};//向上走
        int tx,ty, k;
        //判断是否达到小哈的位置
        if(x == a && y == b){
            if(step < min){
                min = step;
            }
        }
        //枚举4种走法
        for (k=0; k <=3;k++){
            //计算下一个点的坐标
            tx = x +next[k][0];
            ty = y +next[k][1];
            //判断是否越界
            if(tx < 0 || tx >=5  || ty<0 || ty >= 4){
                continue;
            }
            //判断该点是不是为障碍物或者已经在路径上
            if(aInt[tx][ty] == 0 && book[tx][ty] ==0){
                book[tx][ty]=1;
                dfs(tx,ty,step+1);
                book[tx][ty]=0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0,0,0);
        System.out.println(min);
    }
}
