package com.katziio.collabwithkatz.entity.creator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editor")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<Upvote> upvoteList;
    private List<Review> reviewList;
    private List<Project> projectList;
}
