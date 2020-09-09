package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class CodeBlock implements TextComponent {
    private String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
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
        return codeBlock;
    }
}