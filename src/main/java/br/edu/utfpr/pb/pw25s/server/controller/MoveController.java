package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.model.Movement;
import br.edu.utfpr.pb.pw25s.server.service.MoveService;
import br.edu.utfpr.pb.pw25s.server.utils.GenericResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movement")
public class MoveController {

    private final MoveService moveService;
    private ModelMapper modelMapper;

    public MoveController(MoveService moveService, ModelMapper modelMapper) {
        this.moveService = moveService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createMovement(@PathVariable @Valid Movement movement) {
        moveService.save(movement);
        return new GenericResponse("Movimentação salva com sucesso");
    }

    @DeleteMapping("{id}")
    public GenericResponse delete(@PathVariable Long id) {
        moveService.delete(id);
        return new GenericResponse("Movimentação excluida com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Movement>> findAll() {
        return ResponseEntity.ok(moveService.findAll());
    }
}
