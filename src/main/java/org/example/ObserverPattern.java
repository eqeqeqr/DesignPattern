package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * 观察者模式
 * */
public class ObserverPattern {
    public static void main(String[] args) {
        Subjects subjectA=new ConcreteSubject();
        Observers observerB=new ConcreteObserver("B",subjectA);
        Observers observerC=new ConcreteObserver("C",subjectA);
        Observers observerD=new ConcreteObserver("D",subjectA);
        //通知
        System.out.println("目标A和观察者B,C,D的初始状态: "+subjectA.getState()+" "+observerB.getState()+" "+observerC.getState()+" "+observerD.getState());
        System.out.println("目标A的状态改变为--------》哈哈哈状态");
       // subjectA.Detach(observerD);//删除观察者D
        subjectA.setState("哈哈哈状态");
        System.out.println("目标A和观察者B,C,D的更新后的状态: "+subjectA.getState()+" "+observerB.getState()+" "+observerC.getState()+" "+observerD.getState());
    }
}
interface Subjects {//目标
    public void Attach(Observers observer);//添加观察者
    public void Detach(Observers observer);//删除观察者
    public void Notify();//通知目标所有的观察者
    public void setState(String state);//设置状态
    public String getState();//获取状态
}
class ConcreteSubject implements Subjects {
    private String state;
    private List<Observers> observersList;
    public ConcreteSubject() {
        this.state = "未更新";
        this.observersList = new ArrayList<Observers>();
    }
    @Override
    public void Attach(Observers observer) {
        observersList.add(observer);

    }

    @Override
    public void Detach(Observers observer) {
        observersList.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observers observer : observersList){
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
        Notify();
    }

    @Override
    public String getState() {
        return state;
    }
}
interface Observers {//观察者
    public void update();//更新观察者
    public String getState();//获取状态
}

class ConcreteObserver implements Observers {
    private String state;
    public String name;
    private Subjects subject;
    public ConcreteObserver(String name,Subjects subject) {
        this.name = name;
        this.subject = subject;
        //把创建的观察者自己添加到目标对象的观察者列表中
        subject.Attach(this);
        this.state=subject.getState();
    }
    @Override
    public void update() {
        System.out.println(name+"收到通知前"+"状态为:"+this.state);
        this.state=this.subject.getState();//把当前的目标对象的状态设置到观察者的状态中
        System.out.println(name+"收到通知后"+"状态为:"+this.state);
    }

    @Override
    public String getState() {
        return state;
    }
}

