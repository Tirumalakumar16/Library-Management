package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksBoughtRepository extends JpaRepository<BooksBought,Long> {

    @Query(value = "select * from library_management.books_bought a where a.user_id=?1",nativeQuery = true)
    List<BooksBought> findByuserId(Long id);


}
