package com.pattern.factory.example002;

public class MiPhoneFactory extends PhoneFactory {

    public Phone getPhone() {
        return new MiPhone();
    }
}
