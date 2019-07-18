package com.microape.databinding.utils;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;

/**
 * Author pengle on 2019/7/17 16:56
 * Email  pengle609@163.com
 */
public class SelfObservable<T extends Comparable> extends ObservableField<T> {

    static final long serialVersionUID = 1L;
    private T mValue;

    public SelfObservable(T value) {
        mValue = value;
    }

    public SelfObservable() {
    }

    public SelfObservable(Observable... dependencies) {
        super(dependencies);
    }

    @Nullable
    public T get() {
        return mValue;
    }

    @Override
    public void set(T value) {
        if (mValue == null){
            mValue = value;
            notifyChange();
            return;
        }else if (mValue.compareTo(value) != 0){
            mValue = value;
            notifyChange();
        }
    }
}
