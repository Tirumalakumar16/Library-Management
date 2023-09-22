package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from library_management.user a where a.email_id=?1",nativeQuery = true)
    User findByEmailId(String email);

    @Modifying
    @Transactional
    @Query(value = "update library_management.user a set a.no_of_books_taken=?1 where a.email_id=?2",nativeQuery = true)
    void updateUserByNoOfBooksTaken(int books,String email);

    @Query(value = "select * from library_management.user a where a.username=?1",nativeQuery = true)
    Optional<User> findByUsername(String username);
}
