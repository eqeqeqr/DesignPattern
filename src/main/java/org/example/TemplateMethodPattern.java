package org.example;
/**
 * 模板方法模式
 * */
public class TemplateMethodPattern {
    public static void main(String[] args) {

        People teachers = new Teachers();

        People students = new Students();

        students.templateMethod();
        System.out.println("上面学生=================下面老师");
        teachers.templateMethod();
    }
}
abstract class People {
    public void templateMethod(){
        System.out.println("上课 进入教室");//1
        primitiveOperation1();//2
        System.out.println("下课 离开教室");// 3
        primitiveOperation2();// 4
    }
    public abstract void primitiveOperation1();//原语操作1：上课过程 学生 听课..... 老师 讲课.......
    public abstract void primitiveOperation2();//原语操作1：下课过程 学生 回寝室..... 老师 回办公室.......
}
class Teachers extends People {

    @Override
    public void primitiveOperation1() {
        System.out.println("老师 讲课.....");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("老师 回办公室.....");
    }
}
class Students extends People {

    @Override
    public void primitiveOperation1() {
        System.out.println("学生 听课.....");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("学生 回寝室.....");
    }
}
