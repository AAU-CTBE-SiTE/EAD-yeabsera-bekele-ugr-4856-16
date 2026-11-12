package com.example.actor_management.service;

import com.example.actor_management.model.Actor;
import com.example.actor_management.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        actorRepository.delete(id);
    }
}