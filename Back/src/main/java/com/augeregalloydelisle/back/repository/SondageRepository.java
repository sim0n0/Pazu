package com.augeregalloydelisle.back.repository;

import com.augeregalloydelisle.back.entity.Sondage;
import com.augeregalloydelisle.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SondageRepository extends JpaRepository<Sondage, Integer> {
    Optional<List<Sondage>> findAllByOwner(User owner);

}
