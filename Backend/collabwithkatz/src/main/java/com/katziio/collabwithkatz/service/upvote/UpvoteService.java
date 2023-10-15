package com.katziio.collabwithkatz.service.upvote;

import com.katziio.collabwithkatz.entity.common.Upvote;
import com.katziio.collabwithkatz.repository.upvote.UpvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpvoteService {
    @Autowired
    private UpvoteRepository upvoteRepository;

    public Boolean changeUpvoteStatus(Long editorId, Long creatorId)
    {
        Upvote upvote = this.upvoteRepository.findByCreatorIdEditorId(editorId,creatorId);
        Boolean upvoteValue = true;
        if(upvote !=null)
        {
            upvoteValue =upvote.getIsVoted();
            upvote.setIsVoted(!upvote.getIsVoted());
        }else {
            upvote = new Upvote();
            upvote.setCreatorId(creatorId);
            upvote.setEditorId(editorId);
            upvote.setIsVoted(true);
        }
        this.upvoteRepository.save(upvote);
        return upvoteValue;
    }

    public Long getEditorUpvoteCount(Long editorId)
    {
        return this.upvoteRepository.countUpvoteByEditorId(editorId);
    }

}
