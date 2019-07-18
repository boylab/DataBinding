package com.microape.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.microape.databinding.databinding01.PersonBinding;
import com.microape.databinding.databinding02.StudentBinding;

import org.reactivestreams.Subscription;

import java.util.Observer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_DataBinding01).setOnClickListener(this);
        findViewById(R.id.btn_DataUnBinding01).setOnClickListener(this);
        findViewById(R.id.btn_DataBinding02).setOnClickListener(this);
        findViewById(R.id.btn_DataUnBinding02).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_DataBinding01:
                PersonBinding.binding();
                break;
            case R.id.btn_DataUnBinding01:
                PersonBinding.unBinding();
                break;
            case R.id.btn_DataBinding02:
                StudentBinding.binding();
                break;
            case R.id.btn_DataUnBinding02:
                StudentBinding.unBinding();
                break;
        }
    }
}
