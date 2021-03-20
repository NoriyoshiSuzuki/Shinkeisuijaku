package shinkeisuijaku;
//import Shinkeisuijaku.Trump;
import java.io.*;
import java.util.Random;
import java.util.Collections.*;
// import java.lang.*;
//import ./"Trump.java";

public class shinkeisuijaku{
  public static void main(String[] args){
    Trump cards[] = new Trump[54];
    int myPoints = 0;
    int enemyPoints = 0;

      for(int i = 0; i < 13; i++){
        cards[i] = new Trump();
        cards[i].setMark("　ハート　");
        cards[i].setNumber(i + 1);
        // System.out.print(cards[i].getMark());
        // System.out.println(cards[i].getNumber());
      }

      for(int i = 13; i < 26; i++){
        cards[i] = new Trump();
        cards[i].setMark("クローバー");
        cards[i].setNumber(i - 12);
        // System.out.print(cards[i].getMark());
        // System.out.println(cards[i].getNumber());
      }

      for(int i = 26; i < 39; i++){
        cards[i] = new Trump();
        cards[i].setMark("　ダイヤ　");
        cards[i].setNumber(i - 25);
        // System.out.print(cards[i].getMark());
        // System.out.println(cards[i].getNumber());
      }

      for(int i = 39; i < 52; i++){
        cards[i] = new Trump();
        cards[i].setMark("スペード　");
        cards[i].setNumber(i - 38);
        //System.out.print(cards[i].getMark());
        //System.out.println(cards[i].getNumber());
      }

      for(int i = 52; i < 54; i++){
        cards[i] = new Trump();
        cards[i].setMark("Joker");
        // System.out.print(cards[i].getMark());
        // System.out.println(cards[i].getNumber());
      }

      Trump shuffledCards[] = new Trump[54];
      int count = 0;
      while(true){
          Random r = new Random();
          int randNum = r.nextInt(54);
          if(shuffledCards[randNum] == null){
            // System.out.println(randNum);
            shuffledCards[randNum] = cards[count];
            count++;
          }
          if(count == 54){
            break;
          }
      }
      // シャッフルが出来ているかの確認
      for(int x = 0; x < shuffledCards.length; x++){
        System.out.println(x + ":" + shuffledCards[x].getNumber());
      }
      //カード表示
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 9; j++){
          //int index = i * 9 + j;
          System.out.print("("+ "*****" +","+ "**" + ")");
        }
        System.out.println();
      }

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int selectedIndexes[] = new int[2];
      selectedIndexes[0] = -1;
      selectedIndexes[1] = -1;

      //２枚のトランプ選択してめくる
      int shiftOn = 0;
      while(true){
        if(shiftOn % 2 == 0){
          for(int i = 0; i < 2; i++){
            int selectedX  = 0;
            int selectedY  = 0;

            //列番号の選択
            System.out.println("列番号を指定してください。");
            while(true){
              try{
                String inputString = br.readLine();
                int inputIntX = Integer.parseInt(inputString);
                if(inputIntX < 10 && inputIntX > 0){
                  selectedX = inputIntX;
                  break;
                }
                System.out.println("1以上、9以下の整数を入力してください。");
              } catch(Exception e){
                System.out.println("半角数字を入力してください。");
              }
            }
            System.out.println("列番号：" + selectedX);

            //行番号の選択
            System.out.println("行番号を指定してください。");
            while(true){
              try{
                String inputString = br.readLine();
                int inputIntY = Integer.parseInt(inputString);
                if(inputIntY < 7 && inputIntY > 0){
                  selectedY = inputIntY;
                  break;
                }
                System.out.println("1以上、6以下の整数を入力してください。");
              } catch(Exception e){
                System.out.println("半角数字を入力してください。");
              }
            }
            System.out.println("行番号：" + selectedY);

            int selectedIndex = (selectedY - 1) * 9 + (selectedX - 1);
            if(selectedIndexes[0] != selectedIndex && shuffledCards[selectedIndex] != null){
              System.out.println(shuffledCards[selectedIndex].getMark());
              System.out.println(shuffledCards[selectedIndex].getNumber());

              selectedIndexes[i] = selectedIndex;
            } else {
              System.out.println("そのカードは選択できません。");

              i--;
              continue;
              //continue　でループ文の末尾に飛ぶ　→　
            }
          }
        } else{
          System.out.println("CPUの手番です");
          Random rnd = new Random();
          int enemyNum = 0;
          for(int i = 0; i < 2; i++){
            while(true){
              enemyNum = rnd.nextInt(54);
              if(enemyNum != selectedIndexes[0] && shuffledCards[enemyNum] != null){
                selectedIndexes[i] = enemyNum;
                break;
              }
            }
          }
        }

          //選択されたトランプの表示
          for(int j = 0; j < 6; j++){
            for(int k = 0; k < 9; k++){
              int index = j * 9 + k;
              if(selectedIndexes[0] == index){
                System.out.print("("+ shuffledCards[selectedIndexes[0]].getMark() +","+ shuffledCards[selectedIndexes[0]].getNumber() + ")");
              } else if(selectedIndexes[1] == index) {
                System.out.print("("+ shuffledCards[selectedIndexes[1]].getMark() +","+ shuffledCards[selectedIndexes[1]].getNumber() + ")");
              } else if(shuffledCards[index] == null) {
                System.out.print("               ");
              } else {
                System.out.print("("+ "**********" +","+ "**" + ")");
              }
            }
            System.out.println();
          }

        if(shuffledCards[selectedIndexes[0]].getNumber() == shuffledCards[selectedIndexes[1]].getNumber()){
          System.out.println("一致しました！");
          if(shiftOn % 2 == 0){
            myPoints++;
            System.out.println("現在のプレイヤーの獲得ポイントは "+myPoints+" 点です。");
          } else{
            enemyPoints++;
            System.out.println("現在のCPUの獲得ポイントは "+enemyPoints+" 点です。");
          }
          shuffledCards[selectedIndexes[0]] = null;
          shuffledCards[selectedIndexes[1]] = null;
        } else {
          System.out.println("一致しませんでした。");
          shiftOn++;
        }

        //selectedIndexesの初期化
        selectedIndexes[0] = -1;
        selectedIndexes[1] = -1;

        //結果の表示
        for(int j = 0; j < 6; j++){
          for(int k = 0; k < 9; k++){
            int index = j * 9 + k;
            if(shuffledCards[index] == null){
              System.out.print("               ");
            } else {
              System.out.print("("+ "**********" +","+ "**" + ")");
            }

          }
          System.out.println();
        }

        boolean isFinished = true;
        for(int i = 0; i < 54; i++){
            if(shuffledCards[i] != null){
              isFinished = false;
            }
          }
        if(isFinished == true){
          break;
        }
      }
    }
}


//   public static int[] playerAct(Trump shuffledCards[]){
//
//     return playerSelected;
//   }
//
//   public static int[] enemyAct(Trump shuffledCards[]){
//
//     return enemySelected;
//
//   }
// }
