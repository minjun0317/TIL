package chap02;

public class d0823Hello {
    static void main(String[] args) {
        add(10, 5);

        System.out.println("안녕 " + (97 + 3));

        String hello = "안녕!";
        System.out.println(hello);
    }

    /**
     * 두 정수를 전달 받아 합을 구함.
     * @param a 첫번째 정수
     * @param b 두번째 정수
     * @return 두 정수의 합
     */

    public static int add(int a,int b) {
        return a + b;
    }
}
