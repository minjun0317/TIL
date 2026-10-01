package chap4.Classexample1.day;

public class d0903Student {
    String name;
    int age;
    int grade;
    static int num = 0;

    public d0903Student(String name, int age, int g){
        num++;
        this.name = name;
        this.age = age;
        grade = g;

    }

    public d0903Student(String name, int age){
        this(name, age, 100);
        this.age = age;

    }

    void print(){
        System.out.println("이름 : "+name +" 나이 : "+age +" 성적 : "+grade);
    }
}
