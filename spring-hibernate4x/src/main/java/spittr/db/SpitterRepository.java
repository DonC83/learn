package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * Created by donovan on 15/06/08.
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
