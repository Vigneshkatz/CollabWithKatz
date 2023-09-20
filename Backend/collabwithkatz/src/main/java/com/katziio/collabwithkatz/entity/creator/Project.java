package com.katziio.collabwithkatz.entity.creator;

import com.katziio.collabwithkatz.entity.editor.Editor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.Long;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long creatorId;
    private Long editorId;

    private String projectName;
    private String projectDescription;
    private String rawVideoURl;
}
