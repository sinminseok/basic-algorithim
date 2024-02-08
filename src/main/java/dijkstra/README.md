### 다익스트라 알고리즘

----
다익스트라 알고리즘은 그래프의 **최단거리**를 구하는 알고리즘이다.
다익스트라 알고리즘의 사용 용도는 특정한 하나의 정점에서 다른 모든 정점으로 가는 모든 경로를 알려준다.

다만 하나의 조건이 있는데 바로 `음의 간선`이 존재하지 않아야 한다. 
즉 가중치가 음수이면 안된다.

해당 글에서 설명할 다익스트라 알고리즘 구현 방식은 `우선순위 큐`를 이용할거다. 
인접 행렬을 이용해 구현할 수 있으나 시간복잡도 측면에서 인접 행렬방식이 우선순위 큐를 이용하는 것보다 불리하기에 우선 순위 큐 구현방식을 연습하는게 좋을거 같다.

----
### 우선 순위 큐(PriorityQueue) 가 뭘까 ?

우선 순위 큐는 요소들이 `우선 순위`에 따라 자동 정렬되어 있어서 가장 높은 우선 순위를 가진 요소가 항상 큐 앞에 위치하게 된다.  
다익스트라 알고리즘을 구현하는 과정에서 사용되는 우선 순위는 가중치가 작은게 기준이다.  
즉 가중치가 작을 수록 우선순위 큐 앞에 위치하게 된다.

Java 에선 `PriorityQueue` 라는 클래스를 사용해 우선순위 큐를 구현한다.  
이외에 내장 메서드들은 기존의 `Queue`에 있는 메서드들과 비슷하니 설명은 생략하겠다.


-----

### 다익스트라 알고리즘 구현 과정

1) 출발 노드 설정
2) 최단 거리 테이블 초기화
3) 방문하지 않은 노드들 중에서 최단 거리가 가장 짧은 노드를 선택한다.
4) 해당 노드를 거쳐 다른 노드로 가는 비용을 계산해 최단 거리 테이블을 갱신한다.
5) 3,4 과정을 반복한다.

----
### 구현 WITH JAVA

[//]: # (`pq`는 `우선순위 큐`로 정점과 출발지에서 정점까지 가는 최소 거리를 저장한다. 우선순위는 거리가 짧을 수록 높다.  )

[//]: # ()
[//]: # (`visited`는 boolean 배열로 해당 정점을 방문하는지 체크한다.  )

[//]: # ()
[//]: # (`distance`는 출발지에서 최소 거리를 기록하는 int 형 배열이다.   )

[//]: # ()
[//]: # (그래프는 ArrayList<Node>를 배열에 넣어 인접 리스트로 구현한다.)


#### Node class 

Comparable 를 상속받아 compareTo 메서드를 오버라이드 받는 이유는
우선 순위 큐에서 가중치를 기준으로 비교해야 하기때문이다.

```
class Node implements Comparable<Node>{
    int index;
    int cost;
    
    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    
    @override
    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }
}
```

#### 입력 받기

그래프는 `ArrayList<Node>[] graph` 인접 리스트로 구현한다.  

즉 `graph[2]` 안에 `Node(3, 5), Node(4, 10)` 두개의 노드가 있다면
2번 노드에서 3번 노드로 가는 가중치가 5, 2번 노드에서 4번 노드로 가는 가중치가 10 이다.

```
static ArrayList<Node> [] graph;

public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parse(bf.readLine()); // 노드 개수
    int m = Integer.parse(bf.readLine()); // 간선 개수
    
   graph = new ArrayList[n + 1];     
   
   for(int i=0; i <= n; i++) graph[i] = new ArrayList<>();
   
   StringTokenizer st;
   
   for(int i=0; i < m; i++){
        st = new StringTokenizer(bf.readLine());
        int v = Integer.parse(st.nextToken());  // 출발 노드 인덱스
        int w = Integer.parse(st.nextToken()); // 도착 노드 인덱스
        int cost = Integer.parse(st.nextToken()); // 가중치
        
        graph[v].add(new Node(w, cost)); // 인접 리스트에 간선 정보 입력
   }
   
   int start = Integer.parseInt(bf.readLine()); // 출발 노드 입력
   
   dijkstra(n, start)// 다익스트라 알고리즘 메서드 호출

}
```

#### 다익스트라 메서드



```
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

```

---- 

#### 전체 코드

```
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
```

