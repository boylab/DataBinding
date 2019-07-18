package com.microape.databinding.databinding01;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.util.Log;

import com.microape.databinding.utils.TickHandler;

/**
 * Author pengle on 2019/7/18 9:36
 * Email  pengle609@163.com
 */
public class Person extends BaseObservable {

    public static final int ageFlag = 0x01,nameFlag = 0x02;

    private int age;
    private String name;
    private String sex;

    public Person() {
    }

    public Person(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age != age){
            this.age = age;
            notifyPropertyChanged(ageFlag);
            // TODO: 2019/7/17  notifyChange();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals(this.name)){
            this.name = name;
            notifyPropertyChanged(nameFlag);
            // TODO: 2019/7/17  notifyChange();
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TestValue01{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
