package com.katziio.collabwithkatz.dto.creator;

import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.common.Project;
import com.katziio.collabwithkatz.entity.common.Review;
import com.katziio.collabwithkatz.entity.common.Upvote;
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
    }
}
