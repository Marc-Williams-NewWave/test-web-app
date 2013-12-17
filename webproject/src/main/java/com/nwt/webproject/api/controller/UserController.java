package com.nwt.webproject.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nwt.framework.response.Response;
import com.nwt.framework.validation.Validity;
import com.nwt.webproject.api.common.ApiRoute;
import com.nwt.webproject.common.Key;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.model.entity.request.UserRO;
import com.nwt.webproject.service.UserService;

/**
 * Controller to allow CRUD on User domain entity.
 *
 * @author: Prabakar Singaram
 * @created: 3/22/2013 8:14 AM
 * @company: NewWave Technologies Inc
 */
@Controller
@RequestMapping(ApiRoute.userController)
public class UserController extends BaseApiController {
    private @Autowired UserService userService;
    private Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = ApiRoute.uRegister, method = RequestMethod.POST)
    public @ResponseBody ModelAndView register(@RequestBody UserRO userRO,
                                               @RequestHeader("pass") String password) {
        Response response = serverResponse();
        try {
            Users user = userRO.user(props);
            user.setPassWord(password);
            Validity vsUser = userService.validate(user);
            if (vsUser.isValid()) {
                userService.registerUser(user, request);
                response.setResult(user);
            } else {
                response.setError(key.vdnCode, vsUser.errorMsgs());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setError(key.iseCode, e.getMessage());
        }

        return mav().addObject(Key.response, response);
    }

}
