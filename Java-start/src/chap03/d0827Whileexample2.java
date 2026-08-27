package chap03;

public class d0827Whileexample2 {
    static void main(String[] args) {
        int i = 2;

        while(i <= 9){
            int j = 1;
            while(j <= 9){
                System.out.printf("%-4d",i*j);
                j++;
            }
            System.out.println();
            i++;
        }

    }
}
