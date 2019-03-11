package day01;

/**
 * 32位得机器上对long型变量进行加减操作存在并发隐患，因为long类型是64位得，对long 类型进行操作通常需要多条指令组合出来，无法保证原子性。
 *
 * 一条语句得执行可能涉及多条cup指令，一条cpu指令才是一个原子操作，不是一条语句，所以一句代码可能导致并发问题
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
          try {
              Thread.sleep(5000);
          }catch (InterruptedException e){

          }

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
