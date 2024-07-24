package org.example;
/**
 * 工厂模式
 * */
public class FactoryPattern {
    public static void main(String[] args) {
        FP_Factory factoryA = new FP_FactoryA();
        FP_Product productA = factoryA.createProduct();
        productA.info();

        FP_Factory factoryB = new FP_FactoryB();
        FP_Product productB = factoryB.createProduct();
        productB.info();
    }

}

interface FP_Factory {
    public FP_Product createProduct();
}
class FP_FactoryA implements FP_Factory {
    @Override
    public FP_Product createProduct()
    {
        return new FP_ProductA();
    }
}
class FP_FactoryB implements FP_Factory {
    @Override
    public FP_Product createProduct()
    {
        return new FP_ProductB();
    }
}
interface FP_Product {
    public void info();
}
class FP_ProductA implements FP_Product {
    @Override
    public void info()
    {
        System.out.println("产品:A");
    }
}
class FP_ProductB implements FP_Product {
    @Override
    public void info()
    {
        System.out.println("产品:B");
    }
}