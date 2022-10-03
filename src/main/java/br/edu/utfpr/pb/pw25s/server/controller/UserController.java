package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.dto.UserDto;
import br.edu.utfpr.pb.pw25s.server.model.User;
import br.edu.utfpr.pb.pw25s.server.service.UserService;
import br.edu.utfpr.pb.pw25s.server.utils.GenericResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@RequestBody @Valid User user) {
        userService.save(user);
        return new GenericResponse("Usuário inserido com sucesso");
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok( convertEntityToDto(userService.findOne(id)) );
    }

    @DeleteMapping("{id}")
    public GenericResponse delete(@PathVariable Long id) {
        userService.delete(id);
        return new GenericResponse("Usuário deletado com sucesso");
    }

    @PutMapping
    public GenericResponse update(@RequestBody @Valid User user) {
        userService.save(user);
        return new GenericResponse("Usuário atualizado com sucesso");
    }

    private UserDto convertEntityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
