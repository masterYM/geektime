package list;

import java.util.ArrayList;

public class InitList {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        ArrayList<String> list = new ArrayList<>();//
//        ArrayList<String> list = new ArrayList<>(10000000);//
        for (int i = 0;i < 10000000;i++){
            list.add(""+i);
        }
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
