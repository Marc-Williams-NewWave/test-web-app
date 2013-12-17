package com.nwt.webproject.webapp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nwt.webproject.webapp.common.Route;
import com.nwt.webproject.webapp.common.View;

/**
 * App central controller to render home page
 *
 * @author: Prabakar Singaram
 * @created: 2/28/2013 7:54 AM
 * @company: NewWave Technologies Inc
 */
@Controller
public class AppController extends BaseWebAppController {

    @RequestMapping(value = Route.home, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return View.home;
    }
}
