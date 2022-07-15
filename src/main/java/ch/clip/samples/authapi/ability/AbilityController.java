package ch.clip.samples.authapi.ability;

import ch.clip.samples.authapi.item.Item;
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

    /**
     * Bei diesem Postmapping kann man eine neue Ability erstellen
     * @param ability
     *
     */
    @PostMapping("/{id}")
    public void addAbility(@RequestBody Ability ability) { // , @RequestBody Task task) {
        // service methode user, id -> Service taak getById user.setTask
        abilityRepository.save(ability);
    }

    /**
     * Dieses Getmapping gibt alle Abilities zurück
     * @return
     */
    @GetMapping("/all")
    public List<Ability> getAbilites() {
        return abilityRepository.findAll();
    }

    /**
     * Dieses Deletemapping löscht die Ability
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable long id) {
        Ability abilityToDel = abilityRepository.findById(id).get();
        abilityRepository.delete(abilityToDel);
    }
}
