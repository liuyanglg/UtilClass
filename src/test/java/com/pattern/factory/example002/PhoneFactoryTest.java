package com.pattern.factory.example002;

import com.pattern.factory.example002.MeizuPhone;
import com.pattern.factory.example002.Phone;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneFactoryTest {
    private Phone phone = null;

    @Test
    public void getPhone() throws Exception {
        PhoneFactory factory = new MeizuPhoneFactory();
        phone = factory.getPhone();
        usePhone(phone);
         factory = new IPhoneFactory();
        phone = factory.getPhone();
        usePhone(phone);
         factory = new MiPhoneFactory();
        phone = factory.getPhone();
        usePhone(phone);
    }
    private void usePhone(Phone phone) {
        phone.call();
        phone.watchVideo();
        phone.playGame();
        phone.pay();
    }
}