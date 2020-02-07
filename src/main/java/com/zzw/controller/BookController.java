package com.zzw.controller;

import com.zzw.pojo.Books;
import com.zzw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    // controller 调用service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    // 跳转到新增书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    // 添加书籍
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println("添加的书籍信息为：" + books);
        int i = bookService.addBook(books);
        if (i > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
        return "redirect:/book/allBook"; // 请求重定向
    }

    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println("要更新的书籍信息为：" + books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    // 修改书籍信息
    @RequestMapping("/updateBook")
    public String updateBook(Books book) {
        System.out.println("更新完的书籍信息为：" + book);
        int i = bookService.updateBook(book);
        if (i > 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
        return "redirect:/book/allBook";
    }

    // 删除书籍，restful风格
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}