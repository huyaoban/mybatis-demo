package com.huyaoban.mybatis3.service;

import java.util.List;

import com.huyaoban.mybatis3.model.Book;
import com.huyaoban.mybatis3.model.Category;

public interface BookService {
	public List<Book> getAllBooks();

	public Book save(Book book);

	public Book update(Book book);

	public Book get(long id);

	public List<Category> getAllCategories();

	public Category getCategory(int id);
}
