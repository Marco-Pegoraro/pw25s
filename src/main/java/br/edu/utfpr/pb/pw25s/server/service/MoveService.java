package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.Movement;

import java.util.List;

public interface MoveService {

    Movement save(Movement movement);

    Movement findOne(Long id);

    List<Movement> findAllByRegisterId(Long accId);

    List<Movement> findAll();

    void delete(Long id);

}
