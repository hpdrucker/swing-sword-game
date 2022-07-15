package Character;

import ch.clip.samples.authapi.user.AppUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int hp;

    private int damage;

    @OneToMany(mappedBy="character")
    private List<AppUser> users = new ArrayList<AppUser>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}