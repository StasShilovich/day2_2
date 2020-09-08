package com.shilovich.day2_2.dao.reader;

import com.shilovich.day2_2.dao.exception.DaoException;

public interface FileReaderDao {
    String read() throws DaoException;
}
