package com.shilovich.day2_2.dao.property;

import com.shilovich.day2_2.dao.exception.DaoException;

public interface PropertyManagerDao {
    String getProperty(String key) throws DaoException;
}
