package com.onlineBookStore.Config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.onlineBookStore.Entity.Book;
import com.onlineBookStore.Entity.BookCategory;

// to expose entity id in rest
@Configuration
public class RepositoryConfig implements  RepositoryRestConfigurer {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		// 		The id won't be displayed in webpage by default. so we use the following methods to expose ID's
		//		config.exposeIdsFor(Book.class);
		//		config.exposeIdsFor(BookCategory.class);
		
		//This code will help in exposing id's for all entities. No need to use the above two codes.
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type::getJavaType)
				.toArray(Class[]::new));
		
		//		By default application won't allow to connect from other hosts. localhost:4200 can't display information of 
		// 		Loalhost 8080. To resolve this issue we have to annottate as "@CrossOrigin("http://localhost:4200")" in repository 
		//		class. Instead of that we can use this configuration.
		config.getCorsRegistry()
			.addMapping("/**")
			.allowedOrigins("http://localhost:4200");
	}
}
