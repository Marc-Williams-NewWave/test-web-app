package com.nwt.webproject.actor;

import com.nwt.framework.exception.service.NotYetImplementedException;
import com.nwt.webproject.model.entity.Users;

/**
 * Typed Actor to offload the mail sending activity
 * of the current thread
 *
 * @author: Prabakar Singaram
 * @created: 4/21/2013 5:27 PM
 * @company: NewWave Technologies Inc
 */
public interface MailSenderActor {
    /**
     * Sends a mail to the user asking him/her to
     * verify his email id.
     *
     * @param user
     */
    public void sendUserEmailIdVerificationMail(final Users user) throws NotYetImplementedException;


    /**
     * Sends a mail to the user informing him/her of successful
     * confirmation of their email address.
     *
     * @param user
     */
    public void sendUserEmailIdConfirmationMail(final Users user);
}
