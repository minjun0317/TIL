package chap4.Classexample1;

public class d0903Circle {
    static double radius;

    static double findArea(){
        return 3.14*radius*radius;
    }

    static void show(double x, double y){
        System.out.println("반지름 =  "+x+" 원의 넓이 = "+y);
    }

    static void main(String[] args) {
        d0903Circle c = new d0903Circle();
        d0903Circle.radius = 10.0;

        double area = findArea();
        show(radius,area);
    }
}
