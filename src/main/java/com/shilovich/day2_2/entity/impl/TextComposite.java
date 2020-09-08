package com.shilovich.day2_2.entity.impl;

import com.shilovich.day2_2.entity.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
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
    public String getComponents() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : components) {
            builder.append(component.getComponents());
        }
        return builder.toString();
    }
}