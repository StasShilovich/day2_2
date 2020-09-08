package com.shilovich.day2_2.dao.impl;

import com.shilovich.day2_2.dao.TextDao;
import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.factory.DaoFactory;
import com.shilovich.day2_2.dao.reader.FileReaderDao;

public class TextDaoImpl implements TextDao {
    @Override
    public String readFromFile() throws DaoException {
        DaoFactory factory = DaoFactory.getInstance();
        FileReaderDao reader = factory.getReader();
        String text = reader.read();
        return text;
    }
}