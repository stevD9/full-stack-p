package me.stef.fullstack.dao;

import me.stef.fullstack.model.Reservation;
import me.stef.fullstack.model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

    @Query(value = """
            from Reservation r
            where r.id.userId = ?1
            """)
    List<Reservation> findForUser(Long userId);

    @Modifying
    @Query(value = """
            delete from Reservation r
            where r.id.userId = ?1
            """)
    void deleteForUser(Long userId);
}
