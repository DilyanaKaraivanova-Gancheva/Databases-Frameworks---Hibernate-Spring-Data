package app;

import app.dtos.bindings.CarDto;
import app.dtos.bindings.CustomerDto;
import app.dtos.bindings.PartDto;
import app.dtos.bindings.SupplierDto;
import app.dtos.views.*;
import app.services.api.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    private SaleService saleService;
    private CustomerService customerService;
    private PartService partService;
    private SupplierService supplierService;
    private CarService carService;
    private Gson gson;

    @Autowired
    public Terminal(SaleService saleService, CustomerService customerService, PartService partService, SupplierService supplierService, CarService carService) {
        this.saleService = saleService;
        this.customerService = customerService;
        this.partService = partService;
        this.supplierService = supplierService;
        this.carService = carService;
        this.gson = createGson();
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedDatabase();

        //Problem 1
        //this.getAllCustomersOrderedByBirthdate();

        //Problem 2
        //this.getCarsFromMakeToyota();

        //Problem 3
        //this.getAllLocalSuppliers();

        //Problem 4
        //this.getAllCarsWithTheirParts();

        //Problem 5
        //this.getAllCustomersWithPurchases();

        //Problem 6
        this.getAllSaleDetails();

    }

    private void getAllSaleDetails() throws IOException {
        List<SaleView> sales = this.saleService.getAllSaleDetails();
        FileWriter writer = new FileWriter("./src/main/resources/output/sales-details.json");
        writer.write(this.gson.toJson(sales));
        writer.close();
    }

    private void getAllCustomersWithPurchases() throws IOException {
        List<CustomerPurchasesView> customers = this.customerService.getAllCustomersWithPurchases();
        FileWriter writer = new FileWriter("./src/main/resources/output/customers-purchases.json");
        writer.write(this.gson.toJson(customers));
        writer.close();
    }

    private void getAllCarsWithTheirParts() throws IOException {
        List<CarsPartsView> carsParts = this.carService.getAllCarsWithTheirParts();
        FileWriter writer = new FileWriter("./src/main/resources/output/cars-parts.json");
        writer.write(this.gson.toJson(carsParts));
        writer.close();
    }

    private void getAllLocalSuppliers() throws IOException {
        List<SupplierView> suppliers = this.supplierService.getAllLocalSuppliers();
        FileWriter writer = new FileWriter("./src/main/resources/output/local-suppliers.json");
        writer.write(this.gson.toJson(suppliers));
        writer.close();
    }

    private void getCarsFromMakeToyota() throws IOException {
        List<CarByMakeView> cars = this.carService.getCarsByMake("Toyota");
        FileWriter writer = new FileWriter("./src/main/resources/output/toyota-cars.json");
        writer.write(this.gson.toJson(cars));
        writer.close();
    }

    private void getAllCustomersOrderedByBirthdate() throws IOException {
        List<CustomerByBirthdateView> customers = this.customerService.getAllSortedByBirthDate();
        FileWriter writer = new FileWriter("./src/main/resources/output/customers-by-birthdate.json");
        writer.write(this.gson.toJson(customers));
        writer.close();
    }

    private void seedDatabase() throws FileNotFoundException {
        String path = "./src/main/resources/files/suppliers.json";
        JsonReader reader = new JsonReader(new FileReader(path));
        SupplierDto[] suppliers = this.gson.fromJson(reader, SupplierDto[].class);
        this.supplierService.saveAll(suppliers);

        path = "./src/main/resources/files/parts.json";
        reader = new JsonReader(new FileReader(path));
        PartDto[] parts = this.gson.fromJson(reader, PartDto[].class);
        this.partService.saveAll(parts);

        path = "./src/main/resources/files/cars.json";
        reader = new JsonReader(new FileReader(path));
        CarDto[] cars = this.gson.fromJson(reader, CarDto[].class);
        this.carService.saveAll(cars);

        path = "./src/main/resources/files/customers.json";
        reader = new JsonReader(new FileReader(path));
        CustomerDto[] customers = this.gson.fromJson(reader, CustomerDto[].class);
        this.customerService.saveAll(customers);

        this.saleService.insertRandomData();
    }

    private Gson createGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
                .create();
    }
}
