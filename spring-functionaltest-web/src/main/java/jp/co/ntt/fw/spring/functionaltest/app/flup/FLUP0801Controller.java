/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.flup;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.ntt.fw.spring.functionaltest.app.flup.SingleUploadForm.UploadFileAllowJsp;
import jp.co.ntt.fw.spring.functionaltest.domain.model.UploadFile;
import jp.co.ntt.fw.spring.functionaltest.domain.service.flup.FileUploadService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

/**
 * 本アプリでは、原則、大項目単位でcontrollerを作成するが、 ファイルアップロード機能では、中項目単位でweb.xmlのパラメータを変更する試験が存在するため、 統一して中項目ごとにController作成をしている。
 */
@RequestMapping("flup/0801")
@Controller
public class FLUP0801Controller {

    @Inject
    FileUploadService fileUploadService;

    @ModelAttribute
    public SingleUploadForm setUpForm() {
        return new SingleUploadForm();
    }

    @RequestMapping(value = "001")
    public String handle001Form() {
        return "flup/directFileUploadForm";
    }

    @RequestMapping(value = "001", method = RequestMethod.POST)
    public String handle001Upload(
            @Validated({ UploadFileAllowJsp.class }) SingleUploadForm form,
            BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

        if (result.hasErrors()) {
            return handle001Form();
        }

        MultipartFile multipartFile = form.getMultipartFile();
        UploadFile newUploadFile = new UploadFile();
        newUploadFile.setFileName(multipartFile.getOriginalFilename());
        newUploadFile.setContentType(multipartFile.getContentType());

        UploadFile savedUploadFile = fileUploadService.saveFileToDisc(
                multipartFile.getInputStream(), newUploadFile);

        UploadedContent uploadedContent = new UploadedContent();
        uploadedContent.setFileId(savedUploadFile.getFileId());
        uploadedContent.setFileName(savedUploadFile.getFileName());
        redirectAttributes.addFlashAttribute(uploadedContent);

        redirectAttributes.addFlashAttribute(ResultMessages.success().add(
                "i.sf.flup.0002"));

        return "redirect:/flup/0801/001?complete";
    }

    @RequestMapping(value = "001", method = RequestMethod.GET, params = "complete")
    public String handleComplete() {
        return "flup/directFileUploadComplete";
    }

}
