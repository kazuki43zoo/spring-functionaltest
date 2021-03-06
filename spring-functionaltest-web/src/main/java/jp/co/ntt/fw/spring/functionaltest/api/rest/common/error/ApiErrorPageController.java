/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.api.rest.common.error;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

// エラー応答を行うためのControllerクラス
@RequestMapping("error")
@RestController
public class ApiErrorPageController {

    @Inject
    ApiErrorCreator apiErrorCreator; // エラー情報を作成するクラス

    private final Map<HttpStatus, String> errorCodeMap = new HashMap<HttpStatus, String>();

    public ApiErrorPageController() {
        errorCodeMap.put(HttpStatus.SERVICE_UNAVAILABLE, "e.sf.cmn.0503");
    }

    // エラー応答を行う処理メソッド
    @RequestMapping
    public ResponseEntity<ApiError> handleErrorPage(WebRequest request) {
        // リクエストスコープに格納されているステータスコードを取得
        HttpStatus httpStatus = HttpStatus.valueOf((Integer) request
                .getAttribute(RequestDispatcher.ERROR_STATUS_CODE,
                        RequestAttributes.SCOPE_REQUEST));

        // ステータスコード毎のエラーコードを取得
        String errorCode = errorCodeMap.get(httpStatus);

        // リクエストパラメータで受け取ったエラーコードに対応するエラー情報を生成
        ApiError apiError = apiErrorCreator.createApiError(request, errorCode,
                httpStatus.getReasonPhrase());
        // 取得したエラー情報を応答
        return ResponseEntity.status(httpStatus).contentType(
                MediaType.APPLICATION_JSON_UTF8).body(apiError);
    }

}
