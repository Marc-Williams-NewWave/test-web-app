package com.nwt.webproject.webapp.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.nwt.framework.aop.ExceptionHandlerAdvice;
import com.nwt.framework.controller.BaseController;
import com.nwt.webproject.common.Key;
import com.nwt.webproject.common.Message;
import com.nwt.webproject.common.Props;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.webapp.common.View;

/**
 * Class to be extended by each of the controller
 * implementing WebApp methods and services for smooth access
 * to the commonly used server response object and integration
 * with ExceptionHandlerAdvice interceptor to communicate the
 * exact exception to the frontend for better debugging.
 *
 * @author: Prabakar Singaram
 * @created: 3/11/2013 12:41 AM
 * @company: NewWave Technologies Inc
 */
public class BaseWebAppController extends BaseController {
    private Logger log = LoggerFactory.getLogger(BaseWebAppController.class);
    protected @Autowired ExceptionHandlerAdvice exceptionHandlerAdvice;
    protected @Autowired HttpServletRequest httpReq;
    protected @Autowired Message msg;
    protected @Autowired Props props;
    protected @Autowired Key key;
    
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception ex, Locale locale) {
        ModelAndView mav = new ModelAndView(View.error);
        StringBuilder stack = new StringBuilder();

        log.error("[baseWebAppExceptionHandler] Response: " + ex.getMessage());
        mav.addObject("exception", ex.getMessage());
        for(StackTraceElement element : ex.getStackTrace()) {
            stack.append(element.toString());
            stack.append("\n");
        }

        mav.addObject("stack", stack.toString());
        return mav;
    }

    // Helper methods
    public void setup(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        model.addAttribute("alert", false);
        model.addAttribute("info", false);
        model.addAttribute("loggedIn", false);
    }

    public void addError(String message, Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorMessage", message);
    }

    public void addSuccess(String message, Model model) {
        model.addAttribute("success", true);
        model.addAttribute("successMessage", message);
    }

    public void addAlert(String message, Model model) {
        model.addAttribute("alert", true);
        model.addAttribute("alertMessage", message);
    }

    public void addInfo(String message, Model model) {
        model.addAttribute("info", true);
        model.addAttribute("infoMessage", message);
    }

    public void addInfoWithAction(String infoWithActionHeading, String infoWithActionContent,
                                  String infoWithActionPrimaryAction, String infoWithActionPrimaryActionLink,
                                  String infoWithActionSecAction, String infoWithActionSecActionLink,
                                  Model model) {
        model.addAttribute("infoWithAction", true);
        model.addAttribute("infoWithActionHeading", infoWithActionHeading);
        model.addAttribute("infoWithActionContent", infoWithActionContent);
        model.addAttribute("infoWithActionPrimaryAction", infoWithActionPrimaryAction);
        model.addAttribute("infoWithActionPrimaryActionLink", infoWithActionPrimaryActionLink);

        if(infoWithActionSecAction != null)
            model.addAttribute("infoWithActionSecAction", infoWithActionSecAction);

        if(infoWithActionSecActionLink != null)
            model.addAttribute("infoWithActionSecActionLink", infoWithActionSecActionLink);
    }

    public void addUser(Users user, Model model) {
        model.addAttribute("loggedIn", true);
        model.addAttribute("user", user);
    }

    public void loggedInUser(Model m, Users u) {
        m.addAttribute("loggedIn", true);
        m.addAttribute("user", u);
    }
}
