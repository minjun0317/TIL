package chap03;

import java.util.Scanner;

public class d0831Factorialexample1 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("입력 : ");
        int num = in.nextInt(); // 정수 입력

        System.out.printf("%d! 값은 = %d",num,factorial(num));

    }
    public static int factorial(int n){
        int f = 1; // 곱은 반드시 1로 시작

        for (int i = n; i > 0; i--){
            f *= i;
        }
        return f;
    }
}
