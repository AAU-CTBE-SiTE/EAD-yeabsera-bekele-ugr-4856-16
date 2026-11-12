package com.example.actor_management.repository;

import com.example.actor_management.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepository {

    private final List<Actor> actors = new ArrayList<>();

    public ActorRepository() {
        actors.add(new Actor(1L, "Leonardo DiCaprio", "Inception"));
        actors.add(new Actor(2L, "Tom Hanks", "Forrest Gump"));
    }

    public List<Actor> findAll() {
        return actors;
    }

    public Actor findById(Long id) {

        return actors.stream()
                .filter(actor -> actor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Actor actor) {
        actors.add(actor);
    }

    public void delete(Long id) {
        actors.removeIf(actor -> actor.getId().equals(id));
    }
}