package me.stef.fullstack.service;

import me.stef.fullstack.dao.UserRepository;
import me.stef.fullstack.dto.RegisterUserDTO;
import me.stef.fullstack.dto.UserDTO;
import me.stef.fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> getUsers() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public UserDTO saveUser(RegisterUserDTO request) {
        User user = map(request);
        repository.save(user);

        return map(user);
    }

    private UserDTO map(User in) {
        return new UserDTO(in.getId(), in.getFirstName(), in.getLastName(), in.getEmail());
    }

    private User map(RegisterUserDTO in) {
        return new User(in.getFirstName(), in.getLastName(), in.getEmail());
    }
}
