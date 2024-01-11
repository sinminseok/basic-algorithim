import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<Integer> visited = new ArrayList<>();

    public static int solution(String strings) {
        int answer = 0;
        List<Integer> numbers = new ArrayList<>();

        for (char x : strings.toCharArray()) {
            numbers.add(Character.getNumericValue(x));
        }

        for (int i = 0; i < numbers.size(); i++) {
            List<int[]> permutation = permutation(numbers, i+1);
            visited.clear();
            for (int[] x : permutation) {
                if (isDecimal(x)){
                    answer += 1;

                }
            }
        }
        return answer;
    }

    public static boolean isDecimal(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
        if(numbers.length == 1 && numbers[0] < 2){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            sb.append(numbers[i]);
        }
        int number = Integer.parseInt(sb.toString());
        // 2 부터 number 까지 전체 순회
        for (int i = 2; i < number; ++i) {
            // 나누어서 떨어진다면 약수
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static List<int[]> permutation(List<Integer> numbers, int count) {
        List<int[]> perList = new ArrayList<>();
        int[] result = new int[count];
        boolean[] used = new boolean[numbers.size()];
        calculatePermutation(numbers, count, perList, result, used, 0);
        return perList;
    }

    private static void calculatePermutation(List<Integer> numbers, int count, List<int[]> perList, int[] result, boolean[] used, int depth) {
        if (depth == count) {
            // 현재 결과를 리스트에 추가
            perList.add(result.clone());
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = numbers.get(i);
                calculatePermutation(numbers, count, perList, result, used, depth + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int solution = solution("011");
        System.out.println(solution);
    }
}



