package org.example;
/**
 * 代理模式
 * */
public class ProxyPattern {


    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();
        Proxy proxy=new Proxy(realSubject);
        proxy.buy();
    }
}
interface Subject {
    public void buy();
}
class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject)
    {
        this.subject = subject;
    }
    @Override
    public void buy()
    {
        System.out.println("代理->真实商家->购买商品");
        subject.buy();//付钱购买
        System.out.println("代理->真实商家->购买商品->代理购买结束");
    }
}
class RealSubject implements Subject {
    @Override
    public void buy()
    {
        System.out.println("购买商品");
    }
}
