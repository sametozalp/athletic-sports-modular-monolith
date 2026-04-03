package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.AthleteProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AthleteProgressRepository extends JpaRepository<AthleteProgress, Integer> {

    @Query("""
                select coalesce(sum(ap.points), 0)
                from AthleteProgress ap
                where ap.status = com.ozalp.training.models.enums.AthleteProgressStatus.COMPLETED
                  and ap.trainingProgramItem.trainingProgram.athleteUserProfileId = :userProfileId
                  and ap.trainingProgramItem.trainingProgram.athleteUserProfileId = :userProfileId
                  and ap.createdAt >= :#{T(java.time.Instant).now().minus(30, T(java.time.temporal.ChronoUnit).DAYS)}
            """)
    int getTotalPointThisMonth(int userProfileId);

    @Query("""
                SELECT CAST(
                    CASE 
                        WHEN COUNT(ap) = 0 THEN 0
                        ELSE (SUM(
                            CASE 
                                WHEN ap.status = com.ozalp.training.models.enums.AthleteProgressStatus.COMPLETED 
                                THEN 1.0 ELSE 0.0 
                            END
                        ) * 100.0 / COUNT(ap))
                    END
                AS int)
                FROM AthleteProgress ap
                WHERE ap.createdAt >= :#{T(java.time.Instant).now().minus(30, T(java.time.temporal.ChronoUnit).DAYS)}
            """)
    int getAchievementPercentageThisMonth(int userProfile);

    @Query("""
            select ap from AthleteProgress ap
            where ap.trainingProgramItem.trainingProgram.athleteUserProfileId = :userProfileId
            and ap.trainingProgramItem.date >= :fromDate
            """)
    List<AthleteProgress> getDailyMissions(int userProfileId, LocalDate fromDate);
}
