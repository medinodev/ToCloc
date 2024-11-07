package service;

import entity.LocalEsportivo;
import entity.Anfitriao;
import repository.LocalEsportivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalEsportivoService {

    @Autowired
    private LocalEsportivoRepository localEsportivoRepository;

    public List<LocalEsportivo> findAllLocaisEsportivos() {
        return localEsportivoRepository.findAll();
    }

    // Busca um local esportivo pelo ID
    public Optional<LocalEsportivo> findLocalEsportivoById(Long id) {
        return localEsportivoRepository.findById(id);
    }

    // Salva um novo local esportivo
    public LocalEsportivo saveLocalEsportivo(LocalEsportivo localEsportivo) {
        return localEsportivoRepository.save(localEsportivo);
    }

    // Atualiza um local esportivo existente
    public LocalEsportivo updateLocalEsportivo(Long id, LocalEsportivo updatedLocalEsportivo) {
        return localEsportivoRepository.findById(id).map(local -> {
            local.setNome(updatedLocalEsportivo.getNome());
            local.setEndereco(updatedLocalEsportivo.getEndereco());
            local.setTipoDeEsporte(updatedLocalEsportivo.getTipoDeEsporte());
            local.setPrecoPorHora(updatedLocalEsportivo.getPrecoPorHora());
            local.setAnfitriao(updatedLocalEsportivo.getAnfitriao());
            return localEsportivoRepository.save(local);
        }).orElseThrow(() -> new RuntimeException("Local Esportivo não encontrado com ID: " + id));
    }

    public void deleteLocalEsportivo(Long id) {
        localEsportivoRepository.deleteById(id);
    }

    public List<LocalEsportivo> findLocaisByAnfitriao(Anfitriao anfitriao) {
        return localEsportivoRepository.findByAnfitriao(anfitriao);
    }
}

