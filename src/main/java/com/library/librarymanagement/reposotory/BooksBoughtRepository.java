package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.BooksBought;
import com.library.librarymanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksBoughtRepository extends JpaRepository<BooksBought,Long> {
}
