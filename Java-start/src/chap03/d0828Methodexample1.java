package chap03;

public class d0828Methodexample1 {
    static void main(String[] args) {
        int sum = 0; // 1 ~ n 합을 구할 때 0
        for(int i = 1; i <= 10; i++) {
            sum += i; // sum = sum + i
        }
        System.out.println("합(1~10) : "+sum); //+sum(x:1,y:10);

        sum = 0;
        for(int i = 10; i <= 100; i++) {
            sum += i; // sum = sum + i
        }
        System.out.println("합(10~100) : "+sum); //+sum(x:1,y:10);

        sum = 0;
        for(int i = 100; i <= 1000; i++) {
            sum += i; // sum = sum + i
        }
        System.out.println("합(100~1000) : "+sum); //+sum(x:1,y:10);
    }
    public static int sum(int x, int y) {
        int s = 0;
        for(int i=x; i<=y; i++){
            s += i; //sum = sum + i
        }
        return s;
    }
}
