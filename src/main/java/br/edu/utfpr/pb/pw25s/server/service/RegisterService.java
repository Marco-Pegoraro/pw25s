package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.Register;

import java.util.List;

public interface RegisterService {

    Register save(Register register);

    Register findOne(Long id);

    List<Register> findAll();

    List<Register> findByUserId();

    void delete(Long id);

}
