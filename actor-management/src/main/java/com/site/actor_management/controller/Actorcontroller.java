package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Actorcontroller {
   List<Actor> actors = new ArrayList<>();

    @GetMapping("/actor")
    public List<Actor> getActorDetails() {

        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor(1, "john doe", "The great Adventure"));
        actors.add(new Actor(1, "john doe", "The great Adventure"));
        return actors;
    }
     // Create
    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor actor){
        actors.add(actor);
        return actor;
    }
    // Read all
    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id){
        for(Actor  actor :actors){
            if(actor.getId() == id){
                return actor;
            }
        }
        return null;
    }
    @PutMapping("/actor/{id}")
    public Actor updateActor(
            @PathVariable int id,
            @RequestBody Actor updatedActor) {

        for (Actor actor : actors) {

            if (actor.getId() == id) {

                actor.setName(updatedActor.getName());
                actor.setMoviename(updatedActor.getMoviename());

                return actor;
            }
        }

        return null;
    }


    // DELETE
    @DeleteMapping("/actor/{id}")
    public String deleteActor(@PathVariable int id) {

        for (Actor actor : actors) {

            if (actor.getId() == id) {

                actors.remove(actor);

                return "Actor deleted successfully";
            }
        }

        return "Actor not found";
    }
}

