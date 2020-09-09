package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class Sentence implements TextComponent {
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
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
        return sentence;
    }
}