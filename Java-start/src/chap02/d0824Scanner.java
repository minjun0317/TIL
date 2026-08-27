package chap02;

import java.util.Scanner;

public class d0824Scanner {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.printf("%d * %d = %d 입니다.\n",x,y,x*y);
        System.out.println(x+" * "+y+" = "+x*y+" " +
                "입니다");
    }
}
