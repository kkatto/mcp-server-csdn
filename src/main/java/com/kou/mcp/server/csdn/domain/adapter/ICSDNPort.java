package com.kou.mcp.server.csdn.domain.adapter;

import com.kou.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import com.kou.mcp.server.csdn.domain.model.ArticleFunctionResponse;

import java.io.IOException;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:39
 */
public interface ICSDNPort {

    ArticleFunctionResponse writeArticle(ArticleFunctionRequest request) throws IOException;

}
