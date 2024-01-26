import java.util.*;

class Solution {


    public String[] solution(String[] orders, int[] courses) {

        List<String> answer = new ArrayList<>();
        String asd = "DASF";
        for (int course : courses) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < course) {
                    continue;
                } else {

                    List<List<Character>> chs = generateCombinations(order.toCharArray(), course);

                    for (List<Character> c : chs) {
                        String comb = parseOrder(c);
                        map.put(comb, map.getOrDefault(map.get(comb), 0) + 1);
                    }
                }

            }

            int maxCount = Integer.MIN_VALUE;
            String menuComb = "";

            for (String key : map.keySet()) {
                int count = map.get(key);
                if (count > maxCount) {
                    maxCount = count;
                    menuComb = key;
                }
            }

            if (maxCount >= 2) {
                answer.add(menuComb);
            }
        }

        String[] result = new String[answer.size()];

        System.out.println(answer.size());

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        Arrays.sort(result);

        return result;
    }

    public String parseOrder(List<Character> order) {
        StringBuilder sb = new StringBuilder();
        for (Character c : order) {
            sb.append(c);
        }
        return sb.toString();

    }

    public List<List<Character>> generateCombinations(char[] array, int n) {
        List<List<Character>> result = new ArrayList<>();
        generateCombinationsHelper(array, n, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinationsHelper(char[] array, int n, int start, List<Character> current, List<List<Character>> result) {
        if (n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= array.length - n; i++) {
            current.add(array[i]);
            generateCombinationsHelper(array, n - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}