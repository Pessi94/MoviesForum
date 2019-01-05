package com.pessi.moviesforum.Repository;

import com.pessi.moviesforum.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

    Thread findById(int id);

    @Transactional
    void deleteById(int id);

}
