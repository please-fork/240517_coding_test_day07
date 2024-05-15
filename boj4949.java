// package boj4949;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 파일로부터 입력을 읽어오는 코드 (주석 처리 필요 시 주석 해제)
        System.setIn(new FileInputStream("src/input.txt"));
        // 표준 입력을 통해 데이터를 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 표준 출력을 통해 데이터를 출력함
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            // 한 줄의 문자열을 입력받음
            String s = br.readLine();
            // 입력이 "."이면 반복을 종료
            if (s.equals(".")) {
                break;
            }
            // 괄호 검사를 위한 스택 생성
            Stack<Character> stack = new Stack<>();
            // 초기 답변을 "yes"로 설정
            String answer = "yes";

            // 문자열을 한 글자씩 순회
            for (char v : s.toCharArray()) {
                switch (v) {
                    case ')':
                        // 닫는 소괄호를 만났을 때
                        if (stack.isEmpty() || stack.peek() != '(') {
                            answer = "no";
                            break;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        // 닫는 대괄호를 만났을 때
                        if (stack.isEmpty() || stack.peek() != '[') {
                            answer = "no";
                            break;
                        } else {
                            stack.pop();
                        }
                        break;
                    case '(':
                        // 여는 소괄호를 스택에 푸쉬
                        stack.push(v);
                        break;
                    case '[':
                        // 여는 대괄호를 스택에 푸쉬
                        stack.push(v);
                        break;
                }
                // "no"가 결정되면 반복 종료
                if (answer.equals("no")) {
                    break;
                }
            }
            // 모든 괄호를 처리한 후에도 스택이 비어있지 않으면 "no"로 설정
            if (!stack.isEmpty()) {
                answer = "no";
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
