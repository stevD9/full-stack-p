package me.stef.fullstack.service;

import me.stef.fullstack.dao.ShowRepository;
import me.stef.fullstack.dto.RegisterShowDTO;
import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.mapper.MyMapper;
import me.stef.fullstack.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository repository;

    public List<ShowDTO> getShows() {
        List<Show> shows = repository.findAll();

        List<ShowDTO> showDTOS = new ArrayList<>();
        for (Show s : shows) {
            ShowDTO showDTO = map(s);
            showDTOS.add(showDTO);
        }

        return showDTOS;

        // the below is the above
//        return repository.findAll()
//                .stream()
//                .map(this::map)
//                .toList();
    }

    public ShowDTO getById(Long id) {
        Optional<Show> show = repository.findById(id);
        if (show.isPresent()) {
            Show s = show.get();
            return map(s);
        } else {
            throw new RuntimeException("NOT FOUND");
        }

//        return repository.findById(id)
//                .map(this::map)
//                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public ShowDTO saveShow(RegisterShowDTO request) {
        Show show = MyMapper.toShow(request);
        repository.save(show);

        return map(show);
    }

    public void deleteShow(Long id) {
        repository.deleteById(id);
    }

    //////////
    private ShowDTO map(Show in) {
        ShowDTO show = MyMapper.toShowDto(in);
        show.setLikes(in.getLikes().stream().map(MyMapper::toUserDto).toList());
        show.setScreenings(in.getScreenings().stream().map(MyMapper::toScreeningDto).toList());

        return show;
    }

    //////////
//    public ShowDTO updateShow(Integer id, UpdateShowDTO request) {
//        Optional<Show> show = repository.findById(id);
//
//        if (show.isPresent()) {
//            merge(show.get(), request);
//            repository.save(show.get());
//
//            return map(show.get());
//        } else {
//            throw new RuntimeException("NOT FOUND");
//        }
//
//
////        Show show = map(id, request);
////        repository.save(show);
////
////        return map(show);
//    }

//    private Show map(Integer id, UpdateShowDTO in) {
//        return new Show(id, in.getName(), in.getDescription());
//    }
//
//    private void merge(Show show, UpdateShowDTO in) {
//        if (in.getName() != null)
//            show.setName(in.getName());
//        if (in.getDescription() != null)
//            show.setDescription(in.getDescription());
//    }
}
