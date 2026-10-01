package chap03;

public class d0828Forexample2 {
    static void main(String[] args) {
        for(int i=2; i<=9; i++) { //가로줄
            for(int j=1; j<=9; j++) { //세로줄
                System.out.printf("%4d",i*j);
                break;
            }
            System.out.println();
        }
    }
}
