package strategy_pattern;

public class Client {
    public static void main(String[] args) {
        IStrategy strategy = new ConcreteStrategy1();
        Context context = new Context(strategy);
        context.doAnything();


        IStrategy strategy2 = new ConcreteStrategy2();
        Context context2 = new Context(strategy2);
        context2.doAnything();
    }
}
