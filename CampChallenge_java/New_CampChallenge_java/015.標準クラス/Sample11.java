/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standard3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author metar
 */

public class Sample11{
    /**
    * ログ設定プロパティファイルのファイル内容
    */
    protected static final String LOGGING_PROPERTIES_DATA
        = "handlers=java.util.logging.ConsoleHandler\n"
        + ".level=FINEST\n"
        + "java.util.logging.ConsoleHandler.level=FINEST\n"
        + "java.util.logging.ConsoleHandler.formatter"
        + "=java.util.logging.SimpleFormatter";

    /**
    * static initializer によるログ設定の初期化
    */
    static {
        final Logger logger = Logger.getLogger("SampleLogging");
        InputStream inStream = null;
        
        try {
            inStream = new ByteArrayInputStream(
                LOGGING_PROPERTIES_DATA.getBytes("UTF-8"));
            try {
                LogManager.getLogManager().readConfiguration(
                    inStream);
                logger.config(
                    "ログ設定: LogManagerを設定しました。");
            } catch (IOException e) {
                logger.warning("ログ設定: LogManager設定の際に"
                    + "例外が発生しました。:" + e.toString());
            }
        } catch (UnsupportedEncodingException e) {
            logger.severe("ログ設定: UTF-8エンコーディングが"
                + "サポートされていません。:" + e.toString());
        } finally {
            try {
                if (inStream != null) inStream.close(); 
            } catch (IOException e) {
                logger.warning(
                    "ログ設定: ログ設定プロパティファイルのスト"
                    + "リームクローズ時に例外が発生しました。:"
                    + e.toString());
            }
        }
    }
    public static void main(final String[] args) {
         //ロガーオブジェクトを取得
            final Logger logger = Logger.getLogger("SampleLogging");
            try {
            // 出力ファイルを指定する
            FileHandler fh = new FileHandler("SampleLog.log"); //importでlogging.FileHandlerを追加
            logger.addHandler(fh);
            }catch (IOException e) {
            e.printStackTrace();
            }
         // ログ出力
            logger.finest("日時　状況（開始）");
            logger.finer("出力テスト");
            logger.fine("");
            logger.config("");
            logger.info("");
            logger.warning("");
            logger.severe("日時　状況（終了）");
         
            // ログファイルを呼び出し
            String logFilePath = "SampleLog.log";
    }
}