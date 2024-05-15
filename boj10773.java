// package boj10773;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 파일로부터 입력을 읽어오는 코드
        // System.setIn(new FileInputStream("src/input.txt"));
        // 표준 입력을 통해 데이터를 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 표준 출력을 통해 데이터를 출력함
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받을 정수의 개수 K
        int K = Integer.parseInt(br.readLine());
        // 정수를 저장할 스택 생성
        Stack<Integer> stack = new Stack<>();

        // K개의 정수를 입력받음
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                // 입력이 0이면 스택에서 가장 최근의 값을 제거
                stack.pop();
            } else {
                // 입력이 0이 아니면 스택에 값을 추가
                stack.push(val);
            }
        }

        // 스택에 남아있는 모든 정수의 합을 계산
        int sum = 0;
        for (Integer v : stack) {
            sum += v;
        }

        // 결과를 출력 버퍼에 저장
        bw.write(sum + "");
        bw.flush();

        // 리소스 해제
        br.close();
        bw.close();
    }

}
