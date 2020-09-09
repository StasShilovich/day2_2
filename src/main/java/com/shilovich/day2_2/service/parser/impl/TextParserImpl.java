package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.TextCompositeImpl;
import com.shilovich.day2_2.service.factory.ServiceFactory;
import com.shilovich.day2_2.service.parser.TextParser;

public class TextParserImpl implements TextParser {

    @Override
    public TextComponent parse(String text) {
        TextComponent component = new TextCompositeImpl();
        ServiceFactory factory = ServiceFactory.getInstance();
        TextParser lineParser = factory.getLineParser();
        String[] split = text.split(System.lineSeparator());
        for (String line : split) {
            TextComponent parsed = lineParser.parse(line);
            component.add(parsed);
        }
        return component;
    }
}