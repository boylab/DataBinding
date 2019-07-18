package com.microape.databinding.databinding02;

import android.databinding.Observable;
import android.util.Log;

import com.microape.databinding.utils.TickHandler;

/**
 * Author pengle on 2019/7/18 9:36
 * Email  pengle609@163.com
 */
public class StudentBinding {

    private static int i = 120;

    private static TickHandler tickHandler = new TickHandler();

    public static void binding() {
        if (tickHandler.isTimerRun()){
            return;
        }

        final Student student = new Student();

        student.getAge().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.i(">>>microape>>", ">>>刷新UI: age = "+student.getAge().get());
            }
        });

        student.getScoreField().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.i(">>>microape>>", ">>>刷新UI: Score = "+ student.getScoreField().get().toString());
            }
        });

        tickHandler.startTimer(new TickHandler.TimerCallback() {
            @Override
            public void onTimerAccept() {
                i = i+1;
                int age = i/4 *4;
                int score = i/8 *8;
                Log.i(">>>microape>>", ">>>onTimerAccept: age = " + age + "    >>> score = " + score);

                student.setAge(age);
                Student.Score studentScore = new Student.Score(score, score*score, score*score*score);
                student.setScoreField(studentScore);
            }
        });
    }

    public static void unBinding() {
        tickHandler.stopTimer();
    }

}
