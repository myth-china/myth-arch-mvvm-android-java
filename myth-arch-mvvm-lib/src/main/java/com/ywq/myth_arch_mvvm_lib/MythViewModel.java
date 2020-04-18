package com.ywq.myth_arch_mvvm_lib;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MythViewModel extends AndroidViewModel {
    private MythViewModelExtProto proto = new MythViewModelExtProto();

    public MythViewModel(@NonNull Application application) {
        super(application);
        proto.newInstance();
    }

    public <T> T getExt(String key) {
        return proto.getExt(key);
    }

    public void registerExt(MythView mythView) {
        proto.register(mythView);
    }
}
