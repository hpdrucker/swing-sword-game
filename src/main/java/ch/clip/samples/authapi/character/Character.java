package ch.clip.samples.authapi.character;

import ch.clip.samples.authapi.ability.Ability;
import ch.clip.samples.authapi.item.Item;
import ch.clip.samples.authapi.user.AppUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "chara")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int hp;

    @Column
    private int damage;



    @OneToMany(mappedBy="character")
    private List<AppUser> users;



    @ManyToMany()
    @JoinTable(
            name = "ability_chara",
            joinColumns = @JoinColumn(name = "chara_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> abilities;

    @ManyToMany()
    @JoinTable(
            name = "item_chara",
            joinColumns = @JoinColumn(name = "chara_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;





    public Character() {
    }

    public Character(Long id, String name, int hp, int damage, List<AppUser> users, List<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.users = users;
        this.abilities = abilities;
    }

    public Character(String name, int hp, int damage, List<AppUser> users, List<Ability> abilities, List<Item> items) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.users = users;
        this.abilities = abilities;
        this.items = items;
    }

    public Character(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public Character(String name, int hp, int damage, List<Ability> abilities, List<Item> items) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.abilities = abilities;
        this.items = items;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }


}