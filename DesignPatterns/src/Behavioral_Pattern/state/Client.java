package Behavioral_Pattern.state;

public class Client {
    public static void main(String[] args) {
        // 初始化，机器中有5个糖果，此时状态为noQuarterState
        GumballMachine gumballMachine = new GumballMachine(5);

        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 转动手柄，转为soldState；出糖果，转为noQuarterState，剩余4个糖果
        gumballMachine.turnCrank();

        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 退款，转为noQuarterState
        gumballMachine.ejectQuarter();
        // 转动手柄，提示错误
        gumballMachine.turnCrank();

        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 转动手柄，转为soldState；出糖果，转为noQuarterState，剩余3个糖果
        gumballMachine.turnCrank();
        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 转动手柄，转为soldState；出糖果，转为noQuarterState，剩余2个糖果
        gumballMachine.turnCrank();
        // 退款，无硬币，提示错误
        gumballMachine.ejectQuarter();

        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 投币，提示投币错误
        gumballMachine.insertQuarter();
        // 转动手柄，转为soldState；出糖果，转为noQuarterState，剩余1个糖果
        gumballMachine.turnCrank();
        // 投币，转为hasQuarterState
        gumballMachine.insertQuarter();
        // 转动手柄，转为soldState；出糖果，转为soldOutState，剩余0个糖果
        gumballMachine.turnCrank();
        // 投币，提示错误，因为没有糖果了
        gumballMachine.insertQuarter();
        // 转动手柄，出糖果，提示错误
        gumballMachine.turnCrank();
    }
}
