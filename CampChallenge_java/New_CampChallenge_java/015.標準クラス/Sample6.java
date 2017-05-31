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
public class Sample6 {
    public static void main(String[] agrs){
        String mail = "pdcaword@gmail.com";
        // 部分的に取り出すため、substringで@から開始するよう設定
         System.out.print(mail.substring(8)); // @から開始していることを確認
    
    }
}
