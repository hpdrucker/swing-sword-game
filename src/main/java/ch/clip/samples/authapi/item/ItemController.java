package ch.clip.samples.authapi.item;

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

    @GetMapping
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
