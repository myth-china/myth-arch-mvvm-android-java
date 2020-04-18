package com.myth.myth_arch_mvvm_lib.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.myth.myth_arch_mvvm_lib.MythView;

public class MythActivity extends AppCompatActivity implements MythView {
    MythViewProvider provider = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider = new MythViewProvider(this);
    }

    public MythViewProvider getProvider() {
        return provider;
    }
}
