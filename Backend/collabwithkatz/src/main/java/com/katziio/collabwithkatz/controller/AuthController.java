package com.katziio.collabwithkatz.controller;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.dto.jwt.JwtRequest;
import com.katziio.collabwithkatz.dto.jwt.JwtResponse;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.service.creator.CreatorService;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private EditorService editorService;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private PasswordEncoder passwordEncoder;


// editor section

    @PostMapping("/editor/login")
    public ResponseEntity<JwtResponse> editorLogin(@RequestBody JwtRequest request) {
        System.out.println(request.getEmail() + " " + request.getPassword());
        String inputPassword = request.getPassword();
        String dbPassword = this.editorService.getEditorById(4L).getPassword();
        System.out.println(inputPassword + " "+ dbPassword);
        if (passwordEncoder.matches(inputPassword, dbPassword)) {
            System.out.println("Password matched");
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            // Passwords do not match
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @PostMapping("/editor/addEditor")
    public EditorDTO saveEditor(@RequestBody Editor editor) {
        String password = this.passwordEncoder.encode(editor.getPassword());
        editor.setPassword(password);
        EditorDTO addedEditor = this.editorService.saveEditor(editor);

        return addedEditor;
    }

    //    creator section

    @PostMapping("/creator/add")
    public CreatorDTO addCreator(@RequestBody Creator creator) {
        String password = this.passwordEncoder.encode(creator.getPassword());
        creator.setPassword(password);
        return this.creatorService.addCreator(creator);
    }

    @PostMapping("/creator/login")
    public ResponseEntity<JwtResponse> creatorLogin(@RequestBody JwtRequest request) {
        System.out.println(request.getEmail() + " " + request.getPassword());

        return new ResponseEntity<>(null, HttpStatus.OK);
    }



    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}