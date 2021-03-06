package com.sergeev.day6.service.impl;

import com.sergeev.day6.model.dao.impl.LibraryDAOImpl;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.DAOException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.service.LibraryService;
import com.sergeev.day6.util.parser.NumberParser;
import com.sergeev.day6.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Book> addBook(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            try {
                result = bookListDAO.addBook(book);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public List<Book> removeBook(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            try {
                result = bookListDAO.removeBook(book);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateTitleOfBook(title)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByTitle(title);
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateAuthorOfBook(author)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByAuthor(author);
        }
        return books;
    }

    @Override
    public List<Book> findByCost(String minCostLine, String maxCostLine) throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        double minCost = numberParser.parseToDouble(minCostLine);
        double maxCost = numberParser.parseToDouble(maxCostLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateCostOfBook(minCost) && bookValidator.validateCostOfBook(maxCost)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByCost(minCost, maxCost);
        }
        return books;
    }

    @Override
    public List<Book> findByNumberOfPages(String minNumberOfPagesLine, String maxNumberOfPagesLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minNumberOfPages = numberParser.parseToInt(minNumberOfPagesLine);
        int maxNumberOfPages = numberParser.parseToInt(maxNumberOfPagesLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateNumberOfPagesInBook(minNumberOfPages) &&
                bookValidator.validateNumberOfPagesInBook(maxNumberOfPages)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByNumberOfPages(minNumberOfPages, maxNumberOfPages);
        }
        return books;
    }

    @Override
    public List<Book> findByYearOfPublishing(String minYearOfPublishingLine, String maxYearOfPublishingLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minYearOfPublishing = numberParser.parseToInt(minYearOfPublishingLine);
        int maxYearOfPublishing = numberParser.parseToInt(maxYearOfPublishingLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateYearOfPublishing(minYearOfPublishing) &&
                bookValidator.validateYearOfPublishing(maxYearOfPublishing)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByYearOfPublishing(minYearOfPublishing, maxYearOfPublishing);
        }
        return books;
    }

    @Override
    public List<Book> sortBooksByTitle() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByTitle();
    }

    @Override
    public List<Book> sortBooksByAuthors() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByAuthors();
    }

    @Override
    public List<Book> sortBooksByCost() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByCost();
    }

    @Override
    public List<Book> sortBooksByNumberOfPages() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByNumberOfPages();
    }

    @Override
    public List<Book> sortBooksByYearOfPublishing() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByYearOfPublishing();
    }

}
