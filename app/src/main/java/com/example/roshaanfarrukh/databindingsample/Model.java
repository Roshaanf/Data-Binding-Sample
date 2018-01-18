package com.example.roshaanfarrukh.databindingsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

/**
 * Created by Roshaan Farrukh on 1/17/2018.
 */

public class Model extends  BaseObservable {
    String name;
    String email;

    public Model(){

    }
    public Model(String name, String email) {
        this.name = name;
        System.out.println("tag Constructor is called");
        this.email = email;
    }
    //this method will be called from xml where I used @{User.name}
    @Bindable  //to change value by set method it is important to extends BaseObservable or make a Observable varaiable or implement interface
    //after that you have to provide bindable annotation above getter and in set method call notifyPropertyChanged
    public String getName() {
        System.out.println("tag Get name called");
        return name;
    }

    public void setName(String name) {
        System.out.println("tag set name called");
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getEmail() {
        System.out.println("tag get email called");
        return email;
    }

    //this method is callled by binding because I used @= so when the value changes it will calll set method to give back change value to object
    public void setEmail(String email) {
        System.out.printf("tag set email called");
        this.email = email;
    }

}

// Summary

//getters are called by binding when I use @ in xmlwhile setting text
//setters are only called by binding when I use @= to set back changed value to object
//to change values dynamically by calling setter follow 3 steps
  //1) extends BaseObservable / implement pakage / make observable data types
  //2) provide @Bindable annotation above getter
  //3) In setter call notifyPropertyChanged)
  //4) Now when you change value by calling set method it will also update value in UI otherwise not

// To achieve two way binding(not only set values from java but also get changed values from xml) use @= while setting text in xml instead of @
//you can see example of two way binding in main activity method firstButtonClicked