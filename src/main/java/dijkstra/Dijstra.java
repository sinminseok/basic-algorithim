package dijkstra;

import java.io.*;
import java.util.*;

public class Dijstra {

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 노드 개수 입력
        int m = Integer.parseInt(bf.readLine()); // 간선 개수 입력

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>(); // 그래프 초기화

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken()); // 출발 노드 인덱스
            int w = Integer.parseInt(st.nextToken()); // 도착 노드 인덱스
            int cost = Integer.parseInt(st.nextToken()); // 가중치

            graph[v].add(new Node(w, cost)); // 인접 리스트에 간선 정보 입력
        }

        int start = Integer.parseInt(bf.readLine()); // 시작노드 설정

        dijkstra(n, start);
    }

    public static void dijkstra(int n, int start) {
        boolean[] visited = new boolean[n + 1]; // 방문 가록을 체크할 배열
        int[] distance = new int[n + 1]; // 최단 거리를 기록할 배열
        int INF = Integer.MAX_VALUE;

        Arrays.fill(distance, INF); // 최단 거리 배열 초기화
        distance[start] = 0; // 시작 지점의 최단거리는 0이다.

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0)); // 시작하는 노드를 큐에 삽입

        while(!pq.isEmpty()){
            int nowIndex = pq.poll().index;

            if(visited[nowIndex]) continue;
            visited[nowIndex] = true;

            for(Node next : graph[nowIndex]){
                if(distance[next.index] > distance[nowIndex] + next.cost){
                    distance[next.index] = distance[nowIndex] + next.cost;
                    pq.add(new Node(next.index, distance[next.index]));
                }
            }
        }

        // 결과 출력
        for(int i : distance){
            if(i == INF) System.out.print(0 + " ");
            else System.out.print(i+" ");
        }
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
        return Integer.compare(this.cost, o.cost);
    }
}

//input
//
//5
//9
//1 2 10
//1 3 5
//2 3 2
//3 1 1
//3 2 13
//4 1 8
//4 5 3
//5 4 9
//5 2 31
//4
//
//        출력 결과
//        0 8 18 13 0 3 //인덱스 0은 사용 x

