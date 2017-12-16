package com.huyaoban.mybatis3.mapper;

import java.util.List;

import com.huyaoban.mybatis3.model.Category;

public interface CategoryMapper {
	public int save(Category category);

	public int update(Category category);

	public List<Category> getAllCategories();

	public Category get(int id);
}
