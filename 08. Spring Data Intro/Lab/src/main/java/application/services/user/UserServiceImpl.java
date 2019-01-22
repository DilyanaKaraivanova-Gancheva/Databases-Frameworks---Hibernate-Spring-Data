package application.services.user;

import application.models.User;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Primary
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Long id = user.getId();

        if (id != null) {
            if (this.userRepository.exists(id)) {
                throw new IllegalArgumentException("User with this id exists");
            }
        }

        String username = user.getUsername();
        if (username != null){
            if (userRepository.findByUsername(username) != null){
                throw new IllegalArgumentException("User with this username already exists");
            }
        }

        this.userRepository.save(user);
    }
}
