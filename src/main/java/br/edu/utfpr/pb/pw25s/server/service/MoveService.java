package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.Movement;

import java.util.List;

public interface MoveService {

    Movement save(Movement movement);

    List<Movement> findAll();

    void delete(Long id);

}
