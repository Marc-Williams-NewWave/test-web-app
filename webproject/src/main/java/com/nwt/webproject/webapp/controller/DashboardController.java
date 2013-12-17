package com.nwt.webproject.webapp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nwt.webproject.common.Key;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.service.UserService;
import com.nwt.webproject.webapp.common.Route;
import com.nwt.webproject.webapp.common.View;

/**
 * Dashboard controller
 *
 * @author: Prabakar Singaram
 * @created: 4/20/2013 10:25 PM
 * @company: NewWave Technologies Inc
 */
@Controller
public class DashboardController extends BaseWebAppController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    private @Autowired UserService userService;


    @RequestMapping(value = Route.dashboard, method = RequestMethod.GET)
    public String merchantDashboard(Locale locale, Model model,
                                    @RequestParam(value = Key.isLogin, required = false) boolean ls,
                                    @RequestParam(value = Key.isRegister, required = false) boolean rs,
                                    @RequestParam(value = Key.isEmailConfirmed, required = false) boolean ecs) {
        if (rs) {
            addSuccess(msg.registerSuccess, model);
        } else if (ls)
            addSuccess(msg.loginSuccess, model);
        else if (ecs)
            addSuccess(msg.emailCnfSuccess, model);

        if (request.getSession(false) != null &&
                request.getSession(false).getAttribute(Key.userInSession) != null) {
            Users u = (Users) request.getSession(false).getAttribute(Key.userInSession);
            addUser(u, model);

            return View.dashboard;
        } else {
            return Key.redirect + Route.home;
        }
    }
}
