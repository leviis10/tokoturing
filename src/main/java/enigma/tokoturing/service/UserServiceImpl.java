package enigma.tokoturing.service;

import enigma.tokoturing.model.User;
import enigma.tokoturing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateById(User updatedUser) {
        User foundUser = getById(updatedUser.getId());
        if (foundUser == null) {
            return null;
        }
        foundUser.setName(updatedUser.getName());
        foundUser.setBirthPlace(updatedUser.getBirthPlace());
        return userRepository.save(foundUser);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
