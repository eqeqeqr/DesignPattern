package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 * */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleague1 = new Colleague1(mediator);
        Colleague colleague2 = new Colleague2(mediator);
        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        colleague1.sendMessage("hello 同事 2", colleague2);
        colleague2.sendMessage("hello 同事 1", colleague1);
    }
}
abstract class Colleague {
    protected Mediator mediator;
    //消息全部发了中介者，由中介者发送消息到目标人物
    public abstract void sendMessage(String message, Colleague colleague);
    public abstract void receiveMessage(String message);
}
class Colleague1 extends Colleague {
    Colleague1(Mediator mediator){
        this.mediator = mediator;
    }
    @Override
    public void sendMessage(String message, Colleague colleague) {
        mediator.sendMessage(message, colleague);
    }
    @Override
    public void receiveMessage(String message) {
        System.out.println("同事1 receive message: " + message);
    }
}
class Colleague2 extends Colleague {
    Colleague2(Mediator mediator){
        this.mediator = mediator;
    }
    @Override
    public void sendMessage(String message, Colleague colleague) {
        mediator.sendMessage(message, colleague);
    }
    @Override
    public void receiveMessage(String message) {
        System.out.println("同事2 receive message: " + message);
    }
}
abstract class Mediator {

    public abstract void sendMessage(String message, Colleague colleague);

}

class ConcreteMediator extends Mediator {

    List<Colleague> colleagues=new ArrayList<>();
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
       // colleague.receiveMessage(message);
        for (Colleague c:colleagues) {
            if (c == colleague) {
                c.receiveMessage(message);
            }
        }
    }
}