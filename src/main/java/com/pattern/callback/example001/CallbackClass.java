package com.pattern.callback.example001;

public class CallbackClass {
    private CallbackI callbackI;

    public CallbackClass(CallbackI callbackI) {
        this.callbackI = callbackI;
    }

    public static void main(String[] args) {
        CallbackClass callbackClass=new CallbackClass(new CallbackI() {
            @Override
            public void doSomething() {
                System.out.println("do something...");
            }
        });
        callbackClass.callbackI.doSomething();
    }
}
