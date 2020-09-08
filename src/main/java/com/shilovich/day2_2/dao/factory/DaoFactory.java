package com.shilovich.day2_2.dao.factory;

import com.shilovich.day2_2.dao.TextDao;
import com.shilovich.day2_2.dao.impl.TextDaoImpl;
import com.shilovich.day2_2.dao.property.PropertyManagerDao;
import com.shilovich.day2_2.dao.property.impl.PropertyManagerDaoImpl;
import com.shilovich.day2_2.dao.reader.FileReaderDao;
import com.shilovich.day2_2.dao.reader.impl.FileReaderDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final PropertyManagerDao manager = new PropertyManagerDaoImpl();
    private final FileReaderDao reader = new FileReaderDaoImpl();
    private final TextDao dao = new TextDaoImpl();

    private DaoFactory() {
    }

    public PropertyManagerDao getManager() {
        return manager;
    }

    public FileReaderDao getReader() {
        return reader;
    }

    public TextDao getDao() {
        return dao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}