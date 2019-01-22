package app.services.api;

import app.dtos.bindings.PartDto;
import app.entities.Part;

public interface PartService {
    void save(Part part);

    void saveAll(PartDto[] parts);
}
