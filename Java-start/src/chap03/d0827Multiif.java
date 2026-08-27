package chap03;

import java.util.Scanner;

public class d0827Multiif {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String grade;
        System.out.println("정수를 입력하세요 : ");
        int number = input.nextInt();

        if(number >= 90)
            grade = "A";
        else if (number >= 80)
            grade = "B";
        else if (number >= 70)
            grade = "C";
        else if (number >= 60)
            grade = "D";
        else
            grade = "F";
        System.out.println("당신의 학점은 "+grade);
    }
}
