package ch.clip.samples.authapi.item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import ch.clip.samples.authapi.character.Character;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int damage;

    @ManyToMany(mappedBy = "items")
    private List<Character> chara;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }
}