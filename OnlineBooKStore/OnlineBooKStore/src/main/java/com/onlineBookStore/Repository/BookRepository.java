package com.onlineBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineBookStore.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
