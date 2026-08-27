package chap02;

import java.util.Scanner;

public class d0827example4 {
    static void main(String[] args) {
        int x; // 정수형
        double y; // 실수형 64비트
        String s; // 문자열

        Scanner input = new Scanner(System.in); // 입력 준비 객체생성

        x = input.nextInt();
        System.out.println("x = " + x);

        y = input.nextDouble();
        System.out.println("y = " + y);

        input.nextLine();

        s = input.nextLine();
        System.out.println("s = " + s);
    }
}
