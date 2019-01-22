package product.shop.productshop.models.services.users;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.shop.productshop.models.dto.UserDto;
import product.shop.productshop.models.entities.User;
import product.shop.productshop.models.repositories.UserRepo;
import product.shop.productshop.models.views.UsersViewModelWrapper;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void save(UserDto usersDto) {
        User user = this.modelMapper.map(usersDto, User.class);
        this.userRepo.save(user);

    }
}
