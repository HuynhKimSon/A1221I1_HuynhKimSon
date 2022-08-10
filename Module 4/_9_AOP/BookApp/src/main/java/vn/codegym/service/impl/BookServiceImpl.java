package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Book;
import vn.codegym.repository.IBookRepository;
import vn.codegym.service.IBookService;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    @Override
    public void borrowBook(Book request) throws Exception {
        Book bookSelect = bookRepository.findById(request.getId()).orElse(new Book());

        int updateQuantity = bookSelect.getQuantity() - 1;

        if (updateQuantity < 0) {
            throw new Exception("Pls, this book is over !");
        }

        bookRepository.updateQuantity(request.getId(), updateQuantity);
    }

    @Override
    public void payBook(Book request) throws Exception {
        Book bookSelect = bookRepository.findById(request.getId()).orElse(new Book());

        int updateQuantity = bookSelect.getQuantity() + 1;

        if (updateQuantity > 10) {
            throw new Exception("Pls, the number of books in the library is enough !");
        }

        bookRepository.updateQuantity(request.getId(), updateQuantity);
    }
}
