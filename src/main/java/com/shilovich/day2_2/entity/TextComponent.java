package com.shilovich.day2_2.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    ComponentType getType();

    List<TextComponent> receiveComponents();

    String getComponent();
}
