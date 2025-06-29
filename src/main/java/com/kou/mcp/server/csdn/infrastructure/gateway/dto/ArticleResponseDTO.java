package com.kou.mcp.server.csdn.infrastructure.gateway.dto;

import lombok.Data;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:41
 */
@Data
public class ArticleResponseDTO {
    private Integer code;
    private String traceId;
    private ArticleData data;
    private String msg;

    @Data
    public static class ArticleData {
        private String url;
        private Long id;
        private String qrcode;
        private String title;
        private String description;
    }
}
