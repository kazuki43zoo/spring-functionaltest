/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.rscl;

import javax.inject.Inject;

import jp.co.ntt.fw.spring.functionaltest.domain.model.UserResource;
import jp.co.ntt.fw.spring.functionaltest.domain.service.rscl.ProxyRestClientService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("rscl")
@Controller
public class RSCL14Controller {

    @Inject
    ProxyRestClientService proxyRestClientService;

    @RequestMapping(value = "1401/001", method = RequestMethod.GET)
    public String handle1401001First(Model model) {

        model.addAttribute("testDescription", "Proxy経由によるREST API呼び出し");
        model.addAttribute("testId", "1401/001");

        return "rscl/callViaProxy";
    }

    @RequestMapping(value = "1401/001", method = RequestMethod.POST)
    public String handle1401001(Model model, @RequestParam String path) {

        UserResource rcvUser = this.proxyRestClientService.confirmProxy01(path);

        model.addAttribute("resultDescription",
                "Proxyホスト/ポートをプロパティファイルに定義し、Proxy経由で、REST APIを呼び出し、JavaBeanを取得する");
        model.addAttribute("user", rcvUser);

        return "rscl/resultUserInf";
    }

    @RequestMapping(value = "1401/002", method = RequestMethod.GET)
    public String handle1401002First(Model model) {

        model.addAttribute("testDescription", "Proxy経由によるREST API呼び出し");
        model.addAttribute("testId", "1401/002");

        return "rscl/callViaProxy";
    }

    @RequestMapping(value = "1401/002", method = RequestMethod.POST)
    public String handle1401002(Model model, @RequestParam String path) {

        UserResource rcvUser = this.proxyRestClientService.confirmProxy02(path);

        model.addAttribute("resultDescription",
                "Proxyホスト/ポートをプロパティファイルに定義し、Proxy経由で、REST APIを呼び出し、JavaBeanを取得する");
        model.addAttribute("user", rcvUser);

        return "rscl/resultUserInf";
    }

    @RequestMapping(value = "1402/001", method = RequestMethod.GET)
    public String handle1402001First(Model model) {

        model.addAttribute("testDescription", "Proxy経由によるREST API呼び出し");
        model.addAttribute("testId", "1402/001");

        return "rscl/callViaProxy";
    }

    @RequestMapping(value = "1402/001", method = RequestMethod.POST)
    public String handle1402001(Model model, @RequestParam String path) {

        UserResource rcvUser = this.proxyRestClientService
                .confirmSimpleHttpClientProxy(path);

        model.addAttribute("resultDescription",
                "Proxyホスト/ポートをプロパティファイルに定義し、Proxy経由で、REST APIを呼び出し、JavaBeanを取得する");
        model.addAttribute("user", rcvUser);

        return "rscl/resultUserInf";
    }
}
