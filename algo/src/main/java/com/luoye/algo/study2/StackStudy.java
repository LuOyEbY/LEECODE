package com.luoye.algo.study2;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 10:06 上午
 * @Version: 1.0
 * @Description: 栈
 */
public class StackStudy {

    public static void stackStudy() {
        char[] a = {'x', 'y', 'z','z', 'y', 'x'};
        char[] s = new char[101];
        int mid = a.length / 2 -1;
        for (int i = 0; i <= mid; i++) {
            s[i] = a[i];
        }
        for (int i = mid +1; i < a.length - 1; i++) {
            if (a[i] != s[mid]) {
                break;
            } else {
                mid--;
            }
        }
        if (mid == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        stackStudy();
    }
}
