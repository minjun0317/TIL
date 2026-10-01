// d0907HumanMain.java
package chap4.Classexample1.human2;

public class d0907HumanMain {
    static void main(String[] args) {
        d0907Human h1 = new d0907Human();
        h1.setName("홍길동");
        h1.setHeight(177);
        h1.setWeight(72);

        h1.print();
        h1.setName("길동").setHeight(177).setWeight(72).print();
    }
}