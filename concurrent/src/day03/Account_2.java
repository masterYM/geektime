package day03;

/**
 * 破坏循环等待条件 ---- 破坏这个条件，需要对资源进行排序，然后按序申请资源
 */

public class Account_2 {
    private int balance;
    private int id;

    public Account_2(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }


    //转账
    void transfer(Account_2 target, int amt){
        Account_2 left = this;
        Account_2 right = target;
        if(this.id > right.id){
            left = target;
            right = this;
        }
        //锁定序号小的账户
        synchronized (left){
            //锁定序号大的账户
            synchronized (right){
                if(this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
