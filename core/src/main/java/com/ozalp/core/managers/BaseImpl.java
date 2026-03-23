package com.ozalp.core.managers;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.core.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class BaseImpl<T extends BaseEntity> implements BaseService<T> {

    private final JpaRepository<T, Integer> baseRepository;

    @Override
    public T findById(int id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public void delete(int id) {
        T entity = findById(id);
        entity.markAsDelete();
        baseRepository.save(entity);
    }
}