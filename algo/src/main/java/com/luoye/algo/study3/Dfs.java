package com.luoye.algo.study3;

import java.util.List;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 5:25 下午
 * @Version: 1.0
 * @Description: 深度优先搜索
 */
public class Dfs {

    private static int n = 3;
    private static int[] book = {0, 0, 0, 0};
    private static int[] a = {0, 0, 0, 0};


    public static void dfs(int step) {
        if (step == n+1){
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("下一个");
        }

        for (int i = 1; i <= n; i++) {
            if(book[i] == 0){
                a[step] = i;
                book[i] = 1;

                dfs(step+1);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
