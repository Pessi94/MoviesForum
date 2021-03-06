package com.pessi.moviesforum.Repository;

import com.pessi.moviesforum.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {

    @Override
    List<Section> findAll();

    Section findById(int id);

}
