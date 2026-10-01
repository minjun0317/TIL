package chap4.Classexample1.construct;

public class d0903MemberConstructMain {
    static void main(String[] args) {
        d0903MemberConstruct m = new d0903MemberConstruct("홍길동",17,90);
        d0903MemberConstruct y = new d0903MemberConstruct("홍길동",17,90);

        /*
        m.name = "학생1";
        m.age = 15;
         */

        System.out.println(m.name + m.age + m.grade);
        System.out.println("이름 : "+m.name +" 나이 :"+m.age +" 성적 : "+m.grade);
        System.out.println("이름 : "+y.name +" 나이 :"+y.age +" 성적 : "+y.grade);
    }
}
