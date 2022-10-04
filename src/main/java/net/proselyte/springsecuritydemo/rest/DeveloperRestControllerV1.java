package net.proselyte.springsecuritydemo.rest;

import net.proselyte.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> DEVELOPERS = Stream.of(
                    new Developer(1, "Poxos", "Poxosyan"),
                    new Developer(2, "Petros", "Petrosyan"),
                    new Developer(3, "Maria", "Sargsyan"))
            .collect(Collectors.toList());


    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable int id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.DEVELOPERS.removeIf(developer -> developer.getId() == id);
    }
}
