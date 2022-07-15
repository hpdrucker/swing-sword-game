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


    public Item() {
    }

    public Item(Long id, String name, int damage, List<Character> chara) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.chara = chara;
    }

    public Item(String name, int damage, List<Character> chara) {
        this.name = name;
        this.damage = damage;
        this.chara = chara;
    }

    public Item(String name, int damage) {
        this.name = name;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public List<Character> getChara() {
        return chara;
    }

    public void setChara(List<Character> chara) {
        this.chara = chara;
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