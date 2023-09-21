package com.katziio.collabwithkatz.repository.editor;

import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.editor.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    @Query("SELECT new com.katziio.collabwithkatz.dto.editor.EditorDTO(e) FROM Editor e ORDER BY e.name ASC")
    List<EditorDTO> sortEditorBy(@Param("sortBy") String sortBy);
}
