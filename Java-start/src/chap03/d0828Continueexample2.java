package chap03;

public class d0828Continueexample2 {
    static void main(String[] args) {
        int i = 0;

        do {
            i++;

            if (i % 2 == 0)
                continue;

            System.out.println(i);

        } while (i < 10);
    }
}
