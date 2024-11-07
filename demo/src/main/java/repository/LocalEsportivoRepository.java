package repository;

import entity.LocalEsportivo;
import entity.Anfitriao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalEsportivoRepository extends JpaRepository<LocalEsportivo, Long> {

    List<LocalEsportivo> findByAnfitriao(Anfitriao anfitriao);
}

