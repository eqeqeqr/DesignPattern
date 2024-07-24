package org.example;
/**
 * 抽象工厂模式
 * */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 创建工厂 factory 1
        System.out.println("工厂1创建AB产品的1类");
        AFP_Factory factory1 = new AFP_FactoryA();
        AFP_ProductA productA1 = factory1.createProductA();
        productA1.info();
        AFP_ProductB productB1 = factory1.createProductB();
        productB1.info();

        //创建工厂 factory 2
        System.out.println("工厂2创建AB产品的2类");
        AFP_Factory factory2=new AFP_FactoryB();
        AFP_ProductA productA2 = factory2.createProductA();
        productA2.info();
        AFP_ProductB productB2 = factory2.createProductB();
        productB2.info();
    }
}

interface AFP_Factory {
    public AFP_ProductA createProductA();
    public AFP_ProductB createProductB();
}
class AFP_FactoryA implements AFP_Factory {
    @Override
    public AFP_ProductA createProductA()
    {
        return new AFP_ProductA1();
    }
    @Override
    public AFP_ProductB createProductB()
    {
        return new AFP_ProductB1();
    }
}
class AFP_FactoryB implements AFP_Factory {
    @Override
    public AFP_ProductA createProductA()
    {
        return new AFP_ProductA2();
    }
    @Override
    public AFP_ProductB createProductB()
    {
        return new AFP_ProductB2();
    }
}
interface AFP_ProductA {
    public void info();
}
class AFP_ProductA1 implements AFP_ProductA {
    @Override
    public void info()
    {
        System.out.println("产品：A1");
    }
}
class AFP_ProductA2 implements AFP_ProductA {
    @Override
    public void info()
    {
        System.out.println("产品：A2");
    }
}
interface AFP_ProductB {
    public void info();
}
class AFP_ProductB1 implements AFP_ProductB {
    @Override
    public void info()
    {
        System.out.println("产品：B1");
    }
}
class AFP_ProductB2 implements AFP_ProductB {
    @Override
    public void info()
    {
        System.out.println("产品：B2");
    }
}