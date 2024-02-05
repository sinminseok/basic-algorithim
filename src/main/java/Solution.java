
import java.io.*;
import java.util.*;

public class Solution {
    static int T;

    static List<List<Integer>> STOCKS = new ArrayList<>();


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);


        T = kb.nextInt();
        long[] answer = new long[T];

        for (int i = 0; i < T; i++) {
            long n = kb.nextInt();
            List<Integer> stock = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stock.add(kb.nextInt());
            }
            STOCKS.add(stock);
        }

        for (int i = 0; i < T; i++) {
            answer[i] = solution(STOCKS.get(i));
        }

        for(int i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }


    }

    private static long solution(List<Integer> stock) {
        List<Integer> sortedStocks = new ArrayList<>(stock);
        Collections.sort(sortedStocks, Collections.reverseOrder());

        Queue<Integer> sortStocks = new LinkedList<>();

        for (int value : sortedStocks) {
            sortStocks.offer(value);
        }

        int maxStock = sortStocks.poll();

        List<Integer> buyStock = new ArrayList<>();
        int answer = 0;

        for (int bill : stock) {
            if (bill < maxStock) {
                buyStock.add(bill);
            } else {
                for (int sell : buyStock) {
                    answer += (maxStock - sell);
                }
                buyStock.clear();
                if (!sortStocks.isEmpty()) {
                    maxStock = sortStocks.poll();
                }
            }

        }


        return answer;
    }

}

