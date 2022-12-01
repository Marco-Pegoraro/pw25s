package br.edu.utfpr.pb.pw25s.server.service;

import br.edu.utfpr.pb.pw25s.server.model.User;

public interface UserService {

    User save(User user);

    User findOne(Long id);

    void delete(Long id);

    User findByUsername(String username);

}
