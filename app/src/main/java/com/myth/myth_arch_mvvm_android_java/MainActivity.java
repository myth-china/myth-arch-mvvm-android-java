package com.myth.myth_arch_mvvm_android_java;

import android.os.Bundle;
import android.view.View;

import com.myth.myth_arch_mvvm_lib.view.MythActivity;

public class MainActivity extends MythActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainViewModel mainViewModel = getProvider().getViewModel(MainViewModel.class);
                mainViewModel.showToast();
            }
        });
    }
}
