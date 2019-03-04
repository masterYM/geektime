package day01;

/**
 * 多核cpu的缓存与内存关系图
 */
public class Test {

    private long count = 0;

    private /*synchronized*/ void add10k(){
        int idx = 0;
        while (idx++<10000){
            count += 1;
        }
    }

    public static  long calc() throws InterruptedException{
        final Test test = new Test();
        //创建两个线程，执行add()操作
        Thread thread1 = new Thread(()->{
            test.add10k();
        });
        Thread thread2 = new Thread(()->{
          test.add10k();
        });
        thread1.start();
        thread2.start();
        //等待两个线程执行结束
        thread1.join();
        thread2.join();
        return test.count;
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println(calc());
    }
}
