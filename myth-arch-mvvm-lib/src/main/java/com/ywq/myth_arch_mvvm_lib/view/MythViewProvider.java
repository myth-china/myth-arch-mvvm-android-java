package com.ywq.myth_arch_mvvm_lib.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.ywq.myth_arch_mvvm_lib.MythView;
import com.ywq.myth_arch_mvvm_lib.MythViewModel;

public class MythViewProvider {

    private ViewModelProvider viewModelProvider;
    private MythView mythView;

    MythViewProvider(MythView mythView) {
        super();
        this.mythView = mythView;

        ViewModelStoreOwner owner = null;

        if (mythView instanceof AppCompatActivity) {
            owner = (AppCompatActivity) mythView;
        } else if (mythView instanceof Fragment) {
            owner = (Fragment) mythView;
        }

        if (owner == null) {
            throw new IllegalArgumentException("MythView must be AppCompatActivity or Fragment");
        }

        viewModelProvider = new ViewModelProvider(owner);
    }

    private ViewModelProvider getViewModelProvider() {
        return viewModelProvider;
    }

    public <T extends MythViewModel> T getViewModel(Class<T> cls) {
        T t = getViewModelProvider().get(cls);
        t.registerExt(mythView);
        return t;
    }
}
