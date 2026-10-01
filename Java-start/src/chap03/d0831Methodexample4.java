package chap03;

public class d0831Methodexample4 {
    static void main(String[] args) {
        echo("안녕", 3);
    }

    public static void echo(String s, int i){
        for (int j = 0; j < i; j++) {
            System.out.println(s);
        }
    }
}
