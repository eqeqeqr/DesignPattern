package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * 生成器模式
 * */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director=new Director();
        //构建方式A
        Builder builderA=new BuilderA();
        //builderA.buildPart();
        //builderA.getResult().show();
        director.Construct(builderA);
        BP_Product product1=builderA.getResult();
        product1.show();
        //构建方式B
        Builder builderB=new BuilderB();
        //builderB.buildPart();
        //builderB.getResult().show();
        director.Construct(builderB);
        BP_Product product2=builderB.getResult();
        product2.show();
    }
}
class Director{
    public void Construct(Builder builder){
        builder.builderPart()
    }
}
abstract class Builder{
    public abstract void buildPart();
    public abstract BP_Product getResult();
}
class BuilderA extends Builder{
    private BP_Product product=new BP_Product();

    @Override
    public void buildPart() {
        product.add("部件A");
        product.add("部件B");
        product.add("部件C");
        product.add("部件D");
        product.add("部件E");
    }

    @Override
    public BP_Product getResult() {
        return product;
    }
}
class BuilderB extends Builder{
    private BP_Product product=new BP_Product();

    @Override
    public void buildPart() {
        product.add("部件A");
        product.add("部件B");
    }

    @Override
    public BP_Product getResult() {
        return product;
    }
}
class BP_Product {
    List <String> parts=new ArrayList<>();
    public void add(String part){
        parts.add(part);
    }
    public void show(){
        System.out.println("流量套餐产品可选组成:");
        for (String part:parts){
            System.out.print(part+" ");
        }
        System.out.println();
    }
}
