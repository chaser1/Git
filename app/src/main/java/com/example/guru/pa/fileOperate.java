package com.example.guru.pa;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.CalendarView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Haoyu on 2016/7/19.
 */
public class FileOperate{

    public static ArrayList<Schedule> bufferSchedule;
    private Context mContext;

    public FileOperate() {
        bufferSchedule = new ArrayList<Schedule>();

    }

    public FileOperate(Context mContext) {
        super();
        this.mContext = mContext;
    }
    /*
    * 这里定义的是一个文件保存的方法，写入到文件中，所以是输出流
    * */
    public void save(String filename, String fileContent) throws Exception {
        //这里我们使用私有模式,创建出来的文件只能被本应用访问,还会覆盖原文件哦
        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
       // Log.e("FileTest", fileContent);
        output.write(fileContent.getBytes());  //将String字符串以字节流的形式写入到输出流中
        output.close();         //关闭输出流
    }

    /*
    * 这里定义的是文件读取的方法
    * */
    public String read(String filename) throws IOException {
        //打开文件输入流
        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //读取文件内容:
        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        //关闭输入流
        input.close();
        return sb.toString();
    }
}
