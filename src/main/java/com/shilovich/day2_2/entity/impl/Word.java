package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class Word implements TextComponent {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public void add(TextComponent component) {

    }

    @Override
    public void remove(TextComponent component) {

    }

    @Override
    public void addList(List<TextComponent> components) {

    }

    @Override
    public String getComponent() {
        return word;
    }
}
