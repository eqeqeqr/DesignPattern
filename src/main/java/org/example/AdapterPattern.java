package org.example;

public class AdapterPattern {
    public static void main(String[] args) {
        USB usb=new Adapter();
        usb.send();
    }
}
class USB {
    public void send()
    {
        System.out.println("USB头");
    }
}
class Adapter extends USB {
    private TypeC typeC=new TypeC();
    @Override
    public void send()
    {
        System.out.println("正在转换：USB->转接口->TypeC");
        typeC.receive();
    }
}
class TypeC {
    public void receive()
    {
        System.out.println("TypeC孔");
    }
}
