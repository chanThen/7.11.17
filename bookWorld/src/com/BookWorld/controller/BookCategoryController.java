package com.BookWorld.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.BookWorld.model.BookCategory;
import com.BookWorld.service.BookCategoryService;
import com.BookWorld.service.BookCategoryServiceImpl;


@Path("/categories")
public class BookCategoryController {
		
		BookCategoryService categoryService = new BookCategoryServiceImpl();
		@Path("/getAllCategories")
		@GET
		@Produces("application/json")
		
		public List<BookCategory> getAllCategories() {
			return categoryService.getAllCategories();
		}
}
