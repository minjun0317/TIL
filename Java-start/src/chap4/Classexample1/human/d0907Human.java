package chap4.Classexample1.human;

public class d0907Human {
    String name;
    int height;
    int weight;

    public d0907Human(String n, int height, int weight) {
        name = n;
        this.height = height;
        this.weight = weight;
    }

    void print(){
        System.out.println("이름 : "+name+" 신장 : "+height+" 체중 : "+weight);
    }
}

