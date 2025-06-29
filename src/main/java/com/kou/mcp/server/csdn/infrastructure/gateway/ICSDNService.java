package com.kou.mcp.server.csdn.infrastructure.gateway;

import com.kou.mcp.server.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import com.kou.mcp.server.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:40
 */
public interface ICSDNService {

    @Headers({
            "accept: */*",
            "accept-language: zh-CN,zh;q=0.9,en;q=0.8",
            "cache-control: no-cache",
            "content-type: application/json",
            "origin: https://editor.csdn.net",
            "pragma: no-cache",
            "priority: u=1, i",
            "referer: https://editor.csdn.net/",
            "sec-ch-ua: \"Google Chrome\";v=\"137\", \"Chromium\";v=\"137\", \"Not/A)Brand\";v=\"24\"",
            "sec-ch-ua-mobile: ?0",
            "sec-ch-ua-platform: \"Windows\"",
            "sec-fetch-dest: empty",
            "sec-fetch-mode: cors",
            "sec-fetch-site: same-site",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36",
            "x-ca-key: 203803574",
            "x-ca-nonce: ef6d9e05-0697-4818-b841-23c206585bc2",
            "x-ca-signature: ny7tqe2Am3AwYEfeMIHCu3nmA3NsbL8IosvGIq8T1/o=",
            "x-ca-signature-headers: x-ca-key,x-ca-nonce",
    })
    @POST("/blog-console-api/v3/mdeditor/saveArticle")
    Call<ArticleResponseDTO> saveArticle(@Body ArticleRequestDTO request, @Header("Cookie") String cookieValue);
}
