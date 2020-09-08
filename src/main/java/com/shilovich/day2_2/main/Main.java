package com.shilovich.day2_2.main;

import com.shilovich.day2_2.dao.TextDao;
import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.factory.DaoFactory;

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
    }
}
