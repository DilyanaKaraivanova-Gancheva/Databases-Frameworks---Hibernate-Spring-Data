package app.services.api;

import app.dto.binding.CategoryDto;
import app.dto.view.CategoryView;

import java.util.List;

public interface CategoryService {
    void save(CategoryDto categoryDto);

    void saveAll(CategoryDto[] categories);

    List<CategoryView> getCategoriesByProductsCount();
}
