package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training.business.mappers.TrainingProgramItemMapper;
import com.ozalp.training.business.services.TrainingProgramItemService;
import com.ozalp.training.dataAccess.TrainingItemTaskRepository;
import com.ozalp.training.models.entities.TrainingProgramItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingProgramItemImpl extends BaseImpl<TrainingProgramItem> implements TrainingProgramItemService {

    private final TrainingItemTaskRepository repository;
    private final TrainingProgramItemMapper mapper;

    @Override
    public List<TrainingItemTaskResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    protected JpaRepository<TrainingProgramItem, Integer> getRepository() {
        return repository;
    }
}
