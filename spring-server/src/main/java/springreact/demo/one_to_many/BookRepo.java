package springreact.demo.one_to_many;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository <Book, Integer> {
}
