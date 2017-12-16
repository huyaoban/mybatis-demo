package com.huyaoban.mybatis3.service;

import java.util.List;

import com.huyaoban.mybatis3.model.Category;

public interface CategoryService {
	public Category save(Category category);

	public Category update(Category category);

	public List<Category> getAllCategories();

	public Category get(int id);
}
