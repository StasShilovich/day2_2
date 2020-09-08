package com.shilovich.day2_2.dao.property.impl;

import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.property.PropertyManagerDao;

import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyManagerDaoImpl implements PropertyManagerDao {
    private static final String BUNDLE_NAME = "file";
    public static final String FILE_PATH = "file.path";

    @Override
    public String getProperty(String key) throws DaoException {
        try {
            ResourceBundle resourceBundle = PropertyResourceBundle.getBundle(BUNDLE_NAME);
            return resourceBundle.getString(key);
        } catch (MissingResourceException | IllegalArgumentException e) {
            throw new DaoException(e);
        }
    }
}
