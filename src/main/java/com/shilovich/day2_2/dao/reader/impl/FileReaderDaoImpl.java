package com.shilovich.day2_2.dao.reader.impl;

import com.shilovich.day2_2.dao.exception.DaoException;
import com.shilovich.day2_2.dao.factory.DaoFactory;
import com.shilovich.day2_2.dao.property.PropertyManagerDao;
import com.shilovich.day2_2.dao.reader.FileReaderDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.shilovich.day2_2.dao.property.impl.PropertyManagerDaoImpl.FILE_PATH;

public class FileReaderDaoImpl implements FileReaderDao {
    @Override
    public String read() throws DaoException {
        DaoFactory factory = DaoFactory.getInstance();
        PropertyManagerDao manager = factory.getManager();
        String filePath = manager.getProperty(FILE_PATH);
        Stream<String> lines = null;
        StringBuilder builder = new StringBuilder();
        try {
            Path path = Paths.get(filePath);
            lines = Files.lines(path);
            if (lines != null) {
                lines.forEach(str -> builder.append(str).append(System.lineSeparator()));
            }
        } catch (IOException e) {
            throw new DaoException("File read fail", e);
        } finally {
            try {
                if (lines != null) {
                    lines.close();
                }
            } catch (Exception e) {
                throw new DaoException("Failed to close stream", e);
            }
        }
        return builder.toString();
    }
}