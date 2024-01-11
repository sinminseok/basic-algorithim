package combination_permutation.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
깊이를 1씩 증가키며 깊이에 따른 값을 넣어준다.
깊이와 N이 같을때 백트래킹을 종료하고 출력한다.

visit 배열을 사용해서 방문한 수는 재 방문하지 않도록 한다.
arr 배열을 만들어서 깊이에 따른 값을 저장한다.
 */

public class Main {

    static int n;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        visited = new boolean[n];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int depth) {
        if (depth == n) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                arr[depth] = i + 1;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}






































