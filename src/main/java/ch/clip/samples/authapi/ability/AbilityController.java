package ch.clip.samples.authapi.ability;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ability")
public class AbilityController {
    AbilityRepository abilityRepository;

    public AbilityController(AbilityRepository abilityRepository) {
        super();
        this.abilityRepository = abilityRepository;
    }

    @PostMapping("/{id}")
    public void addAbility(@RequestBody Ability ability, @PathVariable Long id) { // , @RequestBody Task task) {
        // service methode user, id -> Service taak getById user.setTask
        //abilityRepository.addAbility(ability, id);
    }

    @GetMapping
    public List<Ability> getAbilites() {
        return abilityRepository.findAll();
    }
}
