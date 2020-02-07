package com.zzw.dao;

import com.zzw.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books book);

    //根据id删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //根据id查询,返回一本书的信息
    Books queryBookById(@Param("bookID") int id);

    //查询全部Book,返回一个list集合
    List<Books> queryAllBook();
}
