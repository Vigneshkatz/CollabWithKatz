package com.katziio.collabwithkatz.entity.creator;

import com.katziio.collabwithkatz.entity.common.Review;
import com.katziio.collabwithkatz.entity.common.Upvote;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean isVerified;
    @Column(name = "confirmation_token")
    private String confirmationToken;
//    @OneToMany(targetEntity = Upvote.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "creator_fk_id", referencedColumnName = "id")
//    private List<Upvote> upvoteList;

    @OneToMany(targetEntity = Review.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_fk_id", referencedColumnName = "id")
    private List<Review> reviewList;

}
