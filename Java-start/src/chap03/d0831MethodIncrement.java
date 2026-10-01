package chap03;

public class d0831MethodIncrement {
    static void main(String[] args) {
        int x = 0;
        System.out.println("메서드 호출하기 전 x = "+x);
        increment(x);
        System.out.println("메서드 호출 후 x = "+x);
    }

    public static void increment(int n) {
        System.out.println("메서드 시작할 때의 n = "+n);
        n++; // ++n == n++; --> n = n + 1
        System.out.println("메서드 끝날 때의 n = "+n);
    }
}
