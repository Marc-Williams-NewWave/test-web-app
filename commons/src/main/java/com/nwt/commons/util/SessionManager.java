package com.nwt.commons.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class to handle session management
 *
 * @author: Prabakar Singaram
 * @created: 4/28/2013 5:41 PM
 * @company: NewWave Technologies Inc
 */
public class SessionManager {
    public static HttpSession newSession(HttpServletRequest request) {
        return request.getSession(true);
    }
}
