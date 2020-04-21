package com.onlineBookStore.Config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.onlineBookStore.Entity.Book;
import com.onlineBookStore.Entity.BookCategory;

// to expose entity id in rest
@Configuration
public class RepositoryConfig implements  RepositoryRestConfigurer {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		//		config.exposeIdsFor(Book.class);
		//		config.exposeIdsFor(BookCategory.class);
		
		//This code will help in exposing id's for all entities. No need to use the above two codes.
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type::getJavaType)
				.toArray(Class[]::new));
	}
}
