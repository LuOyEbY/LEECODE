package com.luoye.algo.study;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 5:04 下午
 * @Version: 1.0
 * @Description: 测试题
 */
public class Test {

    public static void test1(){
        int[] a = {20, 40, 32, 67, 40, 20, 89, 300 ,400, 15};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j+1]){
                    int temp;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        a = Arrays.stream(a).distinct().toArray();
        System.out.println(a.length);
        Arrays.stream(a).forEach(x -> System.out.print(x + " "));
    }

    public static void test2(int left, int right, int[] a){
        if(left > right){return;}
        int temp = a[left];
        int i = left;
        int j = right;
        while(i !=j){
            while(a[j] >= temp && j > i){
                j--;
            }
            while(a[i] <= temp && i< j){
                i++;
            }
            if(i < j){
                int temp2;
                temp2 = a[i];
                a[i] = a[j];
                a[j] = temp2;
            }
        }
        a[left] = a[i];
        a[i] = temp;
        test2(left, i-1, a);
        test2(i+1, right, a);
    }



    public static void main(String[] args) {
        test1();
        int[] a = {20, 40, 32, 67, 40, 20, 89, 300 ,400, 15};
        test2(0, a.length - 1, a);
        System.out.println(" ");
        Arrays.stream(a).forEach(x -> System.out.print(x + " "));
    }
}
