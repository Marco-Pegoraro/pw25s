package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Movement;
import br.edu.utfpr.pb.pw25s.server.model.User;
import br.edu.utfpr.pb.pw25s.server.repository.MoveRepository;
import br.edu.utfpr.pb.pw25s.server.service.MoveService;
import br.edu.utfpr.pb.pw25s.server.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MoveServiceImpl implements MoveService {

    private final MoveRepository moveRepository;

    private final UserService userService;

    public MoveServiceImpl(MoveRepository moveRepository, UserService userService) {
        this.moveRepository = moveRepository;
        this.userService = userService;
    }

    @Override
    public Movement save(Movement movement) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(principal.toString());
        movement.setUser(user);
        return moveRepository.save(movement);
    }

    @Override
    public Movement findOne(Long id) {
        return moveRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movement> findAllByUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(principal.toString());
        Long userId = user.getId();
        return moveRepository.findAllByUserId(userId);
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
