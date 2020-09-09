package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class TextCompositeImpl implements TextComponent {
    private List<TextComponent> components = new LinkedList<>();

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public void addList(List<TextComponent> components) {
        this.components.addAll(components);
    }

    @Override
    public String getComponent() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : components) {
            builder.append(component.getClass().getSimpleName())
                    .append("   ")
                    .append(component.getComponent())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}