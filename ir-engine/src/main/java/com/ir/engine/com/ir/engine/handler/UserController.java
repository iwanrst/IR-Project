package com.ir.engine.com.ir.engine.handler;

import com.ir.engine.com.ir.engine.model.User;
import com.ir.engine.com.ir.engine.services.UserService;
import com.ir.engine.com.ir.engine.util.JsonUtil;
import com.ir.engine.com.ir.engine.util.ResponseError;

import static spark.Spark.*;

/**
 * Created by Iwan R on 8/30/2015.
 */
import static spark.Spark.*;


public class UserController {

    public UserController(final UserService userService) {

        get("/users", (req, res) -> userService.getAllUsers(), JsonUtil.json());

        get("/users/:id", (req, res) -> {

            String id = req.params(":id");
            User user = userService.getUser(id);
            if (user != null) {
                return user;
            }
            res.status(400);
            return new ResponseError("No user with id '%s' found", id);
        }, JsonUtil.json());

        post("/users", (req, res) -> userService.createUser(
                req.queryParams("name"),
                req.queryParams("email")
        ), JsonUtil.json());

        put("/users/:id", (req, res) -> userService.updateUser(
                req.params(":id"),
                req.queryParams("name"),
                req.queryParams("email")
        ), JsonUtil.json());

        after((req, res) -> {
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(JsonUtil.toJson(new ResponseError(e)));
        });
    }
}
