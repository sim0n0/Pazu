package com.augeregalloydelisle.back.service;

import com.augeregalloydelisle.back.entity.Proposition;
import com.augeregalloydelisle.back.entity.Sondage;
import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.RessourceNotFoundException;
import com.augeregalloydelisle.back.repository.SondageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SondageService {

    @Autowired
    private SondageRepository sondageRepository;

    public Sondage findById(Integer id) {
        Optional<Sondage> sondage = sondageRepository.findById(id);
        if (sondage.isEmpty()) {
            throw new RessourceNotFoundException("sondage=" + id + " notFound");
        }
        return sondage.get();
    }

    public Sondage create(String title, String place, List<Proposition> propositions, User owner) {
        Sondage sondage = new Sondage(title, place, propositions, owner);
        return sondageRepository.save(sondage);
    }

    public List<Sondage> getAllSondageByOwner(User owner) {
        return sondageRepository.findAllByOwner(owner).orElse(new ArrayList<>());

    }

    public void delete(Sondage sondage) {
        sondageRepository.delete(sondage);
    }
}