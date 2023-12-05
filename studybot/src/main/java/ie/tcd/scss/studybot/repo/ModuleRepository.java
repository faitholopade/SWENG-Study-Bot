package ie.tcd.scss.studybot.repo;

import ie.tcd.scss.studybot.domain.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, String> {
}
