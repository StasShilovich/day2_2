package com.shilovich.day2_2.service;

import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.service.exception.ServiceException;

import java.util.List;

public interface TextService {
    List<String> displaySentenceOrderByNumberWords() throws ServiceException;

    TextComponent swapWords() throws ServiceException;

    TextComponent replaceWord(int numberOfSentence, int wordLength, String substring) throws ServiceException;
}
