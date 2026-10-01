package chap4.Classexample1.account;

public class d0907Account {
    private String accountNumber;
    private String owner;
    private int balance;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("입금액은 0보다 커야 합니다.");
            return;
        }
        balance += amount;
        System.out.println(amount + "원 입금 완료. 현재 잔액: " + balance + "원");
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("출금액은 0보다 커야 합니다.");
            return;
        }
        if (amount > balance) {
            System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
            return;
        }
        balance -= amount;
        System.out.println(amount + "원 출금 완료. 현재 잔액: " + balance + "원");
    }

    public void print() {
        System.out.println("계좌번호: " + accountNumber + ", 예금주: " + owner + ", 잔액: " + balance + "원");
    }
}