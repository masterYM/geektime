package p_c_patterns.condition_sort;


/**
 * 用condition 实现顺序打印
 */
public class Run {

    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA[] threadAS = new ThreadA[5];
        ThreadB[] threadBS = new ThreadB[5];
        ThreadC[] threadCS = new ThreadC[5];

        for(int i = 0;i < 5;i++){
            threadAS[i] = new ThreadA(myService);
            threadBS[i] = new ThreadB(myService);
            threadCS[i] = new ThreadC(myService);
            threadAS[i].start();
            threadBS[i].start();
            threadCS[i].start();
        }

    }
}
