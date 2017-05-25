/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//インポートで追加　ArrayListの使用

/**
 *
 * @author metar
 */
public class User extends Human{

    @Override
    public void setCard(ArrayList<Integer> card) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            for(int i=0; i<card.size(); i++) {
                
            myCards.add(card.get(i));
            
        }
    }
    
    
        @Override
    public int open() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int sum = 0;  //手札2枚のカードの合計値用変数
        
        for(int i=0; i<myCards.size();i++) {    //持っている枚数分だけカードの数値を足す
            
            sum = sum + myCards.get(i);
            
        }
        
        return sum;
        
    }
    

    int i=0;
    @Override
    public boolean checkSum() {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
        System.out.println("ユーザーはカードを引きますか？");
        System.out.println("カードを引く場合は“1”を入力し、Enter");
        System.out.println("カードを引かない場合は“0”を入力し、Enter");
    
        InputStreamReader is = new InputStreamReader(System.in); //インポートで追加
        BufferedReader br = new BufferedReader(is); //インポートで追加
    
        int a = open(); 
        String str = "";
        
        if(a < 21) {        //手札合計が21を超えない場合
            try {
                
                str = br.readLine();     //キーボードからの文字入力を受け取る
                
            } 
            catch (IOException ex) {

                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                
            }

        }

        if(a > 21) {    //手札合計が21を超えた時、カードを引けなくする
            
            System.out.println("ユーザーの手札合計が21を超えました");
            str = "0";
            
        }

            do {
                switch(str) {
                    case "1":               //"1"を入力し、Enterを押すとtrueを返す

                        System.out.println("カードを引きます");
                        
                        Dealer de = new Dealer();
                        myCards.add(de.hit().get(0));       //手札に1枚カードを加える
                        i++;        //カードを引いた回数をカウント

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
            while(!(str.equals("1")) && !(str.equals("0")));

        if(str.equals("1")) {
            
            return true;
            
        }
        
        else {
            
            return false;   
            
        }
    }
}