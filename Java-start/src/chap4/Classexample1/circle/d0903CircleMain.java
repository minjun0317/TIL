package chap4.Classexample1.circle;

public class d0903CircleMain {
    static void main(String[] args) {
        d0903Circle c = new d0903Circle();

        c.setRadius(10.0);
        System.out.println(c.getRadius());

        c.show(c.getRadius(), c.findArea());

    }
}
