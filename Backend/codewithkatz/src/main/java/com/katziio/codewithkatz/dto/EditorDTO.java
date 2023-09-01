package com.katziio.codewithkatz.dto;

import com.katziio.codewithkatz.entity.Editor;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorDTO {
    private Long Id;
    private String email;
    private String password;
    private String name;
    private String website;

    public EditorDTO(Editor editor) {
        this.Id = editor.getId();
        this.name = editor.getName();
        this.email = editor.getEmail();
        this.website = editor.getWebsite();
        this.password = editor.getPassword();
    }
}
