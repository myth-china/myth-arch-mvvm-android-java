package com.myth.myth_arch_mvvm_android_java;

import android.app.Application;

import com.myth.myth_arch_mvvm_lib.MythViewModelExtProto;
import com.myth.myth_arch_mvvm_lib.ext.UseActivityExt;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        addMythViewModelExt();
    }

    private void addMythViewModelExt() {
        MythViewModelExtProto.addExtCls(UseActivityExt.class);
    }
}
