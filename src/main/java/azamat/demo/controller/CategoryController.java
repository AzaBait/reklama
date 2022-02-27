package azamat.demo.controller;
import azamat.demo.model.Category;
import azamat.demo.service.CategoryService;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.StoredProcedureParameter;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public List<Category> getAllSubcategories(@PathVariable String name) {
        Category category = new Category();
        category.setName(name);
        return categoryService.findCategoriesByName(name);
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
