package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.TextComposite;
import com.shilovich.day2_2.service.factory.ServiceFactory;
import com.shilovich.day2_2.service.parser.TextParser;

public class ParagraphParserImpl implements TextParser {
    private static final String PUNCT_REGEX = "(?<=(?<![A-Z])\\.)";

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent graph = new TextComposite(ComponentType.PARAGRAPH);
        ServiceFactory factory = ServiceFactory.getInstance();
        TextParser sentenceParser = factory.getSentenceParser();
        String[] sentences = paragraph.split(PUNCT_REGEX);
        for (String sent : sentences) {
            TextComponent parse = sentenceParser.parse(sent);
            graph.add(parse);
        }
        return graph;
    }
}
