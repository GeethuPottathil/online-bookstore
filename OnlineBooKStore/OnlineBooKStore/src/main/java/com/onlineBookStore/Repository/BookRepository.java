package com.onlineBookStore.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.onlineBookStore.Entity.Book;

import lombok.experimental.PackagePrivate;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {
	
	//Earlier url was /search/findByCategiryId?id=1 --> Now changed to /search/categoryid?id=1
	@RestResource(path="categoryid")
	Page<Book> findByCategoryId(@Param("id") Long id, Pageable pageable);
}
