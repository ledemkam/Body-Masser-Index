package techchillo.ledemkam.bmi.repository;

import org.springframework.data.repository.CrudRepository;
import techchillo.ledemkam.bmi.entity.Imc;

public interface ImcRepository extends CrudRepository<Imc, Integer> {
}
