package com.microape.databinding.utils;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;

/**
 * Author pengle on 2019/7/17 16:56
 * Email  pengle609@163.com
 * 兼容 T 非基本数据类型，
 */
public class SelfObservable<T> extends ObservableField<T> {

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
        if (value instanceof Comparable) {
            // TODO: 2019/7/17 基本数据类型父类
            if (value != mValue) {
                mValue = value;
                notifyChange();
            }
        } else {
            // TODO: 2019/7/17 value 必须实现规范的 toString() 方法
            if (!value.toString().equals(mValue.toString())) {
                mValue = value;
                notifyChange();
            }
        }
    }
}
