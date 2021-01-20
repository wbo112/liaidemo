package com.liai.controller;

import com.liai.entity.Author;
import com.liai.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/data/jdbc/author")
public class AuthorController {
   @Autowired
    AuthorService authorService;
    /**
     * 查询用户列表
     */
public Map<String,Object> getAuthotList(HttpRequest httpRequest) {
    List<Author> authorList = this.authorService.findAuthorList();
    Map<String,Object>  param = new HashMap<String,Object>();
    param.put("total",authorList.size());
    param.put("rows",authorList);

  return null;
}

/**
 * 查询用户信息
 */
@RequestMapping (value = "/{userId:\\d+}",method = RequestMethod.GET )
public  Author getAuthor(@PathVariable Long userId, HttpServlet request)
{
    Author author = this.authorService.findAuthor(userId);
    if(author == null){
        return null;
    }
    return author;
}
}
