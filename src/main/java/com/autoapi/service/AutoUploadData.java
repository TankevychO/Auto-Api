package com.autoapi.service;

import com.autoapi.model.Auto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AutoUploadData {
    private final AutoService autoService;

    public void load() {
        Auto auto1 = new Auto();
        auto1.setVinCode("3FA6P0VP1HR282209");
        auto1.setNumber("LK4455PO");
        auto1.setColor(Auto.Color.BLUE);
        auto1.setOwnerName("Ivanov");
        autoService.save(auto1);
        Auto auto2 = new Auto();
        auto2.setVinCode("5NPE24AFXFH183476");
        auto2.setNumber("KK9877AO");
        auto2.setColor(Auto.Color.BLACK);
        auto2.setOwnerName("Ivanov");
        autoService.save(auto2);
        Auto auto3 = new Auto();
        auto3.setVinCode("1FMCU9J94FUA44289");
        auto3.setNumber("KK5464AA");
        auto3.setColor(Auto.Color.WHITE);
        auto3.setOwnerName("Petrov");
        autoService.save(auto3);
        Auto auto4 = new Auto();
        auto4.setVinCode("3VWDP7AJ7DM356782");
        auto4.setNumber("KK9993AA");
        auto4.setColor(Auto.Color.YELLOW);
        auto4.setOwnerName("Romanov");
        autoService.save(auto4);
    }
}
