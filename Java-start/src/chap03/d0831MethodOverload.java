package chap03;

public class d0831MethodOverload {
    static void main(String[] args) {
        System.out.println("max(3,7) = "+max(3,7));
        System.out.println("max(7.0,3.0) = "+max(7.0,3.0));
        System.out.println("max(3,7) = "+max(3,7,10));

    }
    public static int max(int a, int b){
        System.out.println("1번 호출");
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public static double max(double a, double b){
        System.out.println("2번 호출");
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public static int max(int a, int b, int c){
        System.out.println("3번 호출");
        return max(max(a,b),c);
    }
}
