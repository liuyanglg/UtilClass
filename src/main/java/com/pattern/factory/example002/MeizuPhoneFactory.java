package com.pattern.factory.example002;

public class MeizuPhoneFactory extends PhoneFactory {

    public Phone getPhone() {
        return new MeizuPhone();
    }
}
