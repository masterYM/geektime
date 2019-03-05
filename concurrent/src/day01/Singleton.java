package day01;

public class Singleton {

    static /*volatile*/ Singleton instance;

    static Singleton getInstance(){

        if(instance == null){  //

            synchronized (Singleton.class){

                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
