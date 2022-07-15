package ch.clip.samples.authapi.ability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    //void addAbility(Ability ability, Long id);
}
