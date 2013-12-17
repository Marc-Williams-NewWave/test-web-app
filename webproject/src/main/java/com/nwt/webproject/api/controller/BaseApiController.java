package com.nwt.webproject.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nwt.framework.aop.ExceptionHandlerAdvice;
import com.nwt.framework.common.Const;
import com.nwt.framework.controller.BaseController;
import com.nwt.framework.data.BaseService;
import com.nwt.framework.data.Entity;
import com.nwt.framework.response.Response;
import com.nwt.framework.validation.Validity;
import com.nwt.webproject.common.Key;
import com.nwt.webproject.common.Message;
import com.nwt.webproject.common.Props;

/**
 * Base API controller to provide basic functionality
 * to the extending classes to handle exceptions
 * and render responses
 *
 * @author: Prabakar Singaram
 * @created: 3/17/2013 9:44 PM
 * @company: NewWave Technologies Inc
 */
public class BaseApiController extends BaseController {
    protected @Autowired ExceptionHandlerAdvice exceptionHandlerAdvice;
    protected @Autowired HttpServletRequest request;
    protected @Autowired Key key;
    protected @Autowired Message msg;
    protected @Autowired Props props;
    private Logger log = LoggerFactory.getLogger(BaseApiController.class);


    protected Response serverResponse() {
        Response response = new Response();
        exceptionHandlerAdvice.setResponse(response);
        return response;
    }


    protected ModelAndView mav() {
        return new ModelAndView();
    }


    public Response validateAndSaveEntity(Entity entity, BaseService service) {
        Response response = serverResponse();
        try {
            Validity vsEntity = service.validate(entity);
            if (vsEntity.isValid()) {
                service.insert(entity);
                response.setResult(entity);
            } else {
                response.setError(key.vdnCode, vsEntity.errors());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setError(key.iseCode, e.getMessage());
        }

        return response;
    }


    @ExceptionHandler(Exception.class)
    public @ResponseBody ModelAndView exceptionHandler(Exception ex) {
        Response response = new Response();
        response.setError(500, ex.getMessage());
        log.error("Response: " + response.toString());
        return mav().addObject(Const.responseKey, response);
    }
}
