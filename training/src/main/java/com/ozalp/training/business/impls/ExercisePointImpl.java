package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.services.ExercisePointService;
import com.ozalp.training.dataAccess.ExercisePointRepository;
import com.ozalp.training.models.entities.ExercisePoint;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExercisePointImpl extends BaseImpl<ExercisePoint> implements ExercisePointService {

    private final ExercisePointRepository repository;

    @Override
    protected JpaRepository<ExercisePoint, Integer> getRepository() {
        return repository;
    }
}
