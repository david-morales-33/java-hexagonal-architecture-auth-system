package com.dmx.server;

import com.dmx.server.controllers.UserController;

public class Main {

    public static void main(String[] args) {
        System.out.println("Holaaaa");

        UserController controller = new UserController();
        controller.create(
                "833eafb5-5432-4e5d-a113-32e2aff91ed9",
                "Luisa Fernanda Gonsalez",
                "Luisa123.4@gmail.com",
                "Lui123"
        );
    }
}
