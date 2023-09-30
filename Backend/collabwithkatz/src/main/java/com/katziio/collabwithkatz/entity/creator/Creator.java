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
@Table(name = "creators")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(targetEntity = Upvote.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_fk_id", referencedColumnName = "id")
    private List<Upvote> upvoteList;

    @OneToMany(targetEntity = Review.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_fk_id", referencedColumnName = "id")
    private List<Review> reviewList;

}