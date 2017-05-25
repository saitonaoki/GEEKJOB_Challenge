/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//インポートで追加　ArrayListの使用

/**
 *
 * @author metar
 */
public class Dealer extends Human{

    ArrayList<Integer>cards;
    
    Dealer(){
    this.cards = new ArrayList<>();
    for(int i=1;i<=4;i++){
        for(int j=1;j<=13;j++){     //1から10を入れるー
            if(j<=10){
                cards.add(j);
            }
            else if(10<j){      //11以上のカードを10と考える
                cards.add(10);
            }
        }
    }
}

    @Override
    public void setCard(ArrayList<Integer> card) {
    for(int i=0; i<card.size(); i++) { 
            myCards.add(cards.get(i)); 
        }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
 
public ArrayList<Integer> deal() { 
 
     Random r = new Random();        //52枚からランダムで引く

     ArrayList<Integer> drawCards = new ArrayList<>();       //drawCardsを用意 

     for(int a=0; a<=1; a++) { //カードを2枚引く
         int cardNum = r.nextInt(51);        //どのカードを引くか決める （0～51の中から）
         cards.get(cardNum);             //カードを引く 
         drawCards.add(this.cards.get(cardNum));     //引いたカードを、drawCardsに代入
    } 
        return drawCards;  
}
 
ArrayList<Integer> plusCard = new ArrayList<>();    //return用のArrayList型の変数plusCardを用意 

  public ArrayList<Integer> hit() { 
        Random r = new Random();        //52枚からランダムで引く 
        int cardNum = r.nextInt(51);    //どのカードを引くか決める （0～51の中から）
        cards.get(cardNum);             //カードを引く 
        plusCard.add(this.cards.get(cardNum));      //引いたカードを、plusCardsに代入
        return plusCard;              //1枚カードを返す 
    } 

    @Override
    public int open() {
        
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    int sum = 0;
    
    for(int i=0; i<myCards.size();i++) {    //持っている枚数分だけカードの数値を足す
    sum = sum + myCards.get(i); 

      } 
         return sum; 
  }
    
    
    int i = 0;
    @Override
    public boolean checkSum() {
        InputStreamReader is = new InputStreamReader(System.in); //インポートで追加　インスタンス生成
        BufferedReader br = new BufferedReader(is);              //インポートで追加　インスタンス生成
        
        int a = open();
        String str = "";
        
    if( a< 17) { 
        
     System.out.println("ディーラーはカード合計が17未満なので、カードを引く"); 
     str = "1"; 
     
     }
    
    else if(17 <=a && a<=21){  //手札合計が17以上21以下のとき、カードを引くか否かをディーラーに聞く 
        
     System.out.println("ディーラーのカード合計は17以上21以下です。カードを引きますか？"); 
     System.out.println("カードを引く場合は“1”を入力し、Enter"); 
     System.out.println("カードを引かない場合は“0”を入力し、Enter"); 
    try {
                str = br.readLine();  //キーボードからの入力を受け取る
        }
    catch (IOException ex) {
        
                Logger.getLogger(Dealer.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
    
    else if(21 < a) {

            System.out.println("ディーラーの手札合計が21を超えました");
            str = "0";
            
        }

        do {

            switch(str) {

                case "1":                                   //"1"を入力し、Enterを押すとtrueを返す

                    System.out.println("カードを引く");
                    
                    Dealer de = new Dealer();
                    myCards.add(de.hit().get(0));       //手札(myCards)に1枚カードを加える
                    i++;        //カードを引いた回数をカウントする
                    break;

                case "0":                                   //"0"を入力し、Enterを押すとfalseを返す

                    System.out.println("この手札で勝負します");
                    
                    break;

                default:

                    System.out.println("1か0を入力してください");
                    
                    try {
                        
                        str = br.readLine();        //キーボード入力させる
                        
                    } 
                    catch (IOException ex) {
                        
                        Logger.getLogger(Dealer.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    break;

            }
        } 
        
        while( !(str.equals("1")) && !(str.equals("0")) ); //while文のequalsで文字比較

        if(str.equals("1")) {

            return true;

        } 
        
        else{
            
            return false;
            
        }
    }
} 