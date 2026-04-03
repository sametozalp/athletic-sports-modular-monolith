package com.ozalp.training.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.training.business.services.AthleteProgressService;
import com.ozalp.training.models.enums.AthleteProgressStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.ATHLETE_PROGRESS)
@RequiredArgsConstructor
public class AthleteProgressController {

    private final AthleteProgressService athleteProgressService;

    @PatchMapping(ApiParams.Base.ID)
    ResponseEntity<?> updateStatus(@PathVariable int id, @RequestParam AthleteProgressStatus athleteProgressStatus) {
        athleteProgressService.updateStatus(id, athleteProgressStatus);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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
