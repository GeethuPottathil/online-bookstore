package com.onlineBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.onlineBookStore.Entity.BookCategory;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="BookCategory", path="book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
