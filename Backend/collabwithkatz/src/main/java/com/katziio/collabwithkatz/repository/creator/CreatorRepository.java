package com.katziio.collabwithkatz.repository.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreatorRepository extends JpaRepository<Creator,Long> {
    @Query("SELECT new com.katziio.collabwithkatz.dto.creator.CreatorDTO(c) FROM Creator c ORDER BY c.id DESC LIMIT 1")
    CreatorDTO findLatestCreator();

    @Query("SELECT new com.katziio.collabwithkatz.dto.creator.CreatorDTO(c) FROM Editor c WHERE c.email =:userEmail AND c.password =:userPassword")
    CreatorDTO isValidLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

}
