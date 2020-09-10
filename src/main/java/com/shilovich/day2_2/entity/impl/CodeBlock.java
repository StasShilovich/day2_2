package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;

import java.util.List;

public class CodeBlock implements TextComponent {
    private String codeBlock;
    private ComponentType type;

    public CodeBlock(String codeBlock, ComponentType type) {
        this.codeBlock = codeBlock;
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
        return codeBlock;
    }
}
