package org.example;
/**
 * 策略
 * */
public class StrategyPattern {
    public static void main(String[] args) {

        Strategy add=new AddStrategy();//+
        Strategy sub=new SubStrategy();//-
        Strategy mul=new MulStrategy();//*
        Strategy div=new DivStrategy();///


        OperationContext context=new OperationContext(add);
        context.Operation(1,5);
        context=new OperationContext(sub);
        context.Operation(1,5);
        context=new OperationContext(mul);
        context.Operation(1,5);
        context=new OperationContext(div);
        context.Operation(1,5);
    }
}
class OperationContext{
    private Strategy strategy;
    public OperationContext(Strategy strategy){
        this.strategy=strategy;
    }
    public void Operation(int num1,int num2){
        System.out.println(strategy.TwoNumberOperation(num1,num2));
    }
}
interface Strategy{
    public int TwoNumberOperation(int num1,int num2);
}
class AddStrategy implements Strategy{
    @Override
    public int TwoNumberOperation(int num1, int num2){
        return num1+num2;
    }
}
class SubStrategy implements Strategy{
    @Override
    public int TwoNumberOperation(int num1, int num2){
        return num1-num2;
    }
}
class MulStrategy implements Strategy{
    @Override
    public int TwoNumberOperation(int num1, int num2){
        return num1*num2;
    }
}
class DivStrategy implements Strategy{
    @Override
    public int TwoNumberOperation(int num1, int num2){
        return num1/(num2);
    }
}
