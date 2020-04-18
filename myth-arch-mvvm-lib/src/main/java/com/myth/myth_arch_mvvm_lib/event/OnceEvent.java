package com.myth.myth_arch_mvvm_lib.event;

public class OnceEvent<T> {

    private T data;
    private boolean used = false;

    public OnceEvent(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        if (used) {
            return null;
        }

        used = true;

        return data;
    }
}