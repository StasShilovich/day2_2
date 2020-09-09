package com.shilovich.day2_2.service.factory;

import com.shilovich.day2_2.service.parser.TextParser;
import com.shilovich.day2_2.service.parser.impl.LineParserImpl;
import com.shilovich.day2_2.service.parser.impl.SentenceParserImpl;
import com.shilovich.day2_2.service.parser.impl.TextParserImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextParser textParser = new TextParserImpl();
    private final TextParser lineParser = new LineParserImpl();
    private final TextParser sentenceParser = new SentenceParserImpl();

    public TextParser getTextParser() {
        return textParser;
    }

    public TextParser getLineParser() {
        return lineParser;
    }

    public TextParser getSentenceParser() {
        return sentenceParser;
    }

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
