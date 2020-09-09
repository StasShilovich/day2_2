package com.shilovich.day2_2.main;

import com.shilovich.day2_2.dao.TextDao;
import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.factory.DaoFactory;
import com.shilovich.day2_2.entity.TextComponent;
import com.shilovich.day2_2.entity.impl.TextCompositeImpl;
import com.shilovich.day2_2.service.factory.ServiceFactory;

public class Main {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        TextDao dao = factory.getDao();
        String text = null;
        try {
            text = dao.readFromFile();
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(text);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        TextComponent parse = serviceFactory.getTextParser().parse( text);
        System.out.println(parse.getComponent());
    }
}
