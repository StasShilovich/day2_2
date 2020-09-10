package com.shilovich.day2_2.main;


import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.service.TextService;
import com.shilovich.day2_2.service.exception.ServiceException;
import com.shilovich.day2_2.service.factory.ServiceFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceFactory factory = ServiceFactory.getInstance();
        TextService textService = factory.getTextService();
        // 2
        try {
            List<String> strings = textService.displaySentenceOrderByNumberWords();
            for (String string : strings) {
                System.out.println(string);
            }
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||");
        // 5
        try {
            TextComponent component = textService.swapWords();
            System.out.println(component.getComponent());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||");
        // 16
        try {
            TextComponent component = textService.replaceWord(0, 5, "Claaaaass");
            System.out.println(component.getComponent());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}