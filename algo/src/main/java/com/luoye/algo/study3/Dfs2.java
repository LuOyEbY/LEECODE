package com.luoye.algo.study3;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 6:07 下午
 * @Version: 1.0
 * @Description: 深度优先算法2
 */
public class Dfs2 {

    public static int n = 9;
    public static int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] book = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int total = 0;

    public static void dfs(int step){
        if(step == n+1){
            if((a[1]*100 + a[2]*10 + a[3]) +(a[4]*100 + a[5]*10 + a[6]) == (a[7]*100 + a[8]*10 + a[9])){
                for (int i = 1; i <=n ; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println("下一组");
                total++;
            }
        }
        for (int i = 1; i <= n ; i++) {
            if(book[i] == 0){
               a[step] = i;
               book[i] = 1;
               dfs(step + 1);
               book[i] = 0;
            }
        }

    }


    public static void main(String[] args) {
        dfs(1);
        System.out.println(total/2);
    }
}
