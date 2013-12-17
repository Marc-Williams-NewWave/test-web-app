package com.nwt.webproject.actor.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import akka.actor.TypedActor;

import com.nwt.framework.exception.service.NotYetImplementedException;
import com.nwt.webproject.actor.MailSenderActor;
import com.nwt.webproject.common.Props;
import com.nwt.webproject.model.entity.Users;

/**
 * Mail sender actor impl
 *
 * @author: Prabakar Singaram
 * @created: 4/21/2013 5:29 PM
 * @company: NewWave Technologies Inc
 */
public class MailSenderActorImpl extends TypedActor implements MailSenderActor {
    private VelocityEngine velocityEngine;
    private JavaMailSender javaMailSender;
    private Props props;


     public void sendUserEmailIdVerificationMail(Users user) throws NotYetImplementedException {
        throw new NotYetImplementedException("email verification");
    }


     public void sendUserEmailIdConfirmationMail(final Users user) {
        Map model = new HashMap();
        model.put("user", user);

        MimeMessagePreparator preparator = prepareMail(user.getEmail(), props.fromAddress,
                props.subConfirmationEmail, "velocity/confirmation.vm", model);
        this.javaMailSender.send(preparator);
    }


    public MimeMessagePreparator prepareMail(final String to, final String from, final String subject,
                                             final String template, final Map model) {
        return new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(from);
                message.setSubject(subject);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, template, model);
                message.setText(text, true);
            }
        };
    }


    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }


    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }


    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }


    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public Props getProps() {
        return props;
    }


    public void setProps(Props props) {
        this.props = props;
    }
}
