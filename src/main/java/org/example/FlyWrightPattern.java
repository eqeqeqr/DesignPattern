package org.example;

public class FlyWrightPattern {
    public static void main(String[] args) {
        PieceFactory factory=new PieceFactory();
        Piece whitePiece1=factory.getPiece(0);
        System.out.println("whitePiece1 "+whitePiece1);
        whitePiece1.draw(10,10);
        Piece whitePiece2=factory.getPiece(0);
        System.out.println("whitePiece2 "+whitePiece2);
        whitePiece2.draw(20,20);
        Piece blackPiece1=factory.getPiece(1);
        System.out.println("blackPiece1 "+blackPiece1);
        blackPiece1.draw(30,30);
        Piece blackPiece2=factory.getPiece(1);
        System.out.println("blackPiece2 "+blackPiece2);
        blackPiece2.draw(40,40);
    }
}
class PieceFactory{
    private Piece[] pieces={new WhitePiece(),new BlackPiece()};
    public Piece getPiece(int key){
        if (key==0) {
            return pieces[0];
        } else {
            return pieces[1];
        }
    }
}
abstract class Piece{
    protected String color;
    public abstract void draw(int x,int y);
}
class WhitePiece extends Piece{
    WhitePiece(){
        this.color="white";
    }


    @Override
    public void draw(int x, int y) {
        System.out.println("draw a +"+color+"+ piece at ("+x+","+y+")");
    }
}
class BlackPiece extends Piece{

   BlackPiece(){
       this.color="black";
   }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a "+color+" piece at ("+x+","+y+")");
    }
}