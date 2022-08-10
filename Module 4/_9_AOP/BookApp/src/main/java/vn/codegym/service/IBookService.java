package vn.codegym.service;

import vn.codegym.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(Long id);

    void borrowBook(Book request) throws Exception;

    void payBook(Book request) throws Exception;
}
