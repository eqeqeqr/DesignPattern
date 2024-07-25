package org.example;

/**
 * 责任链模式
 * */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler fuDaoYuan = new FuDaoYuan();
        Handler yuanZhang = new YuanZhang();
        Handler xiaoZhang = new XiaoZhang();
        //设置对象链
        fuDaoYuan.setNext(yuanZhang);
        yuanZhang.setNext(xiaoZhang);
        //假期请假5天
        fuDaoYuan.handleRequest(5);


    }
}
abstract class Handler {
    protected Handler next;
    public void setNext(Handler next)
    {
        this.next = next;
    }
    public abstract void handleRequest(int request);
}
class FuDaoYuan extends Handler {//<=7天 审批
    @Override
    public void handleRequest(int request)
    {
        if(request <=7)
        {
            System.out.println("辅导员批准了：您"+request+"天的假期");
        }
        else
        {

            if (next != null){
                System.out.println("辅导员：无法审批，请求上报院长");
                next.handleRequest(request);
            }else {
                System.out.println("无法审批");
            }

        }
    }
}
class YuanZhang extends Handler {//7<=15天 审批
    @Override
    public void handleRequest(int request)
    {
        if(request <=15)
        {
            System.out.println("院长批准了：您"+request+"天的假期");
        }
        else
        {

            if (next != null){
                System.out.println("院长：无法审批，请求上报校长");
                next.handleRequest(request);
            }else {
                System.out.println("无法审批");
            }

        }
    }
}
class XiaoZhang extends Handler {//15<=30 审批
    @Override
    public void handleRequest(int request)
    {
        if(request <=30)
        {
            System.out.println("校长批准了：您"+request+"天的假期");
        }
        else
        {
            if (next != null){
                next.handleRequest(request);
            }else {
                System.out.println("校长：超过30天无法审批，带家长来办公室");
            }

        }
    }
}
