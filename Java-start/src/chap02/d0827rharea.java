package chap02;

import java.util.Scanner;

public class d0827rharea {
    static void main(String[] args) {
        double r,h,area;
        Scanner input = new Scanner(System.in);

        System.out.println("가로 길이 입력: ");
        r = input.nextDouble();

        System.out.println("세로 길이 입력: ");
        h = input.nextDouble();

        area = r * h;

        System.out.println("직사각형의 넚이는 "+area+"입니다.");
        System.out.printf("직사각형의 넓이는 %.1f입니다.",area);
    }
}
