package cn.skytech.androidjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 *         Handler用法
 *         1、postdelayed（）延时发送执行子线程
 *
 *         文字轮询Demo（实现每隔一秒钟更新一次Textview的功能）
 *
 */

public class Handler1Activity extends AppCompatActivity {


    private TextView mTextView;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private String[] str = new String[]{"傲慢","偏见","僵尸"};
    private int index = 0;
    MyRunnable myRunnable = new MyRunnable();

    private class MyRunnable implements Runnable{

        @Override
        public void run() {
            index = index % 3;
            mTextView.setText(str[index]);
            index ++;
            mHandler.postDelayed(myRunnable,1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler1);

        mTextView = (TextView) findViewById(R.id.tv);


        mHandler.postDelayed(myRunnable,1000);
    }
}

