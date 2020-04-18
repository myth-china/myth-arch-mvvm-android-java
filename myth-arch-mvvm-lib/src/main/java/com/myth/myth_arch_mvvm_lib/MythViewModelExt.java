package com.myth.myth_arch_mvvm_lib;

import androidx.lifecycle.LiveData;

public interface MythViewModelExt {

    /**
     * @return 当前扩展类的Key值
     */
    String getKey();

    LiveData getExtLiveData();

    void register(MythView mythView);
}
