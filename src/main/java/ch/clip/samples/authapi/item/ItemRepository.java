package ch.clip.samples.authapi.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    //void addItem(Item item, Long id);
}
