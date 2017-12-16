package com.huyaoban.mybatis3.mapper;

import java.util.List;

import com.huyaoban.mybatis3.model.Book;

public interface BookMapper {
	public List<Book> getAllBooks();

	public int save(Book book);

	public int update(Book book);

	public Book get(long id);
}
