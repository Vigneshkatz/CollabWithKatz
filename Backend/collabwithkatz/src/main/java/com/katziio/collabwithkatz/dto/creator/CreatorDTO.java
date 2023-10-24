package com.katziio.collabwithkatz.dto.creator;

import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.creator.Review;
import com.katziio.collabwithkatz.entity.creator.Upvote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatorDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Upvote> upvoteList;
    private List<Review> reviewList;
    private List<Project> projectList;

    public CreatorDTO(Creator creator)
    {
        this.id = creator.getId();;
        this.name = creator.getName();
        this.email= creator.getEmail();
        this.password = creator.getPassword();
        this.projectList = creator.getProjectList();
        this.upvoteList = creator.getUpvoteList();
        this.reviewList = creator.getReviewList();
    }
}
