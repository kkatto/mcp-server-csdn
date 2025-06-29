package com.kou.mcp.server.csdn.domain.service;

import com.kou.mcp.server.csdn.domain.adapter.ICSDNPort;
import com.kou.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import com.kou.mcp.server.csdn.domain.model.ArticleFunctionResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:40
 */
@Slf4j
@Service
public class CSDNArticleService {

    @Resource
    private ICSDNPort port;

    @Tool(description = "发布文章到CSDN")
    public ArticleFunctionResponse saveArticle(ArticleFunctionRequest request) throws IOException {
        log.info("CSDN发帖，标题:{} 内容:{} 标签:{}", request.getTitle(), request.getMarkdowncontent(), request.getTags());
        return port.writeArticle(request);
    }
}
