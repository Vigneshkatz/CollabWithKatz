package com.katziio.collabwithkatz.controller.editor;
import com.katziio.collabwithkatz.config.jwt.JwtHelper;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.dto.jwt.*;


import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.service.CustomUserService;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private EditorService editorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserService customUserService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);



    @PostMapping("/editor/login")
    public ResponseEntity<JwtResponse> editorLogin(@RequestBody JwtRequest request) {
        System.out.println(request.getEmail()+" "+request.getPassword());

        this.doAuthenticate(request.getEmail(), request.getPassword());
        System.out.println("sdvbskbvsliv");

        UserDetails userDetails =customUserService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        System.out.println("sdvbskbvsliv");
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/creator/login")
    public ResponseEntity<JwtResponse> creatorLogin(@RequestBody JwtRequest request) {
        System.out.println(request.getEmail()+" "+request.getPassword());

        this.doAuthenticate(request.getEmail(), request.getPassword());
        System.out.println("sdvbskbvsliv");

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        System.out.println("sdvbskbvsliv");
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addEditor")
    public EditorDTO saveEditor(@RequestBody Editor editor) {
        String password = this.passwordEncoder.encode(editor.getPassword());
        editor.setPassword(password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(editor.getName());
        String token = this.helper.generateToken(userDetails);
        System.out.println("sdvbskbvsliv");
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return this.editorService.saveEditor(editor);
    }



    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}