package com.katziio.collabwithkatz.repository.creator;

import com.katziio.collabwithkatz.entity.creator.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT p FROM Project p WHERE p.creatorId = :creatorId")
    List<Project> findByCreatorId(@Param("creatorId") Long creatorId);

    @Query("SELECT p FROM Project p WHERE p.editorId = :editorId")
    List<Project> findByEditorId(@Param("editorId") Long editorId);
}
