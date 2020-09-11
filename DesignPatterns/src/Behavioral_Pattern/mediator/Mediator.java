package Behavioral_Pattern.mediator;

/**
 * 中介者模式
 * 集中相关对象之间复杂的沟通和控制方式。
 * 当对象的事件产生时需要去操作其它对象，形成了依赖结构
 * 使对象之间解耦，但是中介者类因为要处理具体同事类的交互细节，会导致非常复杂
 */
public abstract class Mediator {
    public abstract void doEvent(String eventType);
}
