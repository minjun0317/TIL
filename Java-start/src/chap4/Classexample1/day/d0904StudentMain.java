package chap4.Classexample1.day;

public class d0904StudentMain {
    static void main(String[] args) {
        d0903Student s1 = new d0903Student("김하치와레",17,80);
        d0903Student s2 = new d0903Student("김하치와레",17);

        s1.print();
        s2.print();
        System.out.println(d0903Student.num);
    }
}
