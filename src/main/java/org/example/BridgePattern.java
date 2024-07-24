package org.example;
/**
 * 桥接模式
 * */
public class BridgePattern {
    public static void main(String[] args) {
        WebProduct webProductA=new WebProductA();//产品和颜色相互独立，可以独自扩展比如继承产品WebProduct然后创建一个WEB产品B
        webProductA.setName("A网站主题颜色");
        webProductA.setName("A网站主题颜色");
       // webProductA.setColor(new Red());//红色
        webProductA.setColor(new Blue());//蓝色
        webProductA.operation();
    }
}
abstract class WebProduct {
    protected String name;
    protected  Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color)
    {
        this.color=color;
    }
    public  abstract void operation();
}
class WebProductA extends WebProduct {
    @Override
    public void operation()
    {
        color.OperationImpl(this.name);
    }
}

interface Color {
    public void OperationImpl(String name);
}

class Red implements Color {
    @Override
    public void OperationImpl(String name)
    {
        System.out.println(name+" is red");
    }
}
class Blue implements Color {
    @Override
    public void OperationImpl(String name)
    {
        System.out.println(name+" is red");
    }
}
