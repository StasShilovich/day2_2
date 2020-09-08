package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextComponent {
    private List<TextComponent> sentences = new LinkedList<>();

    @Override
    public void add(TextComponent component) {
        sentences.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        sentences.remove(component);
    }

    @Override
    public String getComponents() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent sentence : sentences) {
            builder.append(sentence);
        }
        return builder.toString();
    }
}
