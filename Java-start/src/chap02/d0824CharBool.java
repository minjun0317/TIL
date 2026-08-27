package chap02;

public class d0824CharBool {
    static void main(String[] args) {
        char ga1 = '가';
        char ga2 = '\uac00';
        boolean cham = true;
        boolean geojit = false;

        System.out.println(ga1);
        System.out.println(ga2);
        System.out.println(cham+"가 아니면 "+geojit+"입니다.");
    }
}
