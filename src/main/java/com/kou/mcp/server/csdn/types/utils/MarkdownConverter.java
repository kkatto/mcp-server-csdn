package com.kou.mcp.server.csdn.types.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 * @author KouJY
 * @description
 * @create 2025-06-29 17:41
 */
public class MarkdownConverter {

    private static final Parser parser;
    private static final HtmlRenderer renderer;

    static {
        MutableDataSet options = new MutableDataSet();
        parser = Parser.builder(options).build();
        renderer = HtmlRenderer.builder(options).build();
    }

    public static String convertToHtml(String markdown) {
        if (markdown == null || markdown.trim().isEmpty()) {
            return "";
        }
        return renderer.render(parser.parse(markdown));
    }
}
