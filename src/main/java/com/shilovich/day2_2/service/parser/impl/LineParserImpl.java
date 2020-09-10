package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;

import com.shilovich.day2_2.entity.impl.CodeBlock;
import com.shilovich.day2_2.service.factory.ServiceFactory;
import com.shilovich.day2_2.service.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParserImpl implements TextParser {
    private static final String SENTENCE_REGEX = "([^(.|!?)]+)(\\.|!|\\?)";

    @Override
    public TextComponent parse(String line) {
        ServiceFactory factory = ServiceFactory.getInstance();
        TextParser paragraphParser = factory.getParagraphParser();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(line.trim());
        if (matcher.find()) {
            return paragraphParser.parse(line);
        } else {
            return new CodeBlock(line, ComponentType.CODE_BLOCK);
        }
    }
}