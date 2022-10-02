package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.Movement;

public interface MoveService {

    Movement save(Movement movement);

    Movement findOne(Long id);

    void delete(Long id);

}
