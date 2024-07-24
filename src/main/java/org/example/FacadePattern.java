package org.example;
/**
 * 外观模式
 * */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.MethodA();
        facade.MethodB();
        facade.MethodC();
    }
}
class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();

    }
    public void MethodA(){
        subSystemOne.MethodOne();
    }
    public void MethodB(){
        subSystemTwo.MethodTwo();
    }
    public void MethodC(){
        subSystemThree.MethodThree();
    }


}
class SubSystemOne {
    public void MethodOne(){
        System.out.println("执行子系统方法一");
    }
}
class SubSystemTwo {
    public void MethodTwo(){
        System.out.println("执行子系统方法二");
    }

}
class SubSystemThree {
    public void MethodThree(){
        System.out.println("执行子系统方法三");
    }
}