package chap02;

public class d0824Cast {
    static void main(String[] args) {
        byte b = 20;
        int i = 300;
        if (i < Byte.MIN_VALUE || i > Byte.MAX_VALUE){
            System.out.println("byte타입 변환 X");
        }
        else{
            b = (byte)i;
        }
        System.out.println("b = "+b);
    }

}
