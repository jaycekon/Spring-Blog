package com.charles.api.repository;

import com.charles.api.model.Charles;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jaycekon on 2018/1/14.
 */
@Repository
public class CharlesRepository {

    private static final ConcurrentMap<Integer, Charles> map = new ConcurrentHashMap<>();

    static {
        map.put(1, new Charles(1, "charles"));
    }

    private static AtomicInteger ID_CREATOR = new AtomicInteger(0);


    public Charles save(Charles charles) {
        int id = ID_CREATOR.incrementAndGet();
        charles.setId(id);
        map.put(id, charles);
        return charles;

    }


    public Collection<Charles> findAll() {
        return map.values();
    }
}
