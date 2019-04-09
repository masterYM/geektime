package day03;



public class Main {
    public static void main(String[] args) throws InterruptedException{
//        Account a = new Account(100);
//        Account b = new Account(100);

        Account_1 a = new Account_1(100);
        Account_1 b = new Account_1(100);

//        Account_2 a = new Account_2(100);
//        Account_2 b = new Account_2(100);

        Thread thread = new Thread(()->{
            a.transfer(b,5);
        });
        Thread thread1 = new Thread(()->{
            b.transfer(a,50);
        });
        long start = System.currentTimeMillis();
       thread.start();
       thread1.start();
       thread.join();
       thread1.join();
        long end = System.currentTimeMillis();
        System.out.println("A : " + a.getBalance());
        System.out.println("B : " + b.getBalance());
        System.out.println(end-start);

    }
}
