package com.shilovich.day2_2.dao;

import com.shilovich.day2_2.dao.exception.DaoException;

public interface TextDao {
    String readFromFile() throws DaoException;
}
