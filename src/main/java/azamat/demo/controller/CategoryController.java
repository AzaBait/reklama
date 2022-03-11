package azamat.demo.controller;

import azamat.demo.dto.CategoryDto;
import azamat.demo.model.Category;
import azamat.demo.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.findRootCategories();
        return categories.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public List<CategoryDto> getAllSubcategoriesByName(@PathVariable String name) {
        List<Category> categories = categoryService.findCategoriesByName(name);
        return categories.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public CategoryDto save(@RequestBody CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category categorySaved = categoryService.save(category);
        return convertToDto(categorySaved);
    }

    @PutMapping("/update")
    public CategoryDto update(@RequestBody CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category categorySaved = categoryService.save(category);
        return convertToDto(categorySaved);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }
}
