/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.vldt;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("vldt/0101/005")
public class VLDT0101005Controller {

    @ModelAttribute
    public DisplayOutsideMessagePropertyForm setUpForm() {
        return new DisplayOutsideMessagePropertyForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String handle() {
        return "vldt/displayOutsideMessagePropertyView";
    }

    @RequestMapping(method = RequestMethod.POST, params = "validate")
    public String handleValidate(
            @Validated DisplayOutsideMessagePropertyForm form,
            BindingResult result) {

        if (result.hasErrors()) {
            return "vldt/displayOutsideMessagePropertyView";
        }
        return "redirect:/vldt/0101/005";
    }
}
