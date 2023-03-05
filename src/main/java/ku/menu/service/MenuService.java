package ku.menu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ku.menu.entity.Menu;
import ku.menu.repository.MenuRepository;
import java.util.List;
import java.util.UUID;
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(UUID id) {
        return menuRepository.findById(id).get();
    }

    public Menu create(Menu menu) {
        System.out.println("Before JPA: " + menu);
        Menu record = menuRepository.save(menu);
        System.out.println("After JPA: " + menu);
        return record;
    }

    public Menu update(Menu requestBody) {
        UUID id = requestBody.getId();
        Menu record = menuRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());
        record = menuRepository.save(record);
        return record;
    }

    public Menu delete(UUID id) {
        Menu record = menuRepository.findById(id).get();
        menuRepository.deleteById(id);
        return record;
    }

    public Menu getMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    public List<Menu> getMenuByCategory(String category) {
        return menuRepository.findByCategory(category);
    }
}