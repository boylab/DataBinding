package com.microape.databinding.databinding01;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.util.Log;

import com.microape.databinding.utils.TickHandler;

/**
 * Author pengle on 2019/7/18 9:36
 * Email  pengle609@163.com
 */
public class PersonBinding {

    private static int i = 0;

    private static  TickHandler tickHandler = new TickHandler();

    public static void binding() {
        if (tickHandler.isTimerRun()){
            return;
        }

        final Person person = new Person();
        person.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == Person.ageFlag){
                    Log.i(">>>microape>>", ">>>刷新UI: age = "+person.getAge());
                }else if (propertyId == Person.nameFlag){
                    Log.i(">>>microape>>", ">>>刷新UI: name = "+person.getName());
                }
            }
        });

        tickHandler.startTimer(new TickHandler.TimerCallback() {
            @Override
            public void onTimerAccept() {
                i = i + 1;
                int age = i / 4 * 4;
                String name = "张三" + i / 8 * 8;
                Log.i(">>>microape>>", ">>>onTimerAccept: age = " + age + "    >>> name = " + name);

                person.setAge(age);
                person.setName(name);
            }
        });
    }

    public static void unBinding() {
        tickHandler.stopTimer();
    }
}
