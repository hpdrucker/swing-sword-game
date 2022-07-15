package ch.clip.samples.authapi.ability;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import ch.clip.samples.authapi.character.Character;


@Entity
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String effect;


    @ManyToMany(mappedBy = "abilities")
    private List<Character> chara;



    public Ability() {
    }

    public Ability(Long id, String name, String effect, List<Character> character) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.chara = character;
    }

    public Ability(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public List<Character> getCharacters() {
        return chara;
    }

    public void setCharacters(List<Character> characters) {
        this.chara = characters;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }


}