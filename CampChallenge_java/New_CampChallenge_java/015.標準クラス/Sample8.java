/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standard3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author metar
 */
public class Sample8 {
    public static void main(String[] args) throws IOException{
        // File作成 importでFileクラス定義
        // ファイル操作を行う　ファイルパスを指定
        File fp = new File("test.txt"); //ファイルパスで使用するものを確認
        
        // FileWriter作成 ファイルへ書き込む準備
         FileWriter fw = new FileWriter(fp); //ヒントからthrows IOExceptionを追加
    
         fw.write("自己紹介"); //FileWriter変数.write("");で文章を書く
         fw.write("saitonaoki,23");
         
         fw.close();
    }
}
