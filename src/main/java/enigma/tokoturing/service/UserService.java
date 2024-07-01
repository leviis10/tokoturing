package enigma.tokoturing.service;

import enigma.tokoturing.model.User;

import java.util.List;

public interface UserService {
    User create(User newUser);

    List<User> getAll();

    User getById(Integer id);

    User updateById(User updatedUser);

    void deleteById(Integer id);
}
