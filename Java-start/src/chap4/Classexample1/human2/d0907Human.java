// d0907Human.java (print 메서드 추가)
package chap4.Classexample1.human2;

public class d0907Human {
    private String name;
    private int height;
    private int weight;

    public d0907Human setName(String name) {
        this.name = name;
        return this;
    }

    public d0907Human setHeight(int height) {
        this.height = height;
        return this;
    }

    public d0907Human setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void print() {
        System.out.println("이름: " + name + ", 키: " + height + ", 몸무게: " + weight);
    }
}