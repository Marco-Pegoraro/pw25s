package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Movement;
import br.edu.utfpr.pb.pw25s.server.repository.MoveRepository;
import br.edu.utfpr.pb.pw25s.server.service.MoveService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Movement> findAll() {
        return moveRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        moveRepository.deleteById(id);
    }
}
