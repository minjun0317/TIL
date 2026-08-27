package chap03;

import java.util.Scanner;

public class d0827If {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 : ");
        int number = in.nextInt();

        if (number % 2 == 0){
            System.out.println("짝수");
        }
        if (number % 2 == 1){
            System.out.println("홀수");
        }
        System.out.println("종료");

    }
}
