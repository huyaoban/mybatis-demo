package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.mapper.CategoryMapper;
import com.huyaoban.mybatis3.model.Category;
import com.huyaoban.mybatis3.service.CategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	public Category save(Category category) {
		categoryMapper.save(category);
		return category;
	}

	public Category update(Category category) {
		categoryMapper.update(category);
		return category;
	}

	public List<Category> getAllCategories() {
		return categoryMapper.getAllCategories();
	}

	public Category get(int id) {
		return categoryMapper.get(id);
	}

}
