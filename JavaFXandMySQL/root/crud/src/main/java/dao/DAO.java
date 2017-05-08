package dao;

import java.util.List;

/**
 * Created by DrSwitch on 03.05.2017.
 * <T> Это применение дженериков
 */
public interface DAO<T> {

    T getById(int id);

    T add(T domain);

    void update(T domain);

    void delete(int id);

    List<T> getAll();
}
