package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 * 通过将操作封装到访问者对象中，从而分离对象的数据结构和行为，作用就是将
 * 举例：我不需要在每个数据结构中比如老师和学生类中写各种计算年龄方法，我把这个计算老师年龄的方法封装到访问者1中，
 *
 *
 * 不使用访问者模式：
 * 将每个操作直接写在数据结构类中，导致每次增加新的操作时，都需要修改数据结构类。
 * 这会使得类变得臃肿，职责不清晰，扩展性差。
 *
 * 使用访问者模式：
 * 将操作封装在访问者中，数据结构类只需提供一个接受访问者的方法。
 * 这使得代码更具扩展性和可维护性，添加新的操作时只需增加新的访问者类，而无需修改现有的数据结构类。
 *
 * */
public class VisitorPattern {
    public static void main(String[] args) {
        PeopleStructure peopleStructure=new PeopleStructure();
        Visitor1 visitor1=new Visitor1();
        Visitor2 visitor2=new Visitor2();
        //访问者1的记录
        System.out.println("访问者1的记录（计算出学生和老师的年龄总和）");
        peopleStructure.accept(visitor1);
        System.out.println("学生年龄总和： "+visitor1.getStudentAgeSum()+" 老师年龄总和： "+visitor1.getTeacherAgeSum());
        System.out.println("========================");
        //访问者2的记录
        System.out.println("访问者2的记录（找出最大学生成绩和老师工龄）");
        peopleStructure.accept(visitor2);
        System.out.println("学生最高成绩： "+visitor2.getMaxScore()+" 老师最高工龄： "+visitor2.getMaxWorkYear());
    }
}
interface Visitor {
    public void visitTeacher(TeacherVP teacherVP);//访问老师
    public void visitStudent(StudentVP studentVP);//访问老师
}

class Visitor1 implements Visitor{//访问者1 分别统计学生和老师的年龄总和
    private int studentAgeSum=0;
    private int teacherAgeSum=0;

    @Override
    public void visitTeacher(TeacherVP teacherVP){
        System.out.println("访问者1访问老师 "+teacherVP.getName()+"年龄 "+teacherVP.getAge());
        teacherAgeSum+=teacherVP.getAge();
    }
    @Override
    public void visitStudent(StudentVP studentVP){
        System.out.println("访问者1访问学生 "+studentVP.getName()+"年龄 "+studentVP.getAge());
        studentAgeSum+=studentVP.getAge();
    }
    public int getStudentAgeSum() {
        return studentAgeSum;
    }
    public int getTeacherAgeSum() {
        return teacherAgeSum;
    }
}
class Visitor2 implements Visitor{//访问者2 分别求出学生的最高成绩，和最高的老师工龄
    private int maxScore=0;
    private int maxWorkYear=0;
    @Override
    public void visitTeacher(TeacherVP teacherVP){
        System.out.println("访问者2访问老师 "+teacherVP.getName()+" 工龄 "+teacherVP.getWorkYear());
        maxWorkYear=Math.max(maxWorkYear,teacherVP.getWorkYear());
    }
    @Override
    public void visitStudent(StudentVP studentVP){
        System.out.println("访问者2访问学生 "+studentVP.getName()+" 成绩 "+studentVP.getScore());
        maxScore=Math.max(maxScore,studentVP.getScore());
    }
    public int getMaxScore() {
        return maxScore;
    }
    public int getMaxWorkYear() {
        return maxWorkYear;
    }
}
abstract class Peoples{
    private String name;
    private int age;
    public Peoples(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class PeopleStructure{
   private List<Peoples> peoplesList=new ArrayList<Peoples>();
   public PeopleStructure() {//初始化数据
        peoplesList.add(new StudentVP("张三",18,100));
        peoplesList.add(new StudentVP("李四",20,90));
        peoplesList.add(new StudentVP("王五",22,80));

        peoplesList.add(new TeacherVP("陈老师",30,5));
        peoplesList.add(new TeacherVP("刘老师",35,10));
        peoplesList.add(new TeacherVP("洪老师",40,15));
   }
   public void accept(Visitor visitor){
       for(Peoples people:peoplesList){
           people.accept(visitor);//这里如果是学生对象执行学生对象的accept()方法，然后对应的访问者就会执行对应的学生操作，老师同理
       }
   }
}
class StudentVP extends Peoples{
    private int score;
    public StudentVP(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitStudent(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
class TeacherVP extends Peoples{
    private int workYear;
    public TeacherVP(String name, int age, int workYear) {
        super(name, age);
        this.workYear = workYear;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitTeacher(this);
    }

    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }
}