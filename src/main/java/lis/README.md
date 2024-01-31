### LIS (최장 증가 부분 수열)

#### LIS란?

최장 증가 부분 수열, 또는 가장 긴 증가하는 부분 수열이라 불린다.  
LIS는 주어진 수열에서 오름차순으로 정렬된 가장 긴 부분 수열을 찾는 알고리즘이다. 다만, 오름차순으로 정렬된
부분 수열이 연속적이건, 유일할 필요는 없다.

풀이 방법으로는 DP를 활용한 방법과 이진 탐색을 활용한 방법이 있다.
DP를 활용하면 조금 더 단순하지만, 시간 복잡도가 `O(n^2)` 이고 이진탐색을 활용하면 구현하기엔 좀 더 복잡하지만
시간 복잡도는 `O(n logn)`이다.


arr = {10,20,10,30,20,50}

일때 dp[i] = i 번째 수를 마지막 원소로 가지는 LIS 길이라고 하겠다.
LIS의 길이를 구하는 방법은 i번째 원소를 0~ i-1 번째 원소들과 비교해 i번째 원소보다 작은 원소들의 dp값들 중 가장 큰 값 + 1을
dp[i] 로 기록하면 된다.

다음은 구현 코드이다.

```
public class Main {

    static int n;
    static int[] arr;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        //최대 LIS 값
        int max = 1;
        
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; i++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Matn.max(max, dp[i]);
        }
    }
    
    System.out.println(max);
}

```
