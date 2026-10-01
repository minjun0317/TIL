package chap4.Classexample1.student;

public class d0903StudentMain {
    static void main(String[] args) {
        d0903Student s1 = new d0903Student();
        d0903Student s2 = new d0903Student();
        s1.name = "학생1";
        s1.age = 17;
        s1.grade = 80;

        s2.name = "학생2";
        s2.age = 17;
        s2.grade = 90;

        System.out.println(s1);
        System.out.println(s2);
        s1 = s2;
        s1.age = 18;

        s1.method1();
        s2.method1();

        System.out.println("이름 : "+s1.name+" 나이 : "+s1.age+" 성적 : "+s1.grade);
        System.out.println("이름 : "+s2.name+" 나이 : "+s2.age+" 성적 : "+s2.grade);
    }
}
