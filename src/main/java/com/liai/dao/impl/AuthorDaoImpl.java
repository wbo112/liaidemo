package com.liai.dao.impl;

import com.liai.dao.AuthorDao;
import com.liai.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AuthorDaoImpl implements AuthorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(Author author) {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)",
                author.getRealName(), author.getNickName());
    }

    @Override
    public int update(Author author) {
        return jdbcTemplate.update("update t_author set id=?",
                author.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete t_author where id=?", id);
    }

    @Override
    public Author findAuthor(Long id) {
        // Author a = new Author();
        Object[] b = {id};

        List<Author> query = jdbcTemplate.query("select id, real_name, nick_name from t_author where id=?", b, new BeanPropertyRowMapper(Author.class));
        if (query != null && query.size() > 0) {
            Author author = query.get(0);
            return author;
        } else {
            return null;
        }

    }

    @Override
    public List<Author> findAuthorList() {

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_author");
        List<Author> authorlist = new ArrayList<>();
        Iterator<Map<String, Object>> entrys = list.iterator();
        while (entrys.hasNext()) {
            Map<String, Object> next = entrys.next();
            Long id = (Long) next.get("id");
            String realName = next.get("real_name").toString();
            String nickName = next.get("nick_name").toString();
            Author a = new Author();
            a.setId(id);
            a.setRealName(realName);
            a.setNickName(nickName);
            authorlist.add(a);
        }
        return authorlist;
    }
}
