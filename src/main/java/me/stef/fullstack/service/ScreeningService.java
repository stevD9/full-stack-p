package me.stef.fullstack.service;

import me.stef.fullstack.dao.ScreeningRepository;
import me.stef.fullstack.dao.ShowRepository;
import me.stef.fullstack.dto.RegisterScreeningDTO;
import me.stef.fullstack.dto.ScreeningDTO;
import me.stef.fullstack.mapper.MyMapper;
import me.stef.fullstack.model.Screening;
import me.stef.fullstack.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private ShowRepository showRepository;

    public ScreeningDTO saveScreening(RegisterScreeningDTO in) {
        Screening screening = MyMapper.toScreening(in);
        Show show = showRepository.findById(in.getShowId())
                .orElseThrow(() -> new RuntimeException("Not found"));

        screening.setShow(show);

        screeningRepository.save(screening);

        return map(screening);
    }

    public List<ScreeningDTO> getScreenings() {
        return screeningRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public ScreeningDTO getById(Long id) {
        return screeningRepository.findById(id)
                .map(this::map)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(Long id) {
        screeningRepository.deleteById(id);
    }

    /////////
    private ScreeningDTO map(Screening in) {
        ScreeningDTO screening = MyMapper.toScreeningDto(in);

        screening.setShow(MyMapper.toShowDto(in.getShow()));
        screening.setReservations(in.getReservations().stream()
                .map(r -> MyMapper.toUserDto(r.getUser()))
                .toList());

        return screening;
    }
}
