package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.Book;
import com.library.librarymanagement.models.Rack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Modifying
    @Transactional
    @Query(value = "update book a  set a.rack_id=?1 where a.book_name=?2",nativeQuery = true)
    void updateRackId( int rackId,String bookName);
    @Query(value = "select * from library_management.book a where a.book_name=?1",nativeQuery = true)
    Book findByBookName(String bookName);
    @Query(value = "select * from rack r where r.rack_number=?1",nativeQuery = true)
    Rack findByRackNumber(int rackId);
    @Modifying
    @Transactional
    @Query(value = "update library_management.book a set a.available_books=?1 where a.book_name=?2",nativeQuery = true)
    void updateBookByAvailableBooks(int books,String bookName);
    @Query(value = "select * from library_management.book a where a.rack_id=?1",nativeQuery = true)
    List<Book> findByRackId(Long id);
}
