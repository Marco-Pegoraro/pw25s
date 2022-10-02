package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.Register;

public interface RegisterService {

    Register save(Register register);

    Register findOne(Long id);

    void delete(Long id);

}
