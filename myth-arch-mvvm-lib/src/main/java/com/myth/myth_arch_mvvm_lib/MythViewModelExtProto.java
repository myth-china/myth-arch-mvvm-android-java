package com.myth.myth_arch_mvvm_lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MythViewModelExtProto {

    private static List<Class<? extends MythViewModelExt>> extList = new ArrayList<>();

    private Map<String, MythViewModelExt> map = new HashMap<>();

    private boolean extRegistered = false;

    public static void addExtCls(Class<? extends MythViewModelExt> cls) {
        extList.add(cls);
    }

    void newInstance() {
        for (int i = 0; i < extList.size(); i++) {
            Class<? extends MythViewModelExt> cls = extList.get(i);
            try {
                MythViewModelExt ext = cls.newInstance();
                map.put(ext.getKey(), ext);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("ALL")
    public <T> T getExt(String key) {
        return (T) map.get(key);
    }

    void register(MythView mythView) {
        if (extRegistered) {
            return;
        }

        for (MythViewModelExt ext : map.values()) {
            ext.register(mythView);
        }

        extRegistered = true;
    }
}
