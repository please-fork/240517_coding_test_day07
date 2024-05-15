// package boj9012;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 표준 입력을 파일로부터 읽도록 설정
        // System.setIn(new FileInputStream("src/input.txt"));

        // 표준 입력을 통해 데이터를 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 표준 출력을 통해 데이터를 출력함
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 수를 입력받음
        int T = Integer.parseInt(br.readLine());
        // System.out.println(T);

        // 테스트 케이스 수만큼 반복
        for (int i = 0; i < T; i++) {
            // 괄호 문자열을 입력받음
            String s = br.readLine();
            // 괄호 검사를 위한 스택 생성
            Stack<String> stack = new Stack<>();
            // 초기 답변을 "YES"로 설정
            String answer = "YES";

            // 문자열을 한 글자씩 순회
            for (String v : s.split("")) {
                // 만약 닫는 괄호를 만났을 때
                if (v.equals(")")) {
                    // 스택이 비어있으면 잘못된 괄호열이므로 "NO"로 설정하고 반복 종료
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    } else {
                        // 스택이 비어있지 않으면 열린 괄호 하나를 팝함
                        stack.pop();
                    }
                } else {
                    // 열린 괄호를 스택에 푸쉬
                    stack.push("(");
                }
            }

            // 모든 괄호를 처리한 후에도 스택이 비어있지 않으면 "NO"로 설정
            if (!stack.isEmpty()) {
                answer = "NO";
            }

            // 결과를 출력 버퍼에 저장
            bw.write(answer);
            bw.newLine();
        }

        // 출력 버퍼를 실제 출력
        bw.flush();
        // 리소스 해제
        br.close();
        bw.close();
    }

}
