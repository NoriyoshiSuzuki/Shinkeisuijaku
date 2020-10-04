package trumpgame;
import java.io.*;
import java.util.Random;
import java.util.Collections.*;
// import java.lang.*;
//import ./"Trump.java";

public class Shinkeisuijaku{
  public static void main(String[] args){
    Trump cards[] = new Trump[54];

      for(int i = 0; i < 13; i++){
        cards[i] = new Trump();
        cards[i].setMark("ハート");
        cards[i].setNumber(i + 1);
        System.out.print(cards[i].getMark());
        System.out.println(cards[i].getNumber());
      }

      for(int i = 13; i < 26; i++){
        cards[i] = new Trump();
        cards[i].setMark("クローバー");
        cards[i].setNumber(i - 12);
        System.out.print(cards[i].getMark());
        System.out.println(cards[i].getNumber());
      }

      for(int i = 26; i < 39; i++){
        cards[i] = new Trump();
        cards[i].setMark("ダイヤ");
        cards[i].setNumber(i - 25);
        System.out.print(cards[i].getMark());
        System.out.println(cards[i].getNumber());
      }

      for(int i = 39; i < 52; i++){
        cards[i] = new Trump();
        cards[i].setMark("スペード");
        cards[i].setNumber(i - 38);
        System.out.print(cards[i].getMark());
        System.out.println(cards[i].getNumber());
      }

      for(int i = 52; i < 54; i++){
        cards[i] = new Trump();
        cards[i].setMark("Joker");
        System.out.print(cards[i].getMark());
        System.out.println(cards[i].getNumber());
      }

      Trump shuffledCards[] = new Trump[54];
      int i = 0;
      while(true){
          Random r = new Random();
          int randNum = r.nextInt(54);
          if(shuffledCards[randNum] == null){
            // System.out.println(randNum);
            shuffledCards[randNum] = cards[i];
            i++;
          }
          if(i == 54){
            break;
          }
      }
      for(i = 0; i < shuffledCards.length; i++){
        System.out.println(i);
        System.out.println(shuffledCards[i].getNumber());
      }

  }
}
