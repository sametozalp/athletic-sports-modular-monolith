package com.ozalp.training.business.impls;

import com.ozalp.core.managers.BaseImpl;
import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.business.mappers.AthleteProgressMapper;
import com.ozalp.training.business.services.AthleteProgressService;
import com.ozalp.training.dataAccess.AthleteProgressRepository;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteProgressImpl extends BaseImpl<AthleteProgress> implements AthleteProgressService {

    private final AthleteProgressRepository repository;
    private final AthleteProgressMapper mapper;

    @Override
    public void updateStatus(int id, AthleteProgressStatus athleteProgressStatus) {
        AthleteProgress athleteProgress = findById(id);
        athleteProgress.setStatus(athleteProgressStatus);
        save(athleteProgress);
    }

    @Override
    public int getTotalPointThisMonth(int userProfileId) {
        return repository.getTotalPointThisMonth(userProfileId);
    }

    @Override
    public int getAchievementPercentageThisMonth(int userProfile) {
        return repository.getAchievementPercentageThisMonth(userProfile);
    }

    @Override
    public List<AthleteProgressResponse> getAllDailyMissions(int userProfileId) {
        LocalDate fromDate = LocalDate.now().minusDays(1);
        return repository.getDailyMissions(userProfileId, fromDate)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    protected JpaRepository<AthleteProgress, Integer> getRepository() {
        return repository;
    }
}
