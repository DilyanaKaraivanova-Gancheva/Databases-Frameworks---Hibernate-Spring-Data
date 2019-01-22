package product.shop.productshop;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import product.shop.productshop.io.FileIO;
import product.shop.productshop.models.dto.CategoryDto;
import product.shop.productshop.models.dto.ProductDto;
import product.shop.productshop.models.dto.UserDto;
import product.shop.productshop.models.services.categories.CategoryService;
import product.shop.productshop.models.services.products.ProductService;
import product.shop.productshop.models.services.users.UserService;
import product.shop.productshop.models.views.ProductView;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String USERS_PATH = "F:\\Projects\\Databases Frameworks - Hibernate & Spring Data\\11. JSON Processing\\Exercise\\src\\main\\resources\\files\\input\\users.json";
    private static final String CATEGORIES_PATH = "F:\\Projects\\Databases Frameworks - Hibernate & Spring Data\\11. JSON Processing\\Exercise\\src\\main\\resources\\files\\input\\categories.json";
    private static final String PRODUCTS_PATH = "F:\\Projects\\Databases Frameworks - Hibernate & Spring Data\\11. JSON Processing\\Exercise\\src\\main\\resources\\files\\input\\products.json";

    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private JSONParser jsonParser;
    private FileIO fileIO;

    @Autowired
    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = new JSONParser();
        this.fileIO = new FileIO();
    }

    @Override
    public void run(String... args) throws IOException {
        productsInRange();
    }

    public void persistUsers() throws IOException {
        String content = this.fileIO.read(USERS_PATH);
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        List<UserDto> userDtos = this.jsonParser.importJsons(content,listType);
        userDtos.forEach(u-> this.userService.save(u));
    }

    public void persistProducts() throws IOException {
        String content = this.fileIO.read(PRODUCTS_PATH);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        List<ProductDto> productDtos = this.jsonParser.importJsons(content,listType);
        this.productService.saveAll(productDtos);
    }

    public void persistCategories() throws IOException {
        String content = this.fileIO.read(CATEGORIES_PATH);
        Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
        List<CategoryDto> categoryDtos = this.jsonParser.importJsons(content,listType);
        categoryDtos.forEach(c-> this.categoryService.save(c));
    }

    public void productsInRange() throws IOException {
       List<ProductView> products = this.productService.getAllProductsInRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        this.jsonParser.exportJSON(products,"./src/main/resources/files/output/users-sold-products.json");
    }
}
