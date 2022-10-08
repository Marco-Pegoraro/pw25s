package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.dto.RegisterDto;
import br.edu.utfpr.pb.pw25s.server.dto.UserDto;
import br.edu.utfpr.pb.pw25s.server.model.Register;
import br.edu.utfpr.pb.pw25s.server.service.RegisterService;
import br.edu.utfpr.pb.pw25s.server.utils.GenericResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("registers")
public class RegisterController {

    private final RegisterService registerService;
    private ModelMapper modelMapper;

    public RegisterController(RegisterService registerService, ModelMapper modelMapper) {
        this.registerService = registerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createRegister(@RequestBody @Valid Register register) {
        registerService.save(register);
        return new GenericResponse("Registro inserido com sucesso");
    }

    @DeleteMapping("{id}")
    public GenericResponse delete(@PathVariable Long id) {
        registerService.delete(id);
        return new GenericResponse("Registro excluido com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Register>> findAll() {
        return ResponseEntity.ok(registerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Register> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(registerService.findOne(id));
    }

    @GetMapping("/userRegister/{id}")
    public ResponseEntity<List<RegisterDto>> findAllByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(
                registerService.findByUserId(id)
                        .stream()
                        .map(this::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    private RegisterDto convertEntityToDto(Register register) {
        return modelMapper.map(register, RegisterDto.class);
    }

}
