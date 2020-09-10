package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.ComponentType;
import com.shilovich.day2_2.entity.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String SPACE_BAR = " ";
    private List<TextComponent> components = new LinkedList<>();
    ComponentType type;


    public TextComposite(ComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public List<TextComponent> receiveComponents() {
        return components;
    }

    @Override
    public String getComponent() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : components) {
            builder.append(component.getComponent()).append(SPACE_BAR);
        }
        return builder.toString();
    }
}