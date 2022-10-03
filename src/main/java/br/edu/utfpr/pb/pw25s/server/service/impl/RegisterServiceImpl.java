package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Register;
import br.edu.utfpr.pb.pw25s.server.repository.RegisterRepository;
import br.edu.utfpr.pb.pw25s.server.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public Register save(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public Register findOne(Long id) {
        return registerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        registerRepository.deleteById(id);
    }
}