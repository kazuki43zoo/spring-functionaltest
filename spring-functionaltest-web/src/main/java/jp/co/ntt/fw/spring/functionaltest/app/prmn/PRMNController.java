/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.prmn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PRMNController {

    @RequestMapping("/")
    public String handle() {
        return "prmn/index";
    }

}
