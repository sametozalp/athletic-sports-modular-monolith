package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.training.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training.business.services.AthleteProgressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.ATHLETE_PROGRESS)
@RequiredArgsConstructor
public class AthleteProgressController {

    private final AthleteProgressService athleteProgressService;

    @PostMapping(ApiParams.Base.ID)
    ResponseEntity<?> create(@RequestBody @Valid CreateAthleteProgressRequest request) {
        return ResponseEntity.ok(athleteProgressService.create(request));
    }

    @GetMapping(ApiParams.Base.USER_ID + ApiParams.AthleteProgress.DAILY_MISSIONS)
    ResponseEntity<?> getAllDailyMissions(@PathVariable int userId) {
        return ResponseEntity.ok(athleteProgressService.getAllDailyMissions(userId));
    }

    @GetMapping(ApiParams.Base.USER_ID + ApiParams.AthleteProgress.TOTAL_POINT_THIS_MONTH)
    ResponseEntity<?> getTotalPointThisMonth(@PathVariable int userId) {
        return ResponseEntity.ok(athleteProgressService.getTotalPointThisMonth(userId));
    }

    @GetMapping(ApiParams.Base.USER_ID + ApiParams.AthleteProgress.ACHIEVEMENT_PERCENTAGE_THIS_MONTH)
    ResponseEntity<?> getAchievementPercentageThisMonth(@PathVariable int userId) {
        return ResponseEntity.ok(athleteProgressService.getAchievementPercentageThisMonth(userId));
    }
}
