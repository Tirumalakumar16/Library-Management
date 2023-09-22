package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Library;
import com.library.librarymanagement.models.Rack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {

}
