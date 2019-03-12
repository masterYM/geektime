package day03;



public class Main {
    public static void main(String[] args) {
        Account a = new Account(100);

        Account b = new Account(100);


        a.transfer(b,5);
        b.transfer(a,50);
        System.out.println("A : " + a.getBalance());
        System.out.println("B : " + b.getBalance());

    }
}
