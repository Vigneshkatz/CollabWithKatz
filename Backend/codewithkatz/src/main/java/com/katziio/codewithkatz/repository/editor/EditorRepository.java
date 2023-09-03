package com.katziio.codewithkatz.repository.editor;

import com.katziio.codewithkatz.dto.editordto.EditorDTO;
import com.katziio.codewithkatz.dto.editordto.EditorPreferenceDTO;
import com.katziio.codewithkatz.dto.editordto.EditorProjectDTO;
import com.katziio.codewithkatz.entity.editorentity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EditorRepository extends JpaRepository<Editor,Long> {
    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.name = :name")
    List<EditorDTO> findEditorByName(@Param("name") String name);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.age BETWEEN :minAge AND :maxAge")
    List<EditorDTO> filterByAge(@Param("minAge") int minAge,@Param("maxAge") int maxAge);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.country = :countryName")
    List<EditorDTO> filterByCountry(@Param("countryName") String countryName);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e ORDER BY e.experienceInYears DESC")
    List<EditorDTO> sortEditorsByExperience();

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorProjectDTO (e.editorProjects) FROM Editor e WHERE e.id = :editorId")
    List<EditorProjectDTO> findProjectByEditorId(@Param("editorId") Long editorId);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorPreferenceDTO (e.editorPreferences) FROM Editor e WHERE e.id = :editorId")
    List<EditorPreferenceDTO> findPreferenceByEditorId(Long editorId);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.gender = :gender")
    List<EditorDTO> filterByGender(@Param("gender") String gender);

    @Query("SELECT COUNT(*) FROM Editor")
    Long countTotalNoOfEditor();

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.email=:email")
    EditorDTO getEditorByEmail(@Param("email") String email);

    @Query("SELECT new com.katziio.codewithkatz.dto.editordto.EditorDTO(e) FROM Editor e WHERE e.experienceInYears BETWEEN :minExperience AND :maxExperience")
    List<EditorDTO> filterByExperience(@Param("minExperience") int minExperience, @Param("maxExperience") int maxExperience);
}
