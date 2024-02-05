package combination_permutation.permutation;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        int n = 2;
        int[] numbers = {1, 2, 3, 4, 5};
        List<List<Integer>> result = combi(n, numbers);

        // 결과 출력
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    private static List<List<Integer>> combi(int n, int[] numbers){
        List<List<Integer >> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack(result, currentCombination, numbers, 0, n);

        return result;
    }

    /*
    backtrack은 재귀적으로 호출되며, 현재 인덱스 start 부터 배열 numbers 끝까지 반복한다.
    currentCombination 리스트에 현재 인덱스의 값을 추가하고, 재귀적으로 다음 인덱스를 호출한다. 이때 길이가 n-1 인 조합을 생성하도록 한다.
    재귀 호출이 완료되면 현재 인덱스에 대한 조합 생성이 끝났고 currentCombination 리스트에서 마지막 앖을 제거한다.
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] numbers, int start, int n){
        if(n == 0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = start; i<numbers.length; i++){
            currentCombination.add(numbers[i]);

            backtrack(result, currentCombination, numbers, i+1, n-1);

            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
