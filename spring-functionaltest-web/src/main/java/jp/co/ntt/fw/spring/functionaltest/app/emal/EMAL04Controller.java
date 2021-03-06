/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.emal;

import java.util.Arrays;

import javax.inject.Inject;

import jp.co.ntt.fw.spring.functionaltest.domain.model.User;
import jp.co.ntt.fw.spring.functionaltest.domain.service.emal.AuthErrorMailSendingService;
import jp.co.ntt.fw.spring.functionaltest.domain.service.emal.ConnectionErrorMailSendingService;
import jp.co.ntt.fw.spring.functionaltest.domain.service.emal.SessionMailSendingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("emal")
public class EMAL04Controller {

    @Inject
    AuthErrorMailSendingService authErrorMailSendingService;

    @Inject
    SessionMailSendingService sessionMailSendingService;

    @Inject
    ConnectionErrorMailSendingService connectionErrorMailSendingService;

    @ModelAttribute
    EmailSendingForm setUpForm() {
        EmailSendingForm form = new EmailSendingForm();
        return form;
    }

    @RequestMapping(value = "0401/001", method = RequestMethod.GET)
    public String handle01001(EmailSendingForm form) {
        form.setTo(Arrays.asList(""));
        form.setTestcase("authenticationException");
        return "emal/sendMail";
    }

    @RequestMapping(value = "0401/002", method = RequestMethod.GET)
    public String handle01002(EmailSendingForm form) {
        form.setTo(Arrays.asList(""));
        form.setTestcase("parseException");
        return "emal/sendMail";
    }

    @RequestMapping(value = "0401/003", method = RequestMethod.GET)
    public String handle01003(EmailSendingForm form) {
        form.setTo(Arrays.asList(""));
        form.setTestcase("preparationException");
        return "emal/sendMail";
    }

    @RequestMapping(value = "0401/004", method = RequestMethod.GET)
    public String handle01004(EmailSendingForm form) {
        form.setTo(Arrays.asList(""));
        form.setTestcase("sendException");
        return "emal/sendMail";
    }

    @RequestMapping(value = "sendmail", method = RequestMethod.POST, params = "testcase=authenticationException")
    public String handleAuthenticationException(Model model,
            EmailSendingForm form) {
        authErrorMailSendingService.popBeforeSmtp();
        authErrorMailSendingService.sendMessage(form.getTo().get(0), form
                .getText());
        return "redirect:/emal/receivemail";
    }

    @RequestMapping(value = "sendmail", method = RequestMethod.POST, params = "testcase=parseException")
    public String handleParseException(Model model, EmailSendingForm form) {
        sessionMailSendingService.popBeforeSmtp();
        sessionMailSendingService.sendSimpleMessage(form.getTo().get(0), form
                .getText());
        return "redirect:/emal/receivemail";
    }

    @RequestMapping(value = "sendmail", method = RequestMethod.POST, params = "testcase=preparationException")
    public String handlePreparationException(Model model, EmailSendingForm form) {
        sessionMailSendingService.popBeforeSmtp();
        User user = new User();
        user.setUsername(form.getText());
        sessionMailSendingService.sendTemplatedMail(form.getTo().get(0), user,
                form.getTemplateName());
        return "redirect:/emal/receivemail";
    }

    @RequestMapping(value = "sendmail", method = RequestMethod.POST, params = "testcase=sendException")
    public String handleSendException(Model model, EmailSendingForm form) {
        connectionErrorMailSendingService.popBeforeSmtp();
        connectionErrorMailSendingService.sendMessage(form.getTo().get(0), form
                .getText());
        return "redirect:/emal/receivemail";
    }

}
