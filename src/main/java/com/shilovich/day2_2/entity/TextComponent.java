package com.shilovich.day2_2.entity;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    String getComponents();
}
