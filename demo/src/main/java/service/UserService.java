package service;

import entity.User;
import entity.Reserva;
import repository.UserRepository;
import repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservaRepository reservaRepository;


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));


        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());


        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User addReservaToUser(Long userId, Long reservaId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + userId));
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + reservaId));

        user.addReserva(reserva);
        return userRepository.save(user);
    }
}

