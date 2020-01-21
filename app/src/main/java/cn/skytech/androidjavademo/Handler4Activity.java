package cn.skytech.androidjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 *      4、使用CallBack截获Handler的消息
 *
 */
public class Handler4Activity extends AppCompatActivity {


    private TextView mTextView;

    Handler mHandler = new Handler(new Handler.Callback() {
        //传入CallBack对象，对于重载的返回值为bollean的handleMessage（）
        //返回值为false，将先执行这个方法，再执行返回值为void的handleMessage（）方法
        //返回值为true,只执行这个方法
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(Handler4Activity.this, "截获消息", Toast.LENGTH_SHORT).show();
            return false;
        }
    }) {
        public void handleMessage(Message msg) {
            Toast.makeText(Handler4Activity.this, "发出消息", Toast.LENGTH_SHORT).show();
        }
    };

    private class Person {
        String name;
        int age;

        @Override
        public String toString() {
            return "name=" + name + " age=" + age;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler1);

        mTextView = (TextView) findViewById(R.id.tv);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setVisibility(View.VISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(0);
            }
        });


    }
}

