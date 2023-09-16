package com.katziio.collabwithkatz.controller.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.service.creator.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/creators")
@CrossOrigin("*")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;

    //   create creator
    @PostMapping("/add")
    public CreatorDTO addCreator(@RequestBody Creator creator) {
        return this.creatorService.addCreator(creator);
    }

    //    update creartor
    @PutMapping("/update/{id}")
    public CreatorDTO updateCreator(@RequestBody Creator creator,@PathVariable Long id) {
        return this.creatorService.updateCreator(creator,id);
    }

    //    delete creator
    @DeleteMapping("/delete/{id}")
    public CreatorDTO deleteCreator(@PathVariable Long id) {
        return this.creatorService.deleteCreator(id);
    }

    //    getCreator by id
    @GetMapping("getCreator/{id}")
    public CreatorDTO getCreatorById(@PathVariable Long id) {
        return this.creatorService.getCreatorById(id);
    }

}
