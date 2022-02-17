package azamat.demo.controller;


import azamat.demo.model.Category;
import azamat.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category newCategory){
        return categoryService.save(newCategory);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        categoryService.delete(id);
    }
}
