package Behavioral_Pattern.memento;

/**
 * 备忘录模式
 * 在不违反封装的情况下获得对象的内部状态，从而在需要时可以将对象恢复到最初状态。
 * 以下实现了一个简单计算器程序，可以输入两个值，然后计算这两个值的和。
 * 备忘录模式允许将这两个值存储起来，然后在某个时刻用存储的状态进行恢复。
 *
 * Originator：原始对象
 * Caretaker：负责保存好备忘录
 * Memento：备忘录，存储原始对象的的状态。
 *    备忘录实际上有两个接口，一个是提供给 Caretaker 的窄接口：它只能将备忘录传递给其它对象；
 *    一个是提供给 Originator 的宽接口，允许它访问到先前状态所需的所有数据。理想情况是只允许 Originator 访问本备忘录的内部状态。
 */
public interface Calculator {

    // Create Memento
    PreviousCalculationToCareTaker backupLastCalculation();

    // setMemento
    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);

}
