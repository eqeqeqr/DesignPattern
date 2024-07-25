package org.example;

import java.util.HashSet;
import java.util.Set;
/**
 * 解释器模式
 * */
public class InterpreterPattern {
    public static void main(String[] args) {
        Context context=new Context();
        //检查 已存在的区域的负责人是否名单上的员工
       context.check("A区的负责人张三");
        context.check("B区的负责人李四");
        context.check("C区的负责人王五");
        context.check("C区的负责人张三");
        context.check("D区的负责人张三");//错误，因为不存在D区
    }
}
class Context {
    private String[] regions={"A区","B区","C区"};//规定的我方区域名单
    private String[] users={"张三","李四","王五"};//我方人员名单
    private NonTerminalExpression nonTerminalExpression;

    public Context(){
        TerminalExpression region=new TerminalExpression(regions);//接收区域名单生成的对象
        TerminalExpression user=new TerminalExpression(users);//接收人员名单生成的对象
        this.nonTerminalExpression=new NonTerminalExpression(region,user);//初始化非终结对象，作用是解析语句
    }
    public void check(String info){//检查信息
        boolean bool=nonTerminalExpression.interpret(info);//将字符串进行解析
        if (bool){
            System.out.println("信息正确");
        }
        else {
            System.out.println("信息错误");
        }
    }
}
interface Expression {
    public boolean interpret(String context);
}
class NonTerminalExpression implements Expression {
    private TerminalExpression region;
    private TerminalExpression user;
    public NonTerminalExpression(TerminalExpression region, TerminalExpression user) {
        this.region=region;
        this.user=user;
    }

    @Override
    public boolean interpret(String info) {
        String[] str=info.split("的负责人");//规矩规定的语法 解析字符串得到 预期的数据
        // 调用非终结方法进行信息解释 ”A区的负责人张三“ -》 {”A区“，”张三“}
      return   region.interpret(str[0])&&user.interpret(str[1]);//调用终结对象的判断方法判断信息是否正确
    }
}
class TerminalExpression implements Expression {
    private Set<String> set=new HashSet<>();
    TerminalExpression(String[] regions){//初始化全部信息到set中
        for (String region:regions){
            set.add(region);
        }
    }
    @Override
    public boolean interpret(String info) {
        //判断传入的信息是否在set集合中，比如A区是否在set集合中{A区，B区，C区}，
        // 这个set集合初始化已经由Context类构造函数初始化完毕
        return set.contains(info);
    }
}