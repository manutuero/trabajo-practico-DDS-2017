package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.IndicadorMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepositoryMongo extends MongoRepository<IndicadorMongo, String> {
    public IndicadorMongo findById(int id);
    public IndicadorMongo findByCodigo(String codigo);
}
