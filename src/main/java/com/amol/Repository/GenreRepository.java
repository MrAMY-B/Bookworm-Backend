package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Category;
import com.amol.Entity.Genre;
import com.amol.Entity.Language;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

	
	@Query("SELECT g FROM Genre g WHERE g.language.lang_id=?1")
	List<Genre> getAllByLanguageId(Integer lang_id);
	
	@Query("SELECT g FROM Genre g WHERE g.language.category.cate_id=?1")
	List<Genre> getAllByCategryId(Integer cate_id);
	
	/////=====> SELECT LANGUAGE BASED ON GENRE ID
	@Query("SELECT g.language FROM Genre g WHERE g.gen_id=?1")
	Language findLanguageByGenreId(Integer gen_id);
	
	/////=====> SELECT CATEGORY BASED ON GENRE ID
	@Query("SELECT g.language.category FROM Genre g WHERE g.gen_id=?1")
	Category findCategoryByGenreId(Integer gen_id);
	
}
