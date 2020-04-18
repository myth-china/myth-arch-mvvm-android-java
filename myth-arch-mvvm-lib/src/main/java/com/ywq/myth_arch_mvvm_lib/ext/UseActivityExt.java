package com.ywq.myth_arch_mvvm_lib.ext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.ywq.myth_arch_mvvm_lib.MythView;
import com.ywq.myth_arch_mvvm_lib.MythViewModelExt;
import com.ywq.myth_arch_mvvm_lib.event.OnceEvent;

public class UseActivityExt implements MythViewModelExt {
    public static final String KEY = "use_activity_ext";

    private MutableLiveData<OnceEvent<Object>> liveData = new MutableLiveData<>();
    private ActivityBlock activityBlock = null;

    public UseActivityExt() {
        super();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public LiveData getExtLiveData() {
        return liveData;
    }

    @Override
    public void register(final MythView mythView) {
        LifecycleOwner lifecycleOwner = null;

        if (mythView instanceof AppCompatActivity) {
            lifecycleOwner = (AppCompatActivity) mythView;
        } else if (mythView instanceof Fragment) {
            lifecycleOwner = ((Fragment) mythView).getViewLifecycleOwner();
        }

        if (lifecycleOwner == null) {
            return;
        }

        liveData.observe(lifecycleOwner, new Observer<OnceEvent<Object>>() {
            @Override
            public void onChanged(OnceEvent<Object> activityOnceEvent) {

                if (activityBlock == null) {
                    return;
                }

                AppCompatActivity appCompatActivity = null;

                if (mythView instanceof AppCompatActivity) {
                    appCompatActivity = (AppCompatActivity) mythView;
                } else if (mythView instanceof Fragment) {
                    appCompatActivity = (AppCompatActivity) ((Fragment) mythView).getActivity();
                }

                if (appCompatActivity == null) {
                    return;
                }

                activityBlock.callback(appCompatActivity);
            }
        });
    }

    public void useActivityBlock(ActivityBlock activityBlock) {
        this.activityBlock = activityBlock;
        liveData.postValue(new OnceEvent<>(null));
    }

    public interface ActivityBlock {
        void callback(AppCompatActivity appCompatActivity);
    }
}
