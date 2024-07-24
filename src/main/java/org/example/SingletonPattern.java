package org.example;
/**
 * 单例模式
 * */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        System.out.println("s1的num : "+s1.getNum());
        Singleton s2=Singleton.getInstance();
        System.out.println("s2的num : "+s2.getNum());
        Singleton s3=Singleton.getInstance();
        System.out.println("s3的num : "+s3.getNum());
        //设置s1 查看是否影响s2 ，s3 实例
        s1.setNum(222222);
        System.out.println("s1的num : "+s1.getNum()+" s2的num : "+s2.getNum()+" s3的num : "+s3.getNum());
        //比较s1,s2,s3的地址
        System.out.println("s1地址 : "+s1+"\ns2地址 : "+s2+"\ns3地址 : "+s3);
        System.out.println("s1==s2?: "+ (s1==s2));
        System.out.println("s1==s3?: "+ (s1==s3));
        System.out.println("s2==s3?: "+ (s2==s3));


    }
}
class Singleton {
    private int num=100;
    private static Singleton instance = new Singleton();

    //静态方法只能访问静态变量
    public static Singleton getInstance()
    {
        return instance;
    }
    public int getNum()
    {
        return num;
    }
    public void setNum(int num)
    {
        this.num=num;
    }
}
