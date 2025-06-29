package com.kou.mcp.server.csdn.test;

import com.kou.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import com.kou.mcp.server.csdn.domain.model.ArticleFunctionResponse;
import com.kou.mcp.server.csdn.domain.service.CSDNArticleService;
import com.kou.mcp.server.csdn.infrastructure.gateway.ICSDNService;
import com.kou.mcp.server.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import com.kou.mcp.server.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import com.kou.mcp.server.csdn.types.utils.MarkdownConverter;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private final Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Autowired
    private ICSDNService csdnService;

    @Autowired
    private CSDNArticleService csdnArticleService;

    @Test
    public void test_saveArticle() throws IOException {
        // 1. 构建请求对象
        ArticleRequestDTO request = new ArticleRequestDTO();
        request.setTitle("测试文章标题01");
        request.setMarkdowncontent("# 测试文章内容\n这是一篇测试文章");
        request.setContent("<h1>测试文章内容</h1><p>这是一篇测试文章</p>");
        request.setReadType("public");
        request.setLevel("0");
        request.setTags("测试,文章");
        request.setStatus(0);
        request.setCategories("后端");
        request.setType("original");
        request.setOriginal_link("");
        request.setAuthorized_status(true);
        request.setDescription("这是一篇测试文章的描述");
        request.setResource_url("");
        request.setNot_auto_saved("0");
        request.setSource("pc_mdeditor");
        request.setCover_images(Collections.emptyList());
        request.setCover_type(0);
        request.setIs_new(1);
        request.setVote_id(0);
        request.setResource_id("");
        request.setPubStatus("draft");
        request.setSync_git_code(0);

        // 2. 调用接口
        String cookie = "UN=Mi_Manchikkk; c_dl_um=-; uuid_tt_dd=10_20862831380-1721893347330-777433; fid=20_94684560854-1724720809846-353297; ssxmod_itna=eqmx0DcQG=itn8Dl4iuCDUxQTmUi7e8Y=bGbqDl=GYxA5D8D6DQeGTbRWDB7Y1iDhh17boWqf5KF=CgDpE8QicbsTDCPGnDBIK4AFYxii9DCeDIDWeDiDG+7D=xGYDjjKGWD4qDOD3q0kkh5D76K44a7kKDDzKBAxtnDDKxi3LoHFDYHsDQKDnEhCT6KD9x0CDlP4A808DDHfL8G1RPSWWIbOVZ5DvxDkZ6KDo6PvDB+k2o5pVir3eihe/i0tIj+KqjTqW7D5rw1NYiiq8VaKqG=4MD1nT7pnDDP4YZPx4D=; ssxmod_itna2=eqmx0DcQG=itn8Dl4iuCDUxQTmUi7e8Y=bGD61+je40yDPY03q=RLUD6QQ7ikiGK+FgDGwNQqA6GBrOsAhhYKk3+bC24OCUITqK897ijGj+1qbOoOOfu0FMkX4HvdU7EKprYAlxY9402jdQnAroVUO6/U4QszLKORxj2AiqoPErDu2RK6o5eSTfYmnf2nBQtrW34/Wq273cVU3AoXbotHuv1UPuqpSb45qj1eZPCvPbOXCjqmljyBTby769/7bS5OZb6sxiIw1Lk6hbGMqrInANIy/EkaqlHlh8gkL2ZFMbwabMTD7jPWmK0mzjmrj54DADt0wOiD25DcDeDGcDG7KAPKDqF8D4D; UserName=Mi_Manchikkk; UserInfo=2947c3a2ef3a4c198b1d60da4fa12fce; UserToken=2947c3a2ef3a4c198b1d60da4fa12fce; UserNick=Mi_Manchikkk; AU=693; BT=1736498121946; p_uid=U010000; c_dl_prid=1736146572477_795056; c_dl_rid=1736932186526_849191; c_dl_fref=https://blog.csdn.net/zhangkongzhongyun/article/details/107974908; c_dl_fpage=/download/u014532217/10187174; _ga=GA1.1.712467673.1746970898; _ga_7W1N0GEY1P=GS2.1.s1746970898$o1$g1$t1746972252$j60$l0$h0; csdn_newcert_Mi_Manchikkk=1; c_segment=9; dc_sid=6ce0d63d4a2cfec253ca994398d5a064; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1749373005,1750811638; HMACCOUNT=EAEE6672DD08E29B; _clck=1tjawai%7C2%7Cfx6%7C0%7C1918; __gads=ID=ba527e1071fa8151:T=1743232964:RT=1751162555:S=ALNI_MZO4WrwZkCh60rd2ohTRfEhlPYbSQ; __gpi=UID=0000107e62fcbd7d:T=1743232964:RT=1751162555:S=ALNI_Mb1lOPAO8Q77tY4f-vudwiULCjssw; __eoi=ID=979cf714bac71331:T=1743232964:RT=1751162555:S=AA-AfjY-o8TlGW6jjzmKmH5c_1R0; FCNEC=%5B%5B%22AKsRol-0tizCRNg3ompP9mAVFp292_kgcmMj98CUDq8YCVZop41zdprD2o7cW3OyGeIFxW288nkTjtCXK7IzHVX2EyGaMeVnXX3Z3aTyV-Wbxb1izMD4xRyMb-3zRo3Z0nVjC6Lm1qM9ttuPo2PMFLtDw8fyTZ4HhA%3D%3D%22%5D%5D; _clsk=6whrd2%7C1751162627174%7C3%7C0%7Cs.clarity.ms%2Fcollect; dc_session_id=10_1751200410773.620421; c_first_ref=default; c_first_page=https%3A//www.csdn.net/; c_dsid=11_1751200410675.122421; c-sidebar-collapse=0; c_ab_test=1; creativeSetApiNew=%7B%22toolbarImg%22%3A%22https%3A//img-home.csdnimg.cn/images/20230921102607.png%22%2C%22publishSuccessImg%22%3A%22https%3A//img-home.csdnimg.cn/images/20240229024608.png%22%2C%22articleNum%22%3A6%2C%22type%22%3A2%2C%22oldUser%22%3Atrue%2C%22useSeven%22%3Afalse%2C%22oldFullVersion%22%3Atrue%2C%22userName%22%3A%22Mi_Manchikkk%22%7D; creative_btn_mp=1; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1751200415; c_pref=https%3A//www.csdn.net/; c_ref=https%3A//editor.csdn.net/; c_page_id=default; log_Id_pv=3; log_Id_view=92; dc_tos=symaxm; log_Id_click=5";
        Call<ArticleResponseDTO> call = csdnService.saveArticle(request, cookie);
        Response<ArticleResponseDTO> response = call.execute();

        System.out.println("\r\n测试结果" + JSON.toJSONString(response));

        // 3. 验证结果
        if (response.isSuccessful()) {
            ArticleResponseDTO articleResponseDTO = response.body();
            log.info("发布文章成功 {}", articleResponseDTO);
        }
    }

    @Test
    public void test_md2html() {
        System.out.println(MarkdownConverter.convertToHtml("**关于DDD是什么，在维基百科有一个明确的定义。\"Domain-driven design (DDD) is a major software design approach.\" 也就是说DDD是一种主要的软件设计方法。而软件设计涵盖了；范式、模型、框架、方法论。**\n" +
                "\n" +
                "- 范式（paradigm）指的是一种编程思想。\n" +
                "- 模型（model）指的是对现实世界或者问题的抽象描述。\n" +
                "- 框架（framework）指的是提供了一系列通用功能和结构的软件工具。\n" +
                "- 方法论（methodology）指的是一种系统的、有组织的解决问题的方法。\n" +
                "\n" +
                "所以，DDD不只是只有指导思想，伴随的DDD的还包括框架结构分层。但说到底，这些仍然是理论讨论。在没有一个DDD落地项目物参考下，其实大部分码农是没法完成DDD开发的。所以小傅哥今年花费了5个月假期/周末的时间，完成的《DDD简明开发教程》，帮助大家落地DDD编码。"));
    }

    @Test
    public void test_domain_saveArticle() throws IOException {
        String json = "{\"content\":\"<h2>场景：</h2>\\n<p>在某互联网大厂的面试室，一位严肃的面试官正准备提问，而对面坐着一位看似紧张却又想显得轻松的程序员小张。</p>\\n<p><strong>面试官</strong>：我们先来聊聊Java核心知识。第一个问题，Java中的JVM是如何管理内存的？</p>\\n<p><strong>程序员小张</strong>：哦，这个简单！JVM就像一个巨大的购物车，负责把所有的变量都放进去，呃……然后就……管理起来？</p>\\n<p><strong>面试官</strong>：嗯，第二个问题，请说说HashMap的工作原理。</p>\\n<p><strong>程序员小张</strong>：HashMap嘛，就是……呃，一个很大的箱子，大家都往里面扔东西，有时候会打架……</p>\\n<p><strong>面试官</strong>：那么第三个问题，能不能讲讲Spring和SpringBoot的区别？</p>\\n<p><strong>程序员小张</strong>：Spring是……呃，春天？SpringBoot就是穿靴子的春天嘛！哈哈……</p>\\n<p><strong>面试官</strong>：好，今天的问题就问到这里。回去等通知吧。</p>\\n<h2>答案解析：</h2>\\n<ol>\\n<li>\\n<p><strong>JVM内存管理</strong>：JVM内存管理包括堆内存和栈内存，堆内存用于存储对象实例，栈内存用于执行线程时的栈帧。</p>\\n</li>\\n<li>\\n<p><strong>HashMap原理</strong>：HashMap通过哈希函数将键映射到对应的值，并通过链表解决哈希冲突。</p>\\n</li>\\n<li>\\n<p><strong>Spring与SpringBoot区别</strong>：Spring是一个大型应用框架，而SpringBoot是基于Spring的快速开发套件，简化了Spring应用的配置。</p>\\n</li>\\n</ol>\\n\",\"cover_images\":[],\"cover_type\":0,\"description\":\"在互联网大厂的面试中，严肃的面试官与搞笑的程序员上演了一场精彩的对话。面试官提出Java核心知识、HashMap、Spring等问题，程序员则用幽默的方式作答。本文不仅展现了轻松的面试氛围，还附上了详细的技术问题答案解析，帮助读者更好地理解相关知识。\",\"is_new\":1,\"level\":\"0\",\"markdowncontent\":\"## 场景：\\n\\n在某互联网大厂的面试室，一位严肃的面试官正准备提问，而对面坐着一位看似紧张却又想显得轻松的程序员小张。\\n\\n**面试官**：我们先来聊聊Java核心知识。第一个问题，Java中的JVM是如何管理内存的？\\n\\n**程序员小张**：哦，这个简单！JVM就像一个巨大的购物车，负责把所有的变量都放进去，呃……然后就……管理起来？\\n\\n**面试官**：嗯，第二个问题，请说说HashMap的工作原理。\\n\\n**程序员小张**：HashMap嘛，就是……呃，一个很大的箱子，大家都往里面扔东西，有时候会打架……\\n\\n**面试官**：那么第三个问题，能不能讲讲Spring和SpringBoot的区别？\\n\\n**程序员小张**：Spring是……呃，春天？SpringBoot就是穿靴子的春天嘛！哈哈……\\n\\n**面试官**：好，今天的问题就问到这里。回去等通知吧。\\n\\n## 答案解析：\\n\\n1. **JVM内存管理**：JVM内存管理包括堆内存和栈内存，堆内存用于存储对象实例，栈内存用于执行线程时的栈帧。\\n\\n2. **HashMap原理**：HashMap通过哈希函数将键映射到对应的值，并通过链表解决哈希冲突。\\n\\n3. **Spring与SpringBoot区别**：Spring是一个大型应用框架，而SpringBoot是基于Spring的快速开发套件，简化了Spring应用的配置。\",\"not_auto_saved\":\"0\",\"pubStatus\":\"draft\",\"readType\":\"public\",\"resource_id\":\"\",\"resource_url\":\"\",\"source\":\"pc_mdeditor\",\"status\":0,\"sync_git_code\":0,\"tags\":\"Java,面试,互联网,程序员,Spring,SpringBoot,HashMap,JVM\",\"title\":\"互联网大厂Java面试：严肃面试官与搞笑程序员的对决\",\"vote_id\":0}";
        ArticleFunctionRequest request = JSON.parseObject(json, ArticleFunctionRequest.class);
        ArticleFunctionResponse response = csdnArticleService.saveArticle(request);
        log.info("测试结果:{}", JSON.toJSONString(response));
    }

}
