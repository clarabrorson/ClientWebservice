package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Models.User;
import com.example.newClientWebservice.Service.UserService;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

import static com.example.newClientWebservice.Service.UtilService.getStringInput;

public class Register {

    public static void register() throws IOException, ParseException {
        UserService.register();
        //MainMenu();
    }
}
