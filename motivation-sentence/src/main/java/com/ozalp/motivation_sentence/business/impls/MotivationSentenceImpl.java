package com.ozalp.motivation_sentence.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.dtos.MotivationSentenceResponse;
import com.ozalp.motivation_sentence.business.mappers.MotivationSentenceMapper;
import com.ozalp.motivation_sentence.business.services.MotivationSentenceService;
import com.ozalp.motivation_sentence.dataAccess.MotivationSentenceRepository;
import com.ozalp.motivation_sentence.models.entities.MotivationSentence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotivationSentenceImpl extends BaseImpl<MotivationSentence> implements MotivationSentenceService {

    private final MotivationSentenceRepository repository;
    private final MotivationSentenceMapper mapper;

    @Override
    public MotivationSentenceResponse create(CreateMotivationSentenceRequest request) {
        MotivationSentence motivationSentence = new MotivationSentence(request.getSentence());
        return mapper.toResponse(repository.save(motivationSentence));
    }

    @Override
    public MotivationSentenceResponse getRandomSentence() {
        List<MotivationSentence> list = repository.getRandomSentence(PageRequest.of(0, 1));
        return list.stream()
                .findFirst()
                .map(mapper::toResponse)
                .orElse(null);

    }

    @Override
    protected JpaRepository<MotivationSentence, Integer> getRepository() {
        return repository;
    }
}
