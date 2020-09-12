package Behavioral_Pattern.strategy;

/**
 * 策略模式
 * 定义一系列算法，封装每个算法，并使它们可以互换。
 * 策略模式可以让算法独立于使用它的客户端。
 *
 * 状态模式是通过状态转移来改变 Context 所组合的 State 对象，
 * 而策略模式是通过 Context 本身的决策来改变组合的 Strategy 对象
 *
 * 状态模式主要是用来解决状态转移的问题，当状态发生转移了，那么 Context 对象就会改变它的行为；
 * 而策略模式主要是用来封装一组可以互相替代的算法族，并且可以根据需要动态地去替换 Context 使用的算法
 */
// 设计一个鸭子，它可以动态地改变叫声。这里的算法族是鸭子的叫声行为。
public interface QuackBehavior {
    void quack();
}
