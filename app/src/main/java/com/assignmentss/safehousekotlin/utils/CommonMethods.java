package com.assignmentss.safehousekotlin.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;


public class CommonMethods {
    public static void showShortToast(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void loadImage(ImageView imageView, String URL){
        imageView.load(URL);
    }
}
