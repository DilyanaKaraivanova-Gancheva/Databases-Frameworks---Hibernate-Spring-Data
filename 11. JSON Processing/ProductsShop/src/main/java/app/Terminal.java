package app;

import app.dto.binding.CategoryDto;
import app.dto.binding.ProductDto;
import app.dto.binding.UserDto;
import app.dto.view.CategoryView;
import app.dto.view.ProductView;
import app.dto.view.UserView;
import app.dto.view.UsersProductsView;
import app.services.api.CategoryService;
import app.services.api.ProductService;
import app.services.api.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private Gson gson;

    @Autowired
    public Terminal(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = createGson();
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedDatabase();

        //Problem 1
        //this.getProductsInPriceRangeWithNoBuyer();

        //Problem 2
        //this.getSuccessfullySoldProducts();

        //Problem 3
        //this.getCategoriesByProductsCount();

        //Problem 4
        this.getUsersWithSoldProducts();

    }

    private Gson createGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    private void seedDatabase() throws IOException {
        String path = "./src/main/resources/files/users.json";
        JsonReader reader = new JsonReader(new FileReader(path));
        UserDto[] users = this.gson.fromJson(reader, UserDto[].class);
        this.userService.saveAll(users);

        path = "./src/main/resources/files/categories.json";
        reader = new JsonReader(new FileReader(path));
        CategoryDto[] categories = this.gson.fromJson(reader, CategoryDto[].class);
        this.categoryService.saveAll(categories);

        path = "./src/main/resources/files/products.json";
        reader = new JsonReader(new FileReader(path));
        ProductDto[] products = this.gson.fromJson(reader, ProductDto[].class);
        this.productService.saveAll(products);
    }

    public void getProductsInPriceRangeWithNoBuyer() throws IOException {
        List<ProductView> products = this.productService.findAllInPriceRange(new BigDecimal(500), new BigDecimal(1000));
        FileWriter writer = new FileWriter("./src/main/resources/output/products-in-price-range.json");
        writer.write(this.gson.toJson(products));
        writer.close();
    }

    public void getSuccessfullySoldProducts() throws IOException {
        List<UserView> users = this.userService.findAllUsersWithSoldProducts();
        FileWriter writer = new FileWriter("./src/main/resources/output/users-sold-products.json");
        writer.write(this.gson.toJson(users));
        writer.close();
    }

    private void getCategoriesByProductsCount() throws IOException {
        List<CategoryView> categories = this.categoryService.getCategoriesByProductsCount();
        FileWriter writer = new FileWriter("./src/main/resources/output/categories-products.json");
        writer.write(this.gson.toJson(categories));
        writer.close();
    }

    public void getUsersWithSoldProducts() throws IOException {
        UsersProductsView output = this.userService.getUsersWithSoldProducts();
        FileWriter writer = new FileWriter("./src/main/resources/output/users-products.json");
        writer.write(this.gson.toJson(output));
        writer.close();
    }
}
