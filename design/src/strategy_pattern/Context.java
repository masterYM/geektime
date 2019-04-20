package strategy_pattern;

public class Context {
    //抽象策略
    private IStrategy strategy = null;

    //构造函数设置具体策略
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything(){
        this.strategy.doSomething();
    }
}
