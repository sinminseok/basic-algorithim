package combination_permutation.combination;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        //4개중 2개를 선택할때
        //{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}
        List<int[]> combination = combination(2, arr);

        // 결과 출력
        for (int[] combo : combination) {
            System.out.print("{");
            for (int i = 0; i < combo.length; i++) {
                System.out.print(combo[i]);
                if (i < combo.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }

    public static List<int[]> combination(int count, int[] data) {
        List<int[]> combinationList = new ArrayList<>();
        generateCombination(combinationList, new int[count], 0, 0, data);
        return combinationList;
    }

    public static void generateCombination(List<int[]> combinationList, int[] currentCombo, int index, int start, int[] data) {
        if (index == currentCombo.length) {
            // 현재 조합을 결과 리스트에 추가
            combinationList.add(currentCombo.clone());
            return;
        }

        for (int i = start; i < data.length; i++) {
            currentCombo[index] = data[i];
            generateCombination(combinationList, currentCombo, index + 1, i + 1, data);
        }
    }
}
