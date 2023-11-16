package me.stef.fullstack.dao;

import me.stef.fullstack.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
