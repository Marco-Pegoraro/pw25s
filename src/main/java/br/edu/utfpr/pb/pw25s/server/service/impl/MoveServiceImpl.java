package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Movement;
import br.edu.utfpr.pb.pw25s.server.repository.MoveRepository;
import br.edu.utfpr.pb.pw25s.server.service.MoveService;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {

    private final MoveRepository moveRepository;

    public MoveServiceImpl(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    @Override
    public Movement save(Movement movement) {
        return moveRepository.save(movement);
    }

    @Override
    public Movement findOne(Long id) {
        return moveRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        moveRepository.deleteById(id);
    }
}