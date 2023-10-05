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
    private EditorService editorService;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/editor/login")
    public ResponseEntity<EditorDTO> editorLogin(@RequestBody JwtRequest request) {
        String inputEmail = request.getEmail();
        String inputPassword = request.getPassword();

        EditorDTO editor = editorService.getEditorByEmail(inputEmail);
        String dbPassword = editor.getPassword();

        if (passwordEncoder.matches(inputPassword, dbPassword)) {
            return new ResponseEntity<>(editor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/editor/add")
    public ResponseEntity<EditorDTO> saveEditor(@RequestBody Editor editor) {
        String password = passwordEncoder.encode(editor.getPassword());
        editor.setPassword(password);
        return new ResponseEntity<>(editorService.saveEditor(editor),HttpStatus.CREATED);
    }

    @PostMapping("/creator/add")
    public ResponseEntity<CreatorDTO> addCreator(@RequestBody Creator creator) {
        String password = passwordEncoder.encode(creator.getPassword());
        creator.setPassword(password);
        return new ResponseEntity<>(creatorService.addCreator(creator),HttpStatus.CREATED);
    }

    @PostMapping("/creator/login")
    public ResponseEntity<CreatorDTO> creatorLogin(@RequestBody JwtRequest request) {
        String inputEmail = request.getEmail();
        String inputPassword = request.getPassword();

        CreatorDTO creator = creatorService.getCreatorByEmail(inputEmail);
        String dbPassword = creator.getPassword();

        if (passwordEncoder.matches(inputPassword, dbPassword)) {
            return new ResponseEntity<>(creator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}