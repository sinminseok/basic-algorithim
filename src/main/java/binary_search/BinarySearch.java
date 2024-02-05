package binary_search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = {10, 3, 4, 5, 6, 7, 2};

        System.out.println(binarySearch(numbers, 2));
    }

    //인덱스 반환
    private static int binarySearch(int[] numbers, int target) {
        //이진 탐색은 정렬된 배열에서만 적용 가능한 알고리즘이다.
        Arrays.sort(numbers);

        int start = 0;
        int end = numbers.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            int value = numbers[mid];
            if (value == target) {
                return value;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
