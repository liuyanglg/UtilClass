package com.pattern.factory.example001;

import org.junit.Test;

import static org.junit.Assert.*;


public class SimpleFactoryTest {
    private Phone phone = null;

    @Test
    public void getPhone() throws Exception {
        phone = SimpleFactory.getPhone(MiPhone.class);
        usePhone(phone);
        phone = SimpleFactory.getPhone(IPhone.class);
        usePhone(phone);
        phone = SimpleFactory.getPhone(MeizuPhone.class);
        usePhone(phone);
    }

    private void usePhone(Phone phone) {
        phone.call();
        phone.watchVideo();
        phone.playGame();
        phone.pay();
    }
}