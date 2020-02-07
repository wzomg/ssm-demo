package com.zzw.service.impl;

import com.zzw.dao.BookMapper;
import com.zzw.pojo.Books;
import com.zzw.service.BookService;

import java.util.List;

// spring-service配置文件中的配置代替了业务类的注解
// @Service
public class BookServiceImpl implements BookService {

    // 组合Dao接口
    // @Autowired
    private BookMapper bookMapper;

    //service调用dao层的操作，设置一个set接口，方便Spring管理（注入）
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
