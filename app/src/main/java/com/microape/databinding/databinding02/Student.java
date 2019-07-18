package com.microape.databinding.databinding02;

import android.databinding.ObservableField;

import com.microape.databinding.utils.SelfObservable;

import java.lang.annotation.ElementType;

/**
 * Author pengle on 2019/7/18 9:36
 * Email  pengle609@163.com
 */
public class Student {
    private String name;
    private SelfObservable<Integer> age = new SelfObservable<>();
    private String sex;

    private SelfObservable<Score> scoreField = new SelfObservable<>();

    public Student() {
    }

    public Student(String name, SelfObservable<Integer> age, String sex, SelfObservable<Score> scoreField) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.scoreField = scoreField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelfObservable<Integer> getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public SelfObservable<Score> getScoreField() {
        return scoreField;
    }

    public void setScoreField(Score mScore) {
        this.scoreField.set(mScore);
    }

    public static class Score implements Comparable<Score>{
        private int math;
        private int chinese;
        private int english;

        public Score() {
        }

        public Score(int math, int chinese, int english) {
            this.math = math;
            this.chinese = chinese;
            this.english = english;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getChinese() {
            return chinese;
        }

        public void setChinese(int chinese) {
            this.chinese = chinese;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "math=" + math +
                    ", chinese=" + chinese +
                    ", english=" + english +
                    '}';
        }

        @Override
        public int compareTo(Score o) {
            if (this.math == o.getMath()
                && this.chinese == o.getChinese()
                && this.english == o.getEnglish() ){
                return 0;
            }
           return -1;
        }

    }

    @Override
    public String toString() {
        return "TestValue02{" +
                "name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                ", scoreField=" + scoreField +
                '}';
    }
}
