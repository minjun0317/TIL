package chap4.Classexample1;

public class d0903Circle2 {
    double radius;

    double findArea(){
        return 3.14*radius*radius;
    }

    void show(double x, double y){
        System.out.println("반지름 =  "+x +" 원의 넓이 = "+y);
    }

    static void main(String[] args) {
        d0903Circle2 myCircle = new d0903Circle2();

        myCircle.radius = 10.0;

        myCircle.show(myCircle.radius, myCircle.findArea());
    }
}
