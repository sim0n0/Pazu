package com.augeregalloydelisle.back.service;

import com.augeregalloydelisle.back.entity.Proposition;
import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.RessourceNotFoundException;
import com.augeregalloydelisle.back.repository.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PropositionService {

    @Autowired
    private PropositionRepository propositionRepository;

    public void voteYes(Integer idProposition, User user) {
        Optional<Proposition> proposition = propositionRepository.findById(idProposition);
        if (proposition.isEmpty()) {
            throw new RessourceNotFoundException("proposition = " + idProposition + " notFound");
        }
        Proposition p = proposition.get();
        p.getNo().remove(user);
        p.getYes().add(user);

    }

    public void voteNon(Integer idProposition, User user) {
        Optional<Proposition> proposition = propositionRepository.findById(idProposition);
        if (proposition.isEmpty()) {
            throw new RessourceNotFoundException("proposition = " + idProposition + " notFound");
        }
        Proposition p = proposition.get();
        p.getYes().remove(user);
        p.getNo().add(user);
    }

    public void voteDelete(Integer idProposition, User user) {
        Optional<Proposition> proposition = propositionRepository.findById(idProposition);
        if (proposition.isEmpty()) {
            throw new RessourceNotFoundException("proposition = " + idProposition + " notFound");
        }
        Proposition p = proposition.get();
        p.getYes().remove(user);
        p.getNo().remove(user);

    }

    public Proposition findByID(Integer id) {
        Optional<Proposition> proposition = propositionRepository.findById(id);
        if (proposition.isEmpty()) {
            throw new RessourceNotFoundException("proposition = " + id + " notFound");
        }
        return proposition.get();
    }
}