package com.amol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amol.Entity.Category;
import com.amol.Entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{
	
	////=====FIND-ALL-LANGUAGES-BASED-ON-CATEGORY-ID
	@Query("SELECT l FROM Language l WHERE l.category.cate_id=?1")
	List<Language> findAllByCategoryId(Integer cate_id);
	
	////=====FIND-CATEGORY-BASED-ON-LANGUAGE-ID
	@Query("SELECT l.category FROM Language l WHERE l.lang_id=?1")
	Category findCategoryByLanguageId(Integer lang_id);

}
