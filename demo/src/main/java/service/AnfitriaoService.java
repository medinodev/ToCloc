package service;

import entity.Anfitriao;
import entity.LocalEsportivo;
import repository.AnfitriaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnfitriaoService {

    @Autowired
    private AnfitriaoRepository anfitriaoRepository;

    // Retorna todos os anfitriões
    public List<Anfitriao> findAllAnfitrioes() {
        return anfitriaoRepository.findAll();
    }

    // Busca um anfitrião pelo ID
    public Optional<Anfitriao> findAnfitriaoById(Long id) {
        return anfitriaoRepository.findById(id);
    }

    // Salva um novo anfitrião
    public Anfitriao saveAnfitriao(Anfitriao anfitriao) {
        return anfitriaoRepository.save(anfitriao);
    }

    // Atualiza um anfitrião existente
    public Anfitriao updateAnfitriao(Long id, Anfitriao updatedAnfitriao) {
        return anfitriaoRepository.findById(id).map(anfitriao -> {
            anfitriao.setNome(updatedAnfitriao.getNome());
            anfitriao.setEmail(updatedAnfitriao.getEmail());
            anfitriao.setTelefone(updatedAnfitriao.getTelefone());
            return anfitriaoRepository.save(anfitriao);
        }).orElseThrow(() -> new RuntimeException("Anfitrião não encontrado com ID: " + id));
    }

    // Deleta um anfitrião pelo ID
    public void deleteAnfitriao(Long id) {
        anfitriaoRepository.deleteById(id);
    }

    // Adiciona um local esportivo ao anfitrião
    public Anfitriao addLocalEsportivo(Long anfitriaoId, LocalEsportivo localEsportivo) {
        return anfitriaoRepository.findById(anfitriaoId).map(anfitriao -> {
            anfitriao.addLocalEsportivo(localEsportivo);
            return anfitriaoRepository.save(anfitriao);
        }).orElseThrow(() -> new RuntimeException("Anfitrião não encontrado com ID: " + anfitriaoId));
    }
}

