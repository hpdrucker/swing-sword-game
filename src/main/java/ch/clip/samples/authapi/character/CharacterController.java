package ch.clip.samples.authapi.character;

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
        //super();
        this.characterRepository = characterRepository;
    }

    @PostMapping("/{id}")
    public void addCharacter(@RequestBody Character character, @PathVariable Long id) { // , @RequestBody Task task) {
        // service methode user, id -> Service taak getById user.setTask
        //characterRepository.addCharacter(character, id);
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }
}
