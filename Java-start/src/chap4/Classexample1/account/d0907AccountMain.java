package chap4.Classexample1.account;

public class d0907AccountMain {
    public static void main(String[] args) {
        d0907Account acc1 = new d0907Account();
        acc1.setAccountNumber("110-123-456789");
        acc1.setOwner("홍길동");
        acc1.setBalance(10000);

        acc1.print();

        acc1.deposit(5000);
        acc1.withdraw(3000);
        acc1.withdraw(50000);   // 잔액 부족 테스트
        acc1.deposit(-100);     // 잘못된 입금 테스트

        acc1.print();
    }
}