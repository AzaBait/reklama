package azamat.demo.service;

import azamat.demo.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    List<Category> findCategoriesByName(String name);

}
