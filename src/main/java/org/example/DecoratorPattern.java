package org.example;
/**
 * 装饰器模式
 *
 * */
public class DecoratorPattern {
    public static void main(String[] args) {
        Person xiaoming=new Student("小明");
        xiaoming.Operation();//执行xiaoming学习动作
        DecoratorA decoratorA = new DecoratorA(xiaoming);
        System.out.println("\n分割线-------------------------------");
        decoratorA.Operation();//在xiaoming对象中添加额外的写作业动作
        System.out.println("\n分割线-------------------------------");
        DecoratorB decoratorB = new DecoratorB(decoratorA);
        decoratorB.Operation();//在decoratorA基础上继续添加考试的动作
        System.out.println("\n分割线-------------------------------");
        //对象链
        Person lisi=new DecoratorB(new DecoratorA(new Student("李四")));
        lisi.Operation();

    }
}


abstract class Decorator extends Person{
    protected Person person;

}
class DecoratorA extends Decorator{
    public DecoratorA(Person person){
        this.person=person;
    }
    @Override
    public void Operation(){
        person.Operation();//调用person对象的原先操作
        System.out.print(" 写作业 ");
    }
}
class DecoratorB extends Decorator{
    public DecoratorB(Person person){
        this.person=person;
    }
    @Override
    public void Operation(){
        person.Operation();//调用person对象的原先操作
        System.out.print(" 考试 ");
    }
}
abstract class Person{
    protected  String name;
    public abstract void Operation();
}
class Student extends  Person{
    public Student(String name){
        this.name=name;
    }
    @Override
    public void Operation(){
        System.out.print(name+":"+" 学习 ");
    }
}


