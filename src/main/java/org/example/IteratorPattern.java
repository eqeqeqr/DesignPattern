package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 迭代器模式
 * */
public class IteratorPattern {
    public static void main(String[] args) {
        List<Book> bookList=new ArrayList<>();

        String[] bookNames={"java","python","c++"};
        double[] bookPrices={100,200,300};

        for(int i=0;i<bookNames.length;i++){
            Book book=new Book(bookNames[i],bookPrices[i]);
            bookList.add(book);
        }

        //常用
        System.out.println("for===================================");
        for (int i = 0; i < bookList.size(); i++) {
            Book book=bookList.get(i);
            System.out.println(book.getName()+" "+book.getPrice());
        }

        //foreach
        System.out.println("foreach===================================");
        for (Book book:bookList){
            System.out.println(book.getName()+" "+book.getPrice());
        }

        //Java已经提供的迭代器
        System.out.println("Java已经提供的迭代器===================================");
        Iterator<Book> iterator = bookList.iterator();
        //iterator.hasNext()//判断是否还有下一个元素
        while (iterator.hasNext()){
            //iterator.next()//取下一个元素
            Book book=iterator.next();
            System.out.println(book.getName()+" "+book.getPrice());
        }

        //自定义的迭代器
        System.out.println("自定义的迭代器===================================");
        //创建迭代器对应对象的接口，这里提供了创建迭代器接口
        BookAggregate bookAggregate=new BookAggregate();


        for(int i=0;i<bookNames.length;i++){
            //初始化聚合，把数据添加到聚合对象中
            bookAggregate.addBook(new Book(bookNames[i],bookPrices[i]));
        }
        //通过聚合对象创建迭代器对象
        Self_Iterator selfIterator = bookAggregate.createIterator();
        //迭代器遍历
        while (selfIterator.hasNext()){
            Book book=(Book) selfIterator.next();
            System.out.println(book.getName()+" "+book.getPrice());
        }
    }
}
interface Self_Iterator{
    public boolean hasNext();
    public Object next();
}
class BookIterator implements Self_Iterator{
    private int index=-1;
    private BookAggregate bookAggregate;
    public BookIterator(BookAggregate bookAggregate){
        this.index=0;
        this.bookAggregate=bookAggregate;
    }

    @Override
    public boolean hasNext() {
        if (index<bookAggregate.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Object obj=bookAggregate.getBook(index);
        index++;
        return obj;
    }
}
interface Aggregate{
    public Self_Iterator createIterator();
}
class BookAggregate implements Aggregate{
    private List<Book> bookList=new ArrayList<>();
    public void addBook(Book book){
        bookList.add(book);
    }
    public Book getBook(int index){
        return bookList.get(index);
    }
    public int getSize(){
        return bookList.size();
    }
    @Override
    public Self_Iterator createIterator() {
        return new BookIterator(this);
    }
}

class Book{
    private String name;
    private double price;
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
