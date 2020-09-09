package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.Punctuation;
import com.shilovich.day2_2.entity.impl.TextCompositeImpl;
import com.shilovich.day2_2.entity.impl.Word;
import com.shilovich.day2_2.service.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParserImpl implements TextParser {
    private static final String PUNCT_REGEX = "\\p{Punct}";
    private static final String SPACE_REGEX = "\\s";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent composite = new TextCompositeImpl();
        String[] lexemes = sentence.split(SPACE_REGEX);
        for (String lexeme : lexemes) {
            Pattern pattern = Pattern.compile(PUNCT_REGEX);
            Matcher matcher = pattern.matcher(lexeme);
            if (matcher.find()) {
                composite.add(new Punctuation(lexeme));
            } else {
                composite.add(new Word(lexeme));
            }
        }
        return  composite;
    }
}
