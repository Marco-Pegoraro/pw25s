package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AutenticationController {

    @GetMapping
    public GenericResponse checkAuthentication() {
        return new GenericResponse("Autenticação realizada com sucesso.");
    }

}
