package repository;

import entity.Anfitriao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnfitriaoRepository extends JpaRepository<Anfitriao, Long> {
}

