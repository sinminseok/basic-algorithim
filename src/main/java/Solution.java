
import java.util.*;

class Solution {
    static int n;
    static int k;
    static int answer = 0;
    static int[] cnt = new int[100001];

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        k  = kb.nextInt();

        int start = 0;
        int end = 0;
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i]  = kb.nextInt();
        }


        while(start <= end) {
            while(end < arr.length && cnt[arr[end]] + 1 <= k) {
                cnt[arr[end]] ++;
                end++;
            }
            int len = end-start;
            answer = Math.max(answer, len);
            cnt[arr[start]] --;
            start ++;

        }

        System.out.println(answer);


    }



}
    
 