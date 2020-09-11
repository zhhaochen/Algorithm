package Behavioral_Pattern.memento;

public class Client {
    public static void main(String[] args) {
        // 计算开始
        Calculator calculator = new CalculatorImp();

        // 输入两个数
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);

        // 计算两个数的和
        System.out.println(calculator.getCalculationResult());

        // 将开始输入的两个数存入到备忘录中
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();

        // 重新定义输入的两个数
        calculator.setFirstNumber(17);

        // user enters a wrong second number and calculates result
        calculator.setSecondNumber(-290);

        // 计算新的值
        System.out.println(calculator.getCalculationResult());

        // 从备忘录中恢复开始输入的两个值
        calculator.restorePreviousCalculation(memento);

        // 计算
        System.out.println(calculator.getCalculationResult());
    }
}
