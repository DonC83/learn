package spittr.db;

import spittr.domain.Spittle;

import java.util.List;

/**
 * Created by donovan on 15/06/08.
 */
public interface SpittleRepository {
    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);

}
