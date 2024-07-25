package org.example;
/**
 * 命令模式
 * */
public class CommandPattern {
    public static void main(String[] args) {
        TV tv1 = new TV();//接收者 对象 电视机
        Command on1=new OnCommand(tv1);//命令对象 开机命令
        Command off1=new OffCommand(tv1);//命令对象 关机命令

        Invoker invoker1 = new Invoker();//请求者
        invoker1.setCommand(on1);//给请求者设置 开机 命令
        invoker1.call();//请求调用命令

        System.out.println("----------------------" );
        invoker1.setCommand(off1);//给请求者设置 关机 命令
        invoker1.call();//请求调用命令
    }
}
class Invoker{//请求者
    private Command command;
    public void setCommand(Command command)
    {
        this.command = command;
    }
    public void  call(){
        this.command.execute();
    }
}
interface Command {//命令接口
    public abstract void execute();
}
class  OnCommand implements Command{//开机命令
    private TV tv;
    public OnCommand(TV tv)
    {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.on();
    }
}
class OffCommand implements Command{
    private TV tv;
    public OffCommand(TV tv)
    {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.off();
    }//关机命令

}
class TV {//电视
    public void on()
    {
        System.out.println("TV 开机");
    }
    public void off()
    {
        System.out.println("TV 关机");
    }
}