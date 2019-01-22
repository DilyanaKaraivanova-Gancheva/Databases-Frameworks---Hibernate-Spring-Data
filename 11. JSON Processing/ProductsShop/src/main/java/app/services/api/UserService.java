package app.services.api;

import app.dto.binding.UserDto;
import app.dto.view.UserView;
import app.dto.view.UsersProductsView;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    void saveAll(UserDto[] users);

    List<UserView> findAllUsersWithSoldProducts();

    UsersProductsView getUsersWithSoldProducts();
}
