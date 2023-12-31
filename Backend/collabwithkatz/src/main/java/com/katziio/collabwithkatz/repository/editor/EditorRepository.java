package com.katziio.collabwithkatz.repository.editor;

import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.editor.Editor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorRepository extends JpaRepository<Editor,Long> {
    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.name = :name")
    List<EditorDTO> findEditorByName(@Param("name") String name);

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.age BETWEEN :minAge AND :maxAge")
    List<EditorDTO> filterByAge(@Param("minAge") int minAge,@Param("maxAge") int maxAge);

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.country = :countryName")
    List<EditorDTO> filterByCountry(@Param("countryName") String countryName);

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e ORDER BY e.experienceInYears DESC")
    List<EditorDTO> sortEditorsByExperience();

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.gender = :gender")
    List<EditorDTO> filterByGender(@Param("gender") String gender);

    @Query("SELECT COUNT(*) FROM Editor")
    Long countTotalNoOfEditor();

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.email=:email")
    EditorDTO getEditorByEmail(@Param("email") String email);

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.experienceInYears BETWEEN :minExperience AND :maxExperience")
    List<EditorDTO> filterByExperience(@Param("minExperience") int minExperience, @Param("maxExperience") int maxExperience);

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e WHERE e.email =:userEmail AND e.password =:userPassword")
    EditorDTO isValidLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

//    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e ORDER BY e.name ASC")
//    List<EditorDTO> sortEditorBy(@Param("sortBy") String sortBy);
    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e " +
            "ORDER BY " +
            "CASE WHEN :sortBy = 'name' THEN e.name END ASC, " +
            "CASE WHEN :sortBy = 'experience' THEN e.experienceInYears END DESC, " +
            "CASE WHEN :sortBy = 'createdAt' THEN e.profileCreatedAt END ASC")
    List<EditorDTO> sortEditorBy(@Param("sortBy") String sortBy);

    @Query("SELECT e FROM Editor e WHERE e.email = :email")
    Editor findByEmail(@Param("email") String email);

    @Query("SELECT e FROM Editor e WHERE e.confirmationToken = :token")
    Editor findByConfirmationToken(@Param("token") String token);

    @Query("SELECT e FROM Editor e")
    List<Editor> findAllByPagination(Pageable pageable);

}
