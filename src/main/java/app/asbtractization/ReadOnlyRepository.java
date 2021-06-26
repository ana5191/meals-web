package app.asbtractization;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * "Read-only Repository" pattern
 * Doar pt SELECT (queries), nu si pt INSERT/UPDATE/DELETE (commands)
 * 
 * Repository <-- CrudRepository <-- PagingAndSortingRepository <-- JpaRepository
 * 
 * CrudRepository:				adds support for CRUD operations: exists/count/find, save, delete
 * PagingAndSortingRepository:	adds Iterable<T> findAll(Sort sort) and Page<T> findAll(Pageable pageable)
 * JpaRepository:				adds support for batch operations and QBE (Query By Example)
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    long count();
}
