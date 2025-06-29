package com.kou.mcp.server.csdn.types.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:41
 */
@ConfigurationProperties(prefix = "csdn.api")
@Component
public class CSDNApiProperties {

    private String cookie;

    private String categories;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
