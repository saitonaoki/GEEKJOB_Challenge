/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author metar
 */

//Human 抽象クラスの設定 
abstract public class Human {

abstract public int open();                             //openというabstractな公開(public)メソッド
abstract public void setCard(ArrayList<Integer> card); //カードを実装するだけなのでvoidで
abstract public boolean checkSum();                    //4.trueとfalseで返すためboolean
ArrayList<Integer>myCards = new ArrayList<Integer>();   //myCardsのArrayList準備　その際インポートチェック
    
}
