package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class CodeBlock implements TextComponent {
    private List<TextComponent> codeBlocks = new LinkedList<>();

    @Override
    public void add(TextComponent component) {
        codeBlocks.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        codeBlocks.remove(component);
    }

    @Override
    public String getComponents() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent codeBlock : codeBlocks) {
            builder.append(codeBlock);
        }
        return builder.toString();
    }
}