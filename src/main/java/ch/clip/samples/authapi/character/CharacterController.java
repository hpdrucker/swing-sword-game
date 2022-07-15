package ch.clip.samples.authapi.character;

import ch.clip.samples.authapi.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        super();
        this.characterRepository = characterRepository;
    }

    @PostMapping
    public void addCharacter(@RequestBody Character character) { // , @RequestBody Task task) {
        // service methode user, id -> Service taak getById user.setTask
        characterRepository.save(character);
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable long id) {
        Character characterToDel = characterRepository.findById(id).get();
        characterRepository.delete(characterToDel);
    }
}
