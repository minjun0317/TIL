package chap03;

import java.util.Scanner;

public class d0831Factorialexample2 {
    static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(1, 5));
        System.out.println(factorial(3, 5));
        System.out.println(factorial(10, 5));

    }
    public static int factorial(int n){
        System.out.println("1번 호출");
        int f = 1; // 곱은 반드시 1로 시작

        for (int i = n; i > 0; i--){
            f *= i;
        }
        return f;
    }
    public static int factorial(int a, int b){
        System.out.println("2번 호출");
        int f = 1; // 곱은 반드시 1로 시작

        for (int i = b; i >= a; i--){
            f *= i;
        }
        return f;
    }
}

