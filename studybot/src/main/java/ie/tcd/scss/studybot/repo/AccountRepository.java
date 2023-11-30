package ie.tcd.scss.studybot.repo;

import ie.tcd.scss.studybot.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
