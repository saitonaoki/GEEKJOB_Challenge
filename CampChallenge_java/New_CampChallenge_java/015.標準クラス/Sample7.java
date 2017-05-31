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
public class Sample7 {
    public static void main(String[] agrs){
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        // 文字の置換を実行する為、replaceを使用
        // ''の中で対象を選択確認
        String tikan1 = word.replace('I','い');   // Iからい　に置換実行
        String tikan2 = tikan1.replace('U','う'); // Uからう　に置換実行
    
        //置換したString型のみを表示させる
        System.out.print(tikan2.substring(0)); 
    }
}
