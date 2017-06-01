/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standard3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author metar
 */
public class Sample9 {
      public static void main(String[] args) throws IOException{
         // Fileオープン importでFileクラス定義
         File fp = new File("C:\\Users\\metar\\OneDrive\\ドキュメント\\NetBeansProjects\\GEEKJOB_Standard\\test.txt"); //ファイルパスで使用するものを確認
         // FileReader作成 ファイル読み出し
         FileReader fr = new FileReader(fp); // importでFileReaderクラス定義 new(File型 変数);
         // BufferedReader作成 効率的に読み出し
         BufferedReader br = new BufferedReader(fr); // importでBufferedReaderクラス定義 new(FileReader型 変数);
         //
         System.out.println(br.readLine());
         
         br.close();
    }
}
