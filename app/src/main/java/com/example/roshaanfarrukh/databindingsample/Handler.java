package com.example.roshaanfarrukh.databindingsample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Roshaan Farrukh on 1/17/2018.
 */

public class Handler {
    public void secondButtonClicked(Context context, Model user){
        Toast.makeText(context, "second button clicked", Toast.LENGTH_SHORT).show();
        System.out.println("second button clicked "+user.getEmail()+user.getName()+ context.getClass());
    }
}
