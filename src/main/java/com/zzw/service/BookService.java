package com.zzw.service;

import com.zzw.pojo.Books;

import java.util.List;

// BookService的功能：调用dao层
public interface BookService {

    //增加一本书
    int addBook(Books book);

    //根据id删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //根据id查询,返回一本书的信息
    Books queryBookById(int id);

    //查询全部Book,返回一个list集合
    List<Books> queryAllBook();
}
