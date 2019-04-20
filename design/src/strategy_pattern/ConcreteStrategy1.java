package strategy_pattern;

public class ConcreteStrategy1 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略1 的运算法则");
    }
}
