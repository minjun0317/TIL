package chap4.Classexample1.hh;

public class d0831Ballmain {
    static void main(String[] args) {
        d0831Ball b = new d0831Ball();
        d0831Ball a = new d0831Ball();
        b.radius = 4.0;
        System.out.println(b.radius);
        System.out.println(a.radius);

        System.out.println(a.getVolume());
        System.out.println(b.getVolume());
    }
}
