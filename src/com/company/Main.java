package com.company;
import java.io.*;
import java.util.StringTokenizer;
// 자바 기본 입출력 세팅
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p [] = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(Integer.toString(p.length));
        bw.flush();
        br.close();
        bw.close();



    }
}
