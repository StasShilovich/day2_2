package com.shilovich.day2_2.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    void addList(List<TextComponent> components);
    String getComponent();
}
