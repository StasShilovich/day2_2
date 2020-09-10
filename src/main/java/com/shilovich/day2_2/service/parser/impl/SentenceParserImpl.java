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
    private static final String BOUNDARY = "\\s+|(?=[^\\w'])|(?<=\\W)(?=')";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sent = new TextCompositeImpl();
        String[] lexemes = sentence.split(BOUNDARY);
        for (String lexeme : lexemes) {
            Pattern pattern = Pattern.compile(PUNCT_REGEX);
            Matcher matcher = pattern.matcher(lexeme.trim());
            if (matcher.find()) {
                sent.add(new Punctuation(lexeme));
            } else if (lexeme.trim().length() != 0) {
                sent.add(new Word(lexeme));
            }
        }
        return sent;
    }
}