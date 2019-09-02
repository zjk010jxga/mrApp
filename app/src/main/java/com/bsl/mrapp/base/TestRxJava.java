package com.bsl.mrapp.base;


import android.util.Log;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

public class TestRxJava {
    public void createObservable(){
        //被观察者
        Observable novel = Observable.create(new ObservableOnSubscribe<String>(){

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onComplete();
            }
        });
        //观察者
        Observer<String> reader= new Observer<String>(){
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable=d;
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)){
                    mDisposable.dispose();
                    return;
                }
                Log.e(TAG,"onNext:"+value);

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError="+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        };
        novel.subscribe(reader);//读者和连载小说建立订阅关系
    }



}
