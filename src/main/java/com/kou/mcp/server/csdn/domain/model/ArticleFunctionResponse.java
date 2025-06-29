package com.kou.mcp.server.csdn.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:40
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleFunctionResponse {

    @JsonProperty(required = true, value = "code")
    @JsonPropertyDescription("code")
    private Integer code;

    @JsonProperty(required = true, value = "msg")
    @JsonPropertyDescription("msg")
    private String msg;

}