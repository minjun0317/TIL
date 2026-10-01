package chap4.Classexample1.circle;

public class d0903Circle {
    private double radius;

    public double getRadius(){
        return radius;
    } //접근자

    public void setRadius(double r) {
        this.radius = r;
    }

    double findArea(){
        return 3.14*radius*radius;
    }

    void show(double x, double y){
        System.out.println("반지름 =  "+x +" 원의 넓이 = "+y);
    }
}
