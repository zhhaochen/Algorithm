package Behavioral_Pattern.interpreter;

/**
 * 解释器模式
 * 为语言创建解释器，通常由语言的语法和语法分析来定义。
 * TerminalExpression：终结符表达式，每个终结符都需要一个 TerminalExpression。
 * Context：上下文，包含解释器之外的一些全局信息。
 * 这里的 Context 指的是 String。
 * 这种模式被用在 SQL 解析、符号处理引擎等
 */
public abstract class Expression {
    public abstract boolean interpret(String str);
}
