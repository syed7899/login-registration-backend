package com.example.demo.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface InstructorUserRepository
        extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Instructor a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableInstructor(String email);

}
