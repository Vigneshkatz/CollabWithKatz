package com.katziio.collabwithkatz.service.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.repository.creator.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    public CreatorDTO addCreator(Creator creator) {
        creatorRepository.save(creator);
        return new CreatorDTO(creator);
    }

    public CreatorDTO updateCreator(Creator creator,Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
            this.creatorRepository.save(creator);
            return new CreatorDTO(creator);
        }
        return null;
    }

    public CreatorDTO deleteCreator(Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
           this.creatorRepository.deleteById(id);
           return new CreatorDTO(optionalCreator.get());
        }
        return null;
    }

    public CreatorDTO getCreatorById(Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
            this.creatorRepository.deleteById(id);
            return new CreatorDTO(optionalCreator.get());
        }
        return null;
    }
}
