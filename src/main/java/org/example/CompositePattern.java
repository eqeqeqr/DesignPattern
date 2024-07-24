package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * 组合模式
 * */

public class CompositePattern {
    public static void main(String[] args) {
        AbstractFile root=new Folder("root");

        AbstractFile folderA=new Folder("folderA");
        AbstractFile folderB=new Folder("folderB");
        AbstractFile folderC=new Folder("folderC");
        AbstractFile fileD=new File("fileD");
        AbstractFile fileB=new File("fileB");

        System.out.println(root.add(folderA));
        System.out.println(root.add(fileB));
        folderA.add(folderB);
        folderA.add(folderC);
        folderA.add(fileD);
        print(root);
     /*   System.out.println(root.remove(fileB));
        System.out.println(root.remove(fileB));*/
    }
    static void print(AbstractFile file){
        file.printName();
        List<AbstractFile> childrenList=file.getChildren();
        if (childrenList==null){
            return;
        }
        for (AbstractFile children:childrenList){
            print(children);
        }
    }
}
abstract class AbstractFile {
   protected String name;
   public void printName(){
       System.out.println(name);
   }
   public abstract boolean add(AbstractFile file);
   public abstract boolean remove(AbstractFile file);
   //public abstract void add(AbstractFile file);
    public abstract List<AbstractFile> getChildren();
}
class Folder extends AbstractFile {
    private List<AbstractFile> childrenList=new ArrayList<AbstractFile>();
    public Folder(String name) {
       this.name=name;
    }

    @Override
    public boolean add(AbstractFile file) {
        return childrenList.add(file);
    }

    @Override
    public boolean remove(AbstractFile file) {
       return  childrenList.remove(file);
    }

    @Override
    public List<AbstractFile> getChildren() {
        return childrenList;
    }
}
class File extends AbstractFile {
    public File(String name) {
       this.name=name;
    }

    @Override
    public boolean add(AbstractFile file) {
       return false;
    }

    @Override
    public boolean remove(AbstractFile file) {
        return false;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}