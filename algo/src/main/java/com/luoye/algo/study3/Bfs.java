package com.luoye.algo.study3;


import com.luoye.algo.study3.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/22 7:16 下午
 * @Version: 1.0
 * @Description: 广度优先搜索
 */
public class Bfs {

    public static int a = 3;
    public static int b = 2;
    public static int min = 9999999;
    public static int[][] aInt = new int[][]{
            {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 1}
    };
    public static int[][] book = new int[50][50];

    public static void bfs() {
        List<Note> noteList = new ArrayList<>();
        int head = 0;
        int tail = 0;
        Note note = new Note();
        note.setX(0);
        note.setY(0);
        note.setS(0);
        noteList.add(note);
        tail++;
        book[0][0] = 1;
        int[][] next = {{0, 1},//向右走
                {1, 0},//向下走
                {0, -1},//向左走
                {-1, 0}};//向上走
        int tx, ty, k;
        //枚举4种走法
        int flag = 0;
        while(head <= tail ){
            for (k = 0; k <= 3; k++) {

                tx = noteList.get(head).getX() + next[k][0];
                ty = noteList.get(head).getY() + next[k][1];

                if (tx < 0 || ty < 0 || tx >= 5 || ty >= 4) {
                    continue;
                }
                if (aInt[tx][ty] == 0 && book[tx][ty] == 0) {
                    book[tx][ty] = 1;
                    Note note1 = new Note();
                    note1.setX(tx);
                    note1.setY(ty);
                    note1.setS(noteList.get(head).getS() + 1);
                    noteList.add(note1);
                    tail++;
                }
                if(tx == a && ty == b){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            head++;
        }
        System.out.println(noteList.get(noteList.size()-1).getS());
    }


    public static void main(String[] args) {
        bfs();
    }
}
