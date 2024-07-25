package org.example;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
/**
 * 备忘者模式
 * */
public class MementoPattern {
    public static void main(String[] args) {
        Caretaker caretaker=new Caretaker();
        Originator originator=new Originator();

        //第一次备份
        originator.setState("v1.0");//为当前的项目设置第一次开发版本v1.0
        Memento memento = originator.createMemento();//备份1.0
        caretaker.addMemento(memento);//将备份存入到管理者中
        //第二次备份
        originator.setState("v2.0");
        memento = originator.createMemento();
        caretaker.addMemento(memento);
        //第三次备份
        originator.setState("v3.0");
        memento = originator.createMemento();
        caretaker.addMemento(memento);
        //展示所以的备忘录
        caretaker.showMemento();

        //回到原来的状态v2.0
        memento=caretaker.getMemento(2);
        originator.setMemento(memento);
        System.out.println("Originator当前状态是"+originator.getState());

        //继续备份v2.1 v2.2 v2.3
        originator.setState("v2.1");
        memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setState("v2.2");
        memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setState("v2.3");
        memento = originator.createMemento();
        caretaker.addMemento(memento);

        caretaker.showMemento();

        System.out.println("Originator当前状态是"+originator.getState());

    }

}
class Originator {//原发器
    private String state;
    public void setState(String state)
    {
        this.state = state;
    }
    public String getState(){
        return state;
    }
    public Memento createMemento(){//创建备忘录
        return new Memento(state);
    }
    public void setMemento(Memento memento)//获取备忘录的状态给原发器 也就是从备忘录中选员工版本 恢复以前指定的版本备忘录的状态
    {
        this.state = memento.getState();
    }
}

class Memento {//备忘录
    private String state;
    public Memento(String state)
    {
        this.state = state;
    }
    public String getState(){
        return state;
    }

}
class Caretaker{//管理者,否则保存好备忘录
    private List<Memento> mementoList=new ArrayList<>();
    public void addMemento(Memento memento){
        mementoList.add(memento);
    }
    public Memento getMemento(int index){
        return mementoList.get(index-1);
    }
    public void showMemento(){
        int cnt=1;
        //for 遍历
        for(Memento m:mementoList){
            System.out.println("第"+cnt+"次备忘录的状态是"+m.getState());
            cnt++;
        }
    }

}