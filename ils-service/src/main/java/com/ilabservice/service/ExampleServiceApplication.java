package com.ilabservice.service;

import com.alibaba.fastjson.JSON;
import com.ilabservice.common.result.ResponseMessageCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class ExampleServiceApplication {

    public static void loadTranslation() {
        log.info("loading translation");
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("translation/en.json");
            ResponseMessageCollection.englishErrorMessage = JSON.parseObject(in, Charset.forName("UTF-8"), Map.class);
        } catch (Exception e){
            log.error("failed to read en.json, cannot do translation for English. err: " + e);
        }

        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("translation/zh.json");
            ResponseMessageCollection.chineseErrorMessage = JSON.parseObject(in, Charset.forName("UTF-8"), Map.class);
        } catch (Exception e){
            log.error("failed to read zh.json, cannot do translation for Chinese. err: " + e);
        }

        ResponseMessageCollection.errorMessageByLanguage = new HashMap<>();
        ResponseMessageCollection.errorMessageByLanguage.put("chinese", ResponseMessageCollection.chineseErrorMessage);
        ResponseMessageCollection.errorMessageByLanguage.put("english", ResponseMessageCollection.englishErrorMessage);
    }

    public static void main(String[] args){
        loadTranslation();
        SpringApplication.run(ExampleServiceApplication.class, args);
    }

}
