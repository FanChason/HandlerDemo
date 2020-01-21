package cn.skytech.androidjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 *      3、sendToTarget（）传递消息
 *
 *      与第二种用法原理一致
 *
 */

public class Handler3Activity extends AppCompatActivity {


    private TextView mTextView;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Person p = (Person) msg.obj;
            mTextView.setText(p.toString() + "arg1=" + msg.arg1 + " arg2=" + msg.arg2);
            super.handleMessage(msg);
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

        new Thread() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();//同样可以获取Message对象
                msg.arg1 = 1;
                msg.arg2 = 2;
                Person person = new Person();
                person.name = "pig";
                person.age = 10;
                msg.obj = person;
                msg.sendToTarget();
            }
        }.start();

    }
}
