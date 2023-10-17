package com.katziio.collabwithkatz.repository.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.editor.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {
    @Query("SELECT new com.katziio.collabwithkatz.dto.creator.CreatorDTO(c) FROM Creator c ORDER BY c.id DESC LIMIT 1")
    CreatorDTO findLatestCreator();

    @Query("SELECT new com.katziio.collabwithkatz.dto.creator.CreatorDTO(c) FROM Creator c WHERE c.email =:userEmail AND c.password =:userPassword")
    CreatorDTO isValidLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    @Query("SELECT new com.katziio.collabwithkatz.dto.creator.CreatorDTO(c) FROM Creator c WHERE c.email =:userEmail")
    CreatorDTO findByEmail(@Param("userEmail") String userEmail);

    @Query("SELECT c FROM Creator c WHERE c.email =:userEmail")
    Creator findByEmailVerify(@Param("userEmail") String userEmail);

    @Query("SELECT c FROM Creator c WHERE c.confirmationToken = :token")
    Creator findByConfirmationToken(@Param("token") String token);


}
