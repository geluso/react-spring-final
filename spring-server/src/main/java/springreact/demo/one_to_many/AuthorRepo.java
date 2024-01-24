package springreact.demo.one_to_many;

import org.springframework.data.repository.CrudRepository;
import springreact.demo.User;

public interface AuthorRepo extends CrudRepository <Author, Integer> {
}
