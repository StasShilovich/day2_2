package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.TextComponent;

import com.shilovich.day2_2.entity.impl.CodeBlock;
import com.shilovich.day2_2.entity.impl.TextCompositeImpl;
import com.shilovich.day2_2.service.factory.ServiceFactory;
import com.shilovich.day2_2.service.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParserImpl implements TextParser {
    private static final String SENTENCE_REGEX = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";

    @Override
    public TextComponent parse(String line) {
        TextComponent composite = new TextCompositeImpl();
        // TODO: 10.09.2020 factory for component
        ServiceFactory factory = ServiceFactory.getInstance();
        TextParser sentenceParser = factory.getSentenceParser();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            sentenceParser.parse(line);
        } else {
            composite.add(new CodeBlock(line));
        }
        return composite;
    }
}
