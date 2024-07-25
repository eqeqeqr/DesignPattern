package org.example;

/**
 * 状态模式
 * */
public class StatePattern {
    public static void main(String[] args) {
        Machine machine = new Machine(3); //存货3
        machine.request();//购买 剩余count=2
        machine.request();//购买 剩余count=1
        machine.request();//购买 剩余count=0
        System.out.println("当前存货数量：" + machine.getCount());
        System.out.println("当前状态：" + machine.getState());
        machine.request();//无货，转入状态到State状态，并进行补货

    }
}
class Machine {//贩卖机
    private  int count;
    private State state;
    public Machine(int count){
        this.count = count;
        if (count<=0){
            this.state = new StateB();
        }else {
        this.state = new StateA();
        }
    }
    public void setState(State state){
        this.state = state;
    }
    public void setCount(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public void request(){
        //调用当前状态的处理方法来处理请求
        state.Handle(this);
    }
}
interface State {//状态
    public void Handle(Machine context);

}
class StateA implements State {
    @Override
    public void Handle(Machine machine){
        int count = machine.getCount();
        if(count >=1){
            System.out.println("购买成功");
            count--;
            machine.setCount(count);
            if (count ==0){
                //转入到无货状态
                machine.setState(new StateB());
            }
        }else{
            System.out.println("购买失败");
        }
    }
}
class StateB implements State {
    @Override
    public void Handle(Machine machine){
        int count = machine.getCount();
        if (count==0){
            System.out.println("商品已售罄!等待补货");
            machine.setCount(5);
            System.out.println("补货成功");
            //转入到有货状态
            machine.setState(new StateA());
        }
    }
}
