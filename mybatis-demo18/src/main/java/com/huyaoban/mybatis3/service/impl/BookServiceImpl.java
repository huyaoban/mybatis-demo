package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.mapper.BookMapper;
import com.huyaoban.mybatis3.mapper.CategoryMapper;
import com.huyaoban.mybatis3.model.Book;
import com.huyaoban.mybatis3.model.Category;
import com.huyaoban.mybatis3.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	private static final Logger logger = LoggerFactory
			.getLogger(BookServiceImpl.class);
	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	public List<Book> getAllBooks() {
		return bookMapper.getAllBooks();
	}

	public Book save(Book book) {
		bookMapper.save(book);
		return book;
	}

	public Book update(Book book) {
		int num = bookMapper.update(book);
		logger.info("updated rows = " + num);
		return book;
	}

	public Book get(long id) {
		return bookMapper.get(id);
	}

	public List<Category> getAllCategories() {
		return categoryMapper.getAllCategories();
	}

	public Category getCategory(int id) {
		return categoryMapper.get(id);
	}

}
