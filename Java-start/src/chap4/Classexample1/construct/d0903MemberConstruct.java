package chap4.Classexample1.construct;

public class d0903MemberConstruct {
    String name;
    int age;
    int grade;
    //new 클래스 ("홍길동",10,90)
    public d0903MemberConstruct(String name, int a, int g) {
        System.out.println("생성자 호출");

        this.name = name;
        age = a;
        grade = g;
    }

    public d0903MemberConstruct(String name){
            this(name,15,90);

    }
}
