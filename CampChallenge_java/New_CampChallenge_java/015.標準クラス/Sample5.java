/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standard2;

/**
 *
 * @author metar
 */
public class Sample5 {
     public static void main(String[] args) {
         //名前入力
         String word = "齋藤尚輝"; 
         // length　文字長さを確認
         System.out.println(word.length()); // 文字数の長さ確認
         System.out.println(word.getBytes().length); // getBytesでバイト数を確認
    }
}