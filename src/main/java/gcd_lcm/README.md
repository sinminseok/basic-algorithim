### 최대공약수(GCD), 최소공배수(LCM)

----

#### 최대 공약수

최대 공약수는 두 수의 공통된 약수 중에서 가장 큰 수를 말한다.

```

public class ArrayGCDCalculator {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 10};
        int result = calculateArrayGCD(arr);

        System.out.println("배열 요소의 최대공약수는 " + result + "입니다.");
    }

    // 배열 요소들의 최대공약수를 계산하는 메소드
    private static int calculateArrayGCD(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("배열이 비어있습니다.");
        }

        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = calculateGCD(gcd, arr[i]);
        }

        return gcd;
    }

    // 최대공약수를 계산하는 메소드 (유클리드 호제법 사용)
    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // 음수 방지를 위해 절댓값 취함
    }
}
```