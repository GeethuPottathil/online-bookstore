package com.onlineBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.onlineBookStore.Entity.BookCategory;

@RepositoryRestResource(collectionResourceRel="BookCategory", path="book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
