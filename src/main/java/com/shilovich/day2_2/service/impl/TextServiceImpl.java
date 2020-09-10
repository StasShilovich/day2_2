package com.shilovich.day2_2.service.impl;

import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.factory.DaoFactory;
import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.Word;
import com.shilovich.day2_2.service.TextService;
import com.shilovich.day2_2.service.exception.ServiceException;
import com.shilovich.day2_2.service.factory.ServiceFactory;
import com.shilovich.day2_2.service.parser.TextParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public List<String> displaySentenceOrderByNumberWords() throws ServiceException {
        try {
            List<TextComponent> textSentences = new ArrayList<>();
            List<TextComponent> textParagraphs = parseText().receiveComponents();
            for (TextComponent paragraph : textParagraphs) {
                if (paragraph.getType().equals(ComponentType.PARAGRAPH)) {
                    textSentences.addAll(paragraph.receiveComponents());
                }
            }
            textSentences.sort(Comparator.comparingInt(sent -> {
                int count = 0;
                List<TextComponent> textComponents = sent.receiveComponents();
                for (TextComponent textComponent : textComponents) {
                    if (textComponent.getType().equals(ComponentType.WORD)) {
                        count++;
                    }
                }
                return count;
            }));
            List<String> result = new ArrayList<>();
            for (TextComponent textSentence : textSentences) {
                result.add(textSentence.getComponent());
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public TextComponent swapWords() throws ServiceException {
        try {
            TextComponent component = parseText();
            List<TextComponent> textParagraphs = component.receiveComponents();
            for (TextComponent paragraph : textParagraphs) {
                if (paragraph.getType().equals(ComponentType.PARAGRAPH)) {
                    List<TextComponent> textSentences = paragraph.receiveComponents();
                    for (TextComponent textSentence : textSentences) {
                        List<TextComponent> textWords = textSentence.receiveComponents();
                        int firstWord = textWords.indexOf(findFirstWord(textWords));
                        int lastWord = textWords.indexOf(findLastWord(textWords));
                        Collections.swap(textWords, firstWord, lastWord);
                    }
                }
            }
            return component;
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public TextComponent replaceWord(int numberOfSentence, int wordLength, String substring) throws ServiceException {
        try {
            TextComponent component = parseText();
            List<TextComponent> textParagraphs = component.receiveComponents();
            for (TextComponent paragraph : textParagraphs) {
                if (paragraph.getType().equals(ComponentType.PARAGRAPH)) {
                    List<TextComponent> textSentences = paragraph.receiveComponents();
                    if (numberOfSentence >= 0 && numberOfSentence < textSentences.size()) {
                        TextComponent sentence = textSentences.get(numberOfSentence);
                        List<TextComponent> words = sentence.receiveComponents();
                        for (TextComponent word : words) {
                            if (word.getType().equals(ComponentType.WORD)
                                    && word.getComponent().trim().length() == wordLength) {
                                Word newWord = new Word(substring, ComponentType.WORD);
                                words.set(words.indexOf(word), newWord);
                            }
                        }
                    }
                }
            }
            return component;
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    private TextComponent findLastWord(List<TextComponent> textWords) {
        for (int i = textWords.size() - 1; i > 0; i--) {
            if (textWords.get(i).getType().equals(ComponentType.WORD)) {
                return textWords.get(i);
            }
        }
        return null;
    }

    private TextComponent findFirstWord(List<TextComponent> textWords) {
        for (TextComponent textWord : textWords) {
            if (textWord.getType().equals(ComponentType.WORD)) {
                return textWord;
            }
        }
        return null;
    }

    private TextComponent parseText() throws DaoException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        String text = daoFactory.getReader().read();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextParser textParser = serviceFactory.getTextParser();
        return textParser.parse(text);
    }
}