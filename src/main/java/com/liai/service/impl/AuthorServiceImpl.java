package com.liai.service.impl;

import com.liai.dao.AuthorDao;
import com.liai.entity.Author;
import com.liai.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
private AuthorDao authorDao;

    @Override
    public int add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public int update(Author author) {
        return authorDao.update(author);
    }

    @Override
    public int delete(Long id) {
        return authorDao.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return authorDao.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return authorDao.findAuthorList();
    }
}
