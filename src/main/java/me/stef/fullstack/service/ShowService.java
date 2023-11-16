package me.stef.fullstack.service;

import me.stef.fullstack.dao.ShowRepository;
import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    @Autowired
    private ShowRepository repository;

    public List<ShowDTO> getShows() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private ShowDTO map(Show in) {
        return new ShowDTO(in.getId(), in.getName(), in.getDescription(), in.getDate());
    }
}
