package com.microape.databinding.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 *  * Author：pengl on 2019/6/27 10:10
 *  * Email ：pengle609@163.com
 *  
 */
public class TickHandler {

    private AtomicLong lastTick = new AtomicLong(0L);
    private Disposable disposable;

    private Observable<Long> timerObservable;

    public TickHandler() {
    }

    public boolean isTimerRun() {
        if (disposable != null && !disposable.isDisposed()){
            return true;
        }
        return false;
    }

    public void startTimer(final TimerCallback timerCallback) {
        stopTimer();

        timerObservable = Observable.interval(80, 1000, TimeUnit.MILLISECONDS);
        disposable = timerObservable.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                if (timerCallback != null){
                    timerCallback.onTimerAccept();
                }
            }
        });
    }

    public void stopTimer() {
        if (disposable != null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    public interface TimerCallback{
        void onTimerAccept();
    }
}
