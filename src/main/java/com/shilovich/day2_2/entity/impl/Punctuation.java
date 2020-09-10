package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class Punctuation implements TextComponent {
    private String punctuation;
    private ComponentType type;

    public Punctuation(String punctuation, ComponentType type) {
        this.punctuation = punctuation;
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
        return String.valueOf(punctuation);
    }
}
