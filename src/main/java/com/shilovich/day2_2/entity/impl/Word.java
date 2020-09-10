package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class Word implements TextComponent {
    private String word;
    private ComponentType type;

    public Word(String word, ComponentType type) {
        this.word = word;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public List<TextComponent> receiveComponents() {
        return null;
    }

    @Override
    public String getComponent() {
        return word;
    }
}
