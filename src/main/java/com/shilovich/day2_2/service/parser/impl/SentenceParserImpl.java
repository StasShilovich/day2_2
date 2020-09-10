package com.shilovich.day2_2.service.parser.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.Punctuation;
import com.shilovich.day2_2.entity.impl.TextComposite;
import com.shilovich.day2_2.entity.impl.Word;
import com.shilovich.day2_2.service.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParserImpl implements TextParser {
    private static final String PUNCT_REGEX = "\\p{Punct}";
    private static final String BOUNDARY = "\\s+|(?=[^\\w'])|(?<=\\W)(?=')";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sent = new TextComposite(ComponentType.SENTENCE);
        String[] lexemes = sentence.split(BOUNDARY);
        for (String lexeme : lexemes) {
            Pattern pattern = Pattern.compile(PUNCT_REGEX);
            Matcher matcher = pattern.matcher(lexeme.trim());
            if (matcher.find() && lexeme.length() == 1) {
                sent.add(new Punctuation(lexeme, ComponentType.PUNCTUATION));
            } else if (lexeme.trim().length() != 0) {
                sent.add(new Word(lexeme, ComponentType.WORD));
            }
        }
        return sent;
    }
}