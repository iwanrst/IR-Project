package com.ir.engine;
import com.ir.engine.com.ir.engine.handler.UserController;
import com.ir.engine.com.ir.engine.services.UserService;

import static spark.Spark.*;

/**
 * Created by Iwan R on 8/29/2015.
 */
public class MainApp {
    public static void main(String[] args) {
        new UserController(new UserService());
    }
}
