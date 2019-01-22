package product.shop.productshop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import product.shop.productshop.io.FileIO;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JSONParser {
    private Gson gson;
    @Autowired
    private FileIO fileIO;

    public JSONParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    public <T> T importJsons(String content, Type type) throws FileNotFoundException {
       return this.gson.fromJson(content,type);

    }

    public <T> void exportJSON(List<T> t, String fileName) throws IOException {
        try (Writer writer = new FileWriter(fileName)) {
            this.gson.toJson(t, writer);
        }
    }
}
