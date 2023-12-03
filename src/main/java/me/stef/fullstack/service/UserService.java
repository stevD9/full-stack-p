package me.stef.fullstack.service;

import jakarta.transaction.Transactional;
import me.stef.fullstack.dao.ReservationRepository;
import me.stef.fullstack.dao.ShowRepository;
import me.stef.fullstack.dao.UserRepository;
import me.stef.fullstack.dto.RegisterUserDTO;
import me.stef.fullstack.dto.ScreeningDTO;
import me.stef.fullstack.dto.UserDTO;
import me.stef.fullstack.mapper.MyMapper;
import me.stef.fullstack.model.Show;
import me.stef.fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public UserDTO saveUser(RegisterUserDTO request) {
        User user = MyMapper.toUser(request);
        userRepository.save(user);

        return map(user);
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::map)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public UserDTO getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
//        reservationRepository.deleteForUser(id); TODO WITH CASCADE
    }

    @Transactional
    public void likeShow(Long userId, Long showId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        user.likeShow(show);
    }

    //////////
    private UserDTO map(User user) {
        UserDTO response = MyMapper.toUserDto(user);

        response.setLikedShows(user.getLikedShows().stream()
                .map(MyMapper::toShowDto)
                .toList());

        response.setReservations(user.getReservations().stream()
                .map(r -> {
                    ScreeningDTO screening = MyMapper.toScreeningDto(r.getScreening());
                    screening.setShow(MyMapper.toShowDto(r.getScreening().getShow()));

                    return screening;
                })
                .toList());

        return response;
    }
}
