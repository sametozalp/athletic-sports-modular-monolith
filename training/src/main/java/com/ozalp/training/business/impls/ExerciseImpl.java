package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.dtos.responses.ExerciseResponse;
import com.ozalp.training.business.mappers.ExerciseMapper;
import com.ozalp.training.business.services.ExerciseService;
import com.ozalp.training.dataAccess.ExerciseRepository;
import com.ozalp.training.models.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseImpl extends BaseImpl<Exercise> implements ExerciseService {

    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    public ExerciseImpl(JpaRepository<Exercise, Integer> baseRepository, ExerciseRepository repository, ExerciseMapper mapper) {
        super(baseRepository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        Exercise exercise = mapper.toEntity(request);
        return mapper.toResponse(repository.save(exercise));
    }
}
