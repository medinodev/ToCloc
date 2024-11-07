package service;

import entity.Reserva;
import entity.User;
import repository.ReservaRepository;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Reserva> findAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public User addReservaToUser(Long userId, Long reservaId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Reserva> reservaOpt = reservaRepository.findById(reservaId);

        if (userOpt.isPresent() && reservaOpt.isPresent()) {
            User user = userOpt.get();
            Reserva reserva = reservaOpt.get();

            user.addReserva(reserva);
            userRepository.save(user);

            return user;
        } else {
            throw new RuntimeException("Usuário ou reserva não encontrado.");
        }
    }
}

