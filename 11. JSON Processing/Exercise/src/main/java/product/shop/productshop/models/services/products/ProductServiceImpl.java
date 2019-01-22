package product.shop.productshop.models.services.products;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.shop.productshop.models.dto.ProductDto;
import product.shop.productshop.models.entities.Category;
import product.shop.productshop.models.entities.Product;
import product.shop.productshop.models.entities.User;
import product.shop.productshop.models.repositories.CategoryRepo;
import product.shop.productshop.models.repositories.ProductRepo;
import product.shop.productshop.models.repositories.UserRepo;
import product.shop.productshop.models.views.ProductView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private UserRepo userRepo;
    private CategoryRepo categoryRepo;
    private ProductRepo productRepo;
    private ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(UserRepo userRepo, CategoryRepo categoryRepo, ProductRepo productRepo) {
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
        this.mapper = new ModelMapper();
    }

    @Override
    public void saveAll(List<ProductDto> productDtos) {
        Random random = new Random();
        List<User> allUsers = this.userRepo.findAll();
        List<Category> allCategories = this.categoryRepo.findAll();
        for (ProductDto productDto : productDtos) {
            Product product = this.mapper.map(productDto, Product.class);
            int sellerIndex = random.nextInt(allUsers.size());
            product.setSeller(allUsers.get(sellerIndex));
            int isSoldChance = random.nextInt(4);
            if (isSoldChance > 0) {
                int buyerIndex = random.nextInt(allUsers.size());
                product.setBuyer(allUsers.get(buyerIndex));
            }
            int categoryIndex = random.nextInt(allCategories.size());
            product.getCategories().add(allCategories.get(categoryIndex));
            for (int i = 0; i < 3; i++) {
                categoryIndex = random.nextInt(allCategories.size());
                if (categoryIndex % 2 == 0) {
                    product.getCategories().add(allCategories.get(categoryIndex));
                }
            }

            for (Category cat : product.getCategories()) {
                cat.getProducts().add(product);
            }
            this.productRepo.saveAndFlush(product);
        }
    }

    @Override
    public List<ProductView> getAllProductsInRange(BigDecimal from, BigDecimal to) {
        List<Product> products = this.productRepo.findByPriceBetweenAndBuyerIdIsNullOrderByPrice(from, to);

        List<ProductView> productViews = new ArrayList<>();
        for (Product product : products) {
            ProductView productView = new ProductView();
            productView.setName(product.getName());
            productView.setSellerName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
            productView.setPrice(product.getPrice());
            productViews.add(productView);
        }

        return productViews;
    }
}
