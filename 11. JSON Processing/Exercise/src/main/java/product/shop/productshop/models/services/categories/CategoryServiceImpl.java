package product.shop.productshop.models.services.categories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.shop.productshop.models.dto.CategoryDto;
import product.shop.productshop.models.entities.Category;
import product.shop.productshop.models.repositories.CategoryRepo;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.modelMapper = new ModelMapper();
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        this.categoryRepo.save(category);
    }
}
