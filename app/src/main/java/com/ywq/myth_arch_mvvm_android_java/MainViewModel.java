package com.ywq.myth_arch_mvvm_android_java;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ywq.myth_arch_mvvm_lib.MythViewModel;
import com.ywq.myth_arch_mvvm_lib.ext.UseActivityExt;

public class MainViewModel extends MythViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void showToast() {
        UseActivityExt ext = getExt(UseActivityExt.KEY);
        ext.useActivityBlock(new UseActivityExt.ActivityBlock() {
            @Override
            public void callback(AppCompatActivity appCompatActivity) {
                Toast.makeText(appCompatActivity, "Hello Myth", Toast.LENGTH_LONG).show();
            }
        });
    }
}
