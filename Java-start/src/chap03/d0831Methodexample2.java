package chap03;

public class d0831Methodexample2 {
    static void main(String[] args) {
        System.out.println("합(1 ~ 10) : "+ sum (1,10));

    }

    public static int sum(int x, int y){
        int s = 0; // 합 0 -> 곱 -> 1
        for (int i = x; i <= y; i++){
            s += i;
        }
        return s;
    }
}
