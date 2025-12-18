package com.guide.controller;

import com.guide.service.RagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * RAG 控制器
 * 提供基于检索增强生成（RAG）的问答接口
 * 
 * @author guide
 */
@RestController
@RequiredArgsConstructor
public class RagController {

    private final RagService ragService;

    /**
     * 流式问答接口
     * 通过流式响应返回答案
     * 
     * @param q 用户提问
     * @return Flux<String> 流式响应结果
     */
    @GetMapping(value = "/ask", produces = MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8")
    public Flux<String> ask(@RequestParam String q) {
        return ragService.askStream(q);
    }

    /**
     * 同步问答接口
     * 通过同步响应返回答案
     * 
     * @param q 用户提问
     * @return String 同步响应结果
     */
    @GetMapping(value = "/askSync", produces = MediaType.APPLICATION_JSON_VALUE)
    public String askSync(@RequestParam String q) {
        return ragService.ask(q);
    }
}