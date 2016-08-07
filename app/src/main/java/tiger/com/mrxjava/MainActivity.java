package tiger.com.mrxjava;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.ActionSubscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        subscriber();
//        observableJust();
//        rangeSubscribe();
//        rangeSub();
//        repeat();
//        ob();
//        mThread();
//        mJust();
//        pMpa();





        String[] names = {"xiao", "er", "liang"};
        Observable.from(names).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "MM";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("MainActivity", "call: " + s);
            }
        });


    }

    private void pMpa() {
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("call", s);
            }
        };

        Observable.just("泡面", "火腿", "鸡腿").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "加辣椒";
            }
        }).subscribe(action1);
    }

    private void mJust() {
        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("call", s);
            }
        };
        Observable.just(1, 2, 3, 4).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer.toString();
            }
        }).subscribe(action1);
    }

    private void mThread() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你被调用了");
                Log.d("我在", Thread.currentThread().getName());

            }
        });

        Action1 action1 = new Action1() {
            @Override
            public void call(Object o) {
                Log.d("我在", Thread.currentThread().getName());
                System.out.println(o.toString());
            }
        };
        observable.observeOn(Schedulers.newThread()).subscribe(action1);
    }


    private void ob() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        observable.observeOn(Schedulers.newThread()).subscribe(subscriber);
        observable.subscribe(subscriber);
    }


    private void repeat() {
        Observable.just(0, 1, 2).repeat(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("call", "" + integer);
            }
        });
    }

    private void rangeSub() {
        Observable.range(0, 10).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d("call", "" + integer);
            }
        });
    }

    private void rangeSubscribe() {
        Observable.range(0, 10).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d("onNext", "" + integer);
            }
        });
    }

    private void observableJust() {
        Observable.just(1, 2, 3, 4).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("收到：" + integer);
            }
        });
    }

    public void subscriber() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("subscriber", "收到命令：" + s);

            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("去给我买个菜");
            }
        });

        observable.subscribe(subscriber);
    }

}
