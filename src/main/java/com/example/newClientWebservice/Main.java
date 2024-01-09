package com.example.newClientWebservice;

import com.example.newClientWebservice.Menu.MainMenu;
import org.apache.hc.core5.http.ParseException;


import java.io.IOException;

public class Main {

    /**
     * Main-metoden för klienten. Kör MainMenu-klassen.
     *
     */
    public static void main(String[] args) throws IOException, ParseException {
        MainMenu.runMeny();
    }
}

