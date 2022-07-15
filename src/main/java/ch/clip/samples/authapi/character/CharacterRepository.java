package ch.clip.samples.authapi.character;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    //void addCharacter(Character character, Long id);
}
