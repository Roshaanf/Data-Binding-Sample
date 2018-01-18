package com.example.roshaanfarrukh.databindingsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roshaanfarrukh.databindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
            model=new Model("Roshaan","roshaan.farrukh");

        //this will set the user varaible defined in xml in data tag
        binding.setUser(model);
        binding.setHandlers(this);
        binding.setHandler(new Handler());


    }

    public void firstButtonClicked(View v){
        Toast.makeText(this, "First button clicked", Toast.LENGTH_SHORT).show();
        System.out.println("first button clicked");

        //this only works when I extend BaseObservable class on model class (or implementd interface or have used observable data type)
        //and thn put bindable annotation above getter and thn call notifyPropertyChanged method
        model.setName("Salman");

        //when I put @= while setting text in xml it provide m the changed text if I change text while using app in same object
        //for e.g I setEmail to roshaan.farrukh while making objject above so when the app will run it will show roshaan.farrukh in edit text
        //but then if I change text while using app and type Roshaan in email edit text and I watnt that I should get this changed text in code
        //then I have to put @= in xml so that I not only set value from java object but also can get changed value in same object
        //now my model.getEmail() will give me Roshaan , but if I had used only @ instead of @= thn no matter how many times I change text using
        // appp it will always give me the value which I set  while making object i.e:roshaan.farrukh
        Toast.makeText(this, model.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
