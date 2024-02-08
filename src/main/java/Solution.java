
import java.io.*;
import java.util.*;

public class Solution {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] m = new int[d][3];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(bf.readLine());
                m[i][0] = Integer.parseInt(st.nextToken()); //a
                m[i][1] = Integer.parseInt(st.nextToken()); //b
                m[i][2] = Integer.parseInt(st.nextToken()); //s
            }

            int[] answer = solution(n, d, c, m);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    private static int[] solution(int n, int d, int c, int[][] m) {
        int[] answer = new int[2];
        int count = 0;
        int second = 0;

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        ArrayList<Node>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < m.length; i++) {
            graph[m[i][1]].add(new Node(m[i][0], m[i][2]));
        }


        Arrays.fill(dist, INF);
        dist[c] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(c , 0));

        while(!pq.isEmpty()) {
            int nowIndex = pq.poll().index;

            if(visited[nowIndex]) continue;
            visited[nowIndex] = true;

            for(Node next : graph[nowIndex]) {
                if(dist[next.index] > dist[nowIndex] + next.cost) {
                    dist[next.index] = dist[nowIndex] + next.cost;
                    pq.add(new Node(next.index, dist[nowIndex] + next.cost));
                }
            }
        }


        for(int i=1; i<=n; i++) {
            if(dist[i] != INF) {
                count ++;
                second = Math.max(second, dist[i]);
            }
        }

        answer[0] = count;
        answer[1] = second;

        return answer;
    }




}

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}


