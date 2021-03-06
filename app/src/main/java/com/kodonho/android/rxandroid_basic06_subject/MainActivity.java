package com.kodonho.android.rxandroid_basic06_subject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                publishSubject();
                break;
            case R.id.button2:
                behaviorSubject();
                break;
            case R.id.button3:
                replaySubject();
                break;
            case R.id.button4:
                asyncSubject();
                break;
            case R.id.button5:
                asyncCompleteSubject();
                break;
        }
    }
    // 구독한 시점부터 발행된 아이템을 받는다
    public void publishSubject(){
        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");

        subject.subscribe(
                item-> Log.e("Publish","item="+item)
        );

        subject.onNext("D");
        subject.onNext("E");
    }

    // 가장 최근에 관찰된 아이템부터 구독한다
    public void behaviorSubject(){
        BehaviorSubject<String> subject = BehaviorSubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.subscribe(
                item-> Log.e("Behavior","item="+item)
        );

        subject.onNext("D");
        subject.onNext("E");
    }
    public void replaySubject(){
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.subscribe(
                item-> Log.e("Replay","item="+item)
        );

        subject.onNext("D");
        subject.onNext("E");
    }
    public void asyncSubject(){
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.subscribe(
                item-> Log.e("Async","item="+item)
        );

        subject.onNext("D");
        subject.onNext("E");
    }
    public void asyncCompleteSubject(){
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.subscribe(
                item-> Log.e("AsyncComplete","item="+item)
        );

        subject.onNext("D");
        subject.onNext("E");
        subject.onCompleted();
    }
}
