package shampoos.interfaces;

import java.util.Set;

public interface Batch {
    long getId();

    void setId(long id);

    Set<Shampoo> getShampoos();

    void setShampoos(Set<Shampoo> shampoos);
}
