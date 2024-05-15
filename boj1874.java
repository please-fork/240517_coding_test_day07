// package boj1874;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 파일로부터 입력을 읽어오는 코드 (필요 시 주석 해제)
        // System.setIn(new FileInputStream("src/input.txt"));
        // 표준 입력을 통해 데이터를 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 효율적으로 처리하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 입력받을 수열의 길이 n
        int n = Integer.parseInt(br.readLine());
        // 목표 수열을 저장할 배열 생성
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = Integer.parseInt(br.readLine());
        }

        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 현재 숫자를 추적할 변수 초기화 (1부터 시작)
        int current = 1;

        // 목표 수열의 각 숫자를 처리
        for (int i = 0; i < n; i++) {
            int val = output[i];

            // 현재 숫자가 목표 값보다 작거나 같으면 스택에 push
            while (current <= val) {
                // 현재 숫자가 목표 값에 도달할 때까지 스택에 push
                stack.push(current++);
                // 스택에 값을 추가한 동작을 기록
                sb.append("+\n");
            }

            // 스택의 최상위 값이 목표 값과 같으면 pop
            if (stack.peek() == val) {
                // 목표 수열의 값을 만들기 위해 스택에서 최상위 값을 제거
                stack.pop();
                // 스택에서 값을 제거한 동작을 기록
                sb.append("-\n");
            } else {
                // 스택의 최상위 값이 목표 값과 다르면 목표 수열을 만들 수 없음
                // 이 경우 "NO"를 출력하고 프로그램을 종료
                sb.setLength(0); // 기존 기록을 지우고
                sb.append("NO\n"); // "NO"를 기록
                break;
            }
        }

        // 모든 동작을 기록한 후 출력
        System.out.print(sb.toString());
        // 리소스 해제
        br.close();
    }
}
