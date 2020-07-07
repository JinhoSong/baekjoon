package com.company;
import java.io.*;
import java.util.StringTokenizer;


// 자바 기본 입출력 세팅
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 9;
        int p [] = new int [n];
        int max = -1;
        int index = 0;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            if(p[i] > max ) {
                index = i + 1;
                max = p[i];
            }
        }
        bw.write(Integer.toString(max)+"\n");
        bw.write(Integer.toString(index));
        bw.flush();
        br.close();
        bw.close();

    }
}
