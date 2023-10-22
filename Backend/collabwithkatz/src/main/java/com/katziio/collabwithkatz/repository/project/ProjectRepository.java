package com.katziio.collabwithkatz.repository.project;

import com.katziio.collabwithkatz.entity.common.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT p FROM Project p WHERE p.creator.id = :creatorId")
    List<Project> findByCreatorId(@Param("creatorId") Long creatorId, Pageable pageable);

    @Query("SELECT p FROM Project p WHERE p.editor.id = :editorId")
    List<Project> findByEditorId(@Param("editorId") Long editorId);

    @Query("SELECT p FROM Project p WHERE p.editor.id = null")
    List<Project> findProjectsWithNoEditor(Pageable pageable);
}
