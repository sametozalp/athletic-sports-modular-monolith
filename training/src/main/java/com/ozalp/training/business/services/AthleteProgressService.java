package com.ozalp.training.business.services;

import com.ozalp.core.services.BaseService;
import com.ozalp.training.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.enums.AthleteProgressStatus;

import java.util.List;

public interface AthleteProgressService extends BaseService<AthleteProgress> {

    AthleteProgressResponse create(CreateAthleteProgressRequest request);

    int getTotalPointThisMonth(int userProfileId);

    int getAchievementPercentageThisMonth(int userProfile);

    List<AthleteProgressResponse> getAllDailyMissions(int userProfileId);

    void updateStatus(int id, AthleteProgressStatus athleteProgressStatus);
}
