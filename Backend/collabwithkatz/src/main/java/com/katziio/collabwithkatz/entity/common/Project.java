package com.katziio.collabwithkatz.entity.common;

import com.katziio.collabwithkatz.entity.creator.Creator;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToOne(optional = true)
    @JoinColumn(name = "editor_id")
    private Editor editor;

    private String projectName;
    private String projectDescription;
    private String rawVideoURl;
}
