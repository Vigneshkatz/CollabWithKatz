package com.katziio.collabwithkatz.controller.file;

import com.katziio.collabwithkatz.service.firebase.FireBaseService;
import com.katziio.collabwithkatz.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FireBaseService fireBaseService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println(file.getName());
            return fireBaseService.uploadFile(file, Util.generateUniqueFileName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
