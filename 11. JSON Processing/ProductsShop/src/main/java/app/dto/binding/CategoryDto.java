package app.dto.binding;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CategoryDto implements Serializable{
    @Expose
    private String name;

    public CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
