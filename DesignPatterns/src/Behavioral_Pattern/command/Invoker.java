package Behavioral_Pattern.command;

/**
 * 遥控器，发出不同指令
 * 使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活。
 * 发送者与接收者之间没有直接引用关系，发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求
 *
 * 比如吃烤肉串，消费者不需要盯着烤肉的师傅，只需要告诉服务员想要多少肉串，可以加也可以减，然后服务员一并让烤肉师傅烤
  */
public class Invoker {
    private Command[] onCommands;
    private Command[] offCommands;
    private final int slotNum = 7;

    public Invoker() {
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }

    public void setOnCommand(Command command, int slot) {
        onCommands[slot] = command;
    }

    public void setOffCommand(Command command, int slot) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

}
