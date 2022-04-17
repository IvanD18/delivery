package application.repository;

import application.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {

}
