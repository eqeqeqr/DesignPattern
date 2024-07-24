package org.example;
/**
* 简单工厂模式
* */
public class SimpleFactory {
    public static void main(String[] args) {
        Product a = Factory.createProduct("A");
        a.info();
        Product b = Factory.createProduct("B");
        b.info();
        Product c = Factory.createProduct("C");
        c.info();//这个是没有的
    }
}
class Factory{
    public static Product createProduct(String type) {
        Product product=null;
        switch (type) {
            case "A":
                System.out.println("正在创建A产品");
                product=new ProductA();
                break;
            case "B":
                System.out.println("正在创建B产品");
                product=new ProductB();
                break;
            default:
                System.out.println("没有这个"+type+"产品");
                break;
        }
        return product;
    }
}
abstract class Product
 {
    abstract void info();

}
//class ProductA extends Product
class ProductA extends Product {

    @Override
    public void info() {
        System.out.println("Product:A");
    }
}

class ProductB extends Product {
    @Override
    public void info() {
        System.out.println("Product:B");
    }
}