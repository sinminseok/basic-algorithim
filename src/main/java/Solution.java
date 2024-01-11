import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> setNumbers = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                setNumbers.add(numbers[i] + numbers[j]);
            }
        }
        return setNumbers.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    }