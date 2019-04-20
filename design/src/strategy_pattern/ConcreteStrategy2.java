package strategy_pattern;

public class ConcreteStrategy2 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略2 的运算法则");
    }
}
