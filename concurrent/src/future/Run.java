package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Result r = new Result();
        String a = "a";
        r.setA(a);
        Future<Result> future = executor.submit(new Task(r),r);
        Result fr = future.get();

        System.out.println(fr == r);
        System.out.println(fr.getA() == a);
        System.out.println(fr.getB() == "x");
    }

    static class Task implements Runnable{
        Result r;
        Task(Result r){
            this.r = r;
        }

        @Override
        public void run() {
            String a = r.getA();
            String x = "x";
            r.setB(x);
        }
    }

    static class Result{
        private String b;
        private String a;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getA() {
            return a;
        }

        public void setA(String aaa) {
            this.a = aaa;
        }
    }
}
