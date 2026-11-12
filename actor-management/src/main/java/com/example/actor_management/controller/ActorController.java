package com.example.actor_management.controller;

import com.example.actor_management.model.Actor;
import com.example.actor_management.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActor(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public String addActor(@RequestBody Actor actor) {
        actorService.addActor(actor);
        return "Actor added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return "Actor deleted successfully";
    }
}