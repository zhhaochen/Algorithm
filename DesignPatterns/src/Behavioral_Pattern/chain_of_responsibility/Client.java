package Behavioral_Pattern.chain_of_responsibility;

public class Client {
    public static void main(String[] args) {
        // 上级
        Handler handler1 = new ConcreteHandler1(null);
        // 下级
        Handler handler2 = new ConcreteHandler2(handler1);
        Request request1 = new Request(RequestType.TYPE1, "request1");
        // 下级处理不了request1，所以交给上级处理
        handler2.handleRequest(request1);
        //  下级自己能处理request2，自己就处理了
        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }
}
