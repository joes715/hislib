
package com.hospital.adapt.mapper.common;

import java.util.List;

public interface CommonMapper<T> {
    public void add(T t);

    public void update(T t);

    public T queryById(String id);

    public List<T> queryAll();

    public void deleteById(String id);
}
