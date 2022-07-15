package ch.clip.samples.authapi.item;

import ch.clip.samples.authapi.character.Character;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @PostMapping("/{id}")
    public void addItem(@RequestBody Item item, @PathVariable Long id) { // , @RequestBody Task task) {
        // service methode user, id -> Service taak getById user.setTask
        //itemRepository.addItem(item, id);
    }

    @GetMapping("/all")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable long id) {
        Item itemToDel = itemRepository.findById(id).get();
        itemRepository.delete(itemToDel);
    }
}
