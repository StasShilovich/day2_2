package com.shilovich.day2_2.service.factory;

import com.shilovich.day2_2.service.TextService;
import com.shilovich.day2_2.service.impl.TextServiceImpl;
import com.shilovich.day2_2.service.parser.TextParser;
import com.shilovich.day2_2.service.parser.impl.LineParserImpl;
import com.shilovich.day2_2.service.parser.impl.ParagraphParserImpl;
import com.shilovich.day2_2.service.parser.impl.SentenceParserImpl;
import com.shilovich.day2_2.service.parser.impl.TextParserImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextParser textParser = new TextParserImpl();
    private final TextParser lineParser = new LineParserImpl();
    private final TextParser paragraphParser = new ParagraphParserImpl();
    private final TextParser sentenceParser = new SentenceParserImpl();
    private final TextService textService = new TextServiceImpl();

    public TextParser getTextParser() {
        return textParser;
    }

    public TextParser getLineParser() {
        return lineParser;
    }

    public TextParser getParagraphParser() {
        return paragraphParser;
    }

    public TextParser getSentenceParser() {
        return sentenceParser;
    }

    public TextService getTextService() {
        return textService;
    }

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
