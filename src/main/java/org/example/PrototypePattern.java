package org.example;
/**
 * 原型模式
 * */
public class PrototypePattern {
    public static void main(String[] args) {
        P_Product p1=new P_Product(1,"product1",100);
        System.out.println("p1 : "+  p1.toString());
        //复制一份p1给p2
        P_Product p2 =(P_Product) p1.clone();
        System.out.println( "p2 : "+ p2.toString());
        P_Product p3 =(P_Product) p1.clone();
        System.out.println("p3 : "+ p3.toString());
        System.out.println("判断p1,p2,p3是否地址相同，不相同则符合预期");

        System.out.println("p1==p2 : "+(p1==p2));
        System.out.println("p1==p3 : "+(p1==p3));
        System.out.println("p2==p3 : "+(p2==p3));
    }
}
interface Prototype {
    public Object clone();
}
//官方提供 接口Cloneable 来实现克隆一个实例
class P_Product implements Prototype {
    private int id;
    private String name;
    private double price;
    public  P_Product(){}
    public P_Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Object clone()
    {
        P_Product obj=new P_Product();
        obj.id=this.id;
        obj.name=this.name;
        obj.price=this.price;
        return obj;
    }

    @Override
    public String toString() {
        return "P_Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
