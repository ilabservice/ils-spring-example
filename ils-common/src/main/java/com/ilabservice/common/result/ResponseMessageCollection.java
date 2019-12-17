package com.ilabservice.common.result;

import java.util.Map;

public class ResponseMessageCollection {
    public static final String DEFAULT_LANGUAGE = "chinese";

    public static Map<String, String> englishErrorMessage;

    public static Map<String, String> chineseErrorMessage;

    public static Map<String, Map<String, String>> errorMessageByLanguage;
}
