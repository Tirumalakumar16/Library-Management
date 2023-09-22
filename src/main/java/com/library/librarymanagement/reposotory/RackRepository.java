package com.library.librarymanagement.reposotory;

import com.library.librarymanagement.models.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<Rack,Long> {
}
