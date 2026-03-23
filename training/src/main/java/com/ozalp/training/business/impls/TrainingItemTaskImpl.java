package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training.business.mappers.TrainingItemMapper;
import com.ozalp.training.business.services.TrainingItemTaskService;
import com.ozalp.training.dataAccess.TrainingItemTaskRepository;
import com.ozalp.training.models.entities.TrainingItemTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingItemTaskImpl extends BaseImpl<TrainingItemTask> implements TrainingItemTaskService {

    private final TrainingItemTaskRepository repository;
    private final TrainingItemMapper mapper;

    public TrainingItemTaskImpl(JpaRepository<TrainingItemTask, Integer> baseRepository, TrainingItemTaskRepository repository, TrainingItemMapper mapper) {
        super(baseRepository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TrainingItemTaskResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
