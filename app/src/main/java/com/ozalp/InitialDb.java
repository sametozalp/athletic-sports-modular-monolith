package com.ozalp;

import com.ozalp.auth.business.services.AuthService;
import com.ozalp.auth.models.entities.Auth;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.organization.business.services.GymService;
import com.ozalp.organization.models.entities.Gym;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDb {

    private final AuthService authService;
    private final GymService gymService;

    public InitialDb(AuthService authService, GymService gymService) {
        this.authService = authService;
        this.gymService = gymService;
    }

    @Bean
    public ApplicationRunner initialAdmin() {
        return args -> {
            authService.createRootAdmin();

            // test
            // john
            Auth auth = new Auth();
            auth.setPassword("123456");
            auth.setUsername("john");
            auth.setEmail("john");
            UserProfile userProfile = new UserProfile();
            userProfile.setName("john");
            auth.setUserProfile(userProfile);
            authService.add(auth);

            gymService.add(new Gym(auth.getId(), "Siirt Spor Salonu", "", true));

            // samet
            Auth auth2 = new Auth();
            auth2.setPassword("123456");
            auth2.setUsername("samet");
            auth2.setEmail("samet");
            UserProfile userProfile2 = new UserProfile();
            userProfile2.setName("samet");
            auth2.setUserProfile(userProfile2);
            authService.add(auth2);

            // goktug
            Auth auth3 = new Auth();
            auth3.setPassword("123456");
            auth3.setUsername("goktug");
            auth3.setEmail("goktug");
            UserProfile userProfile3 = new UserProfile();
            userProfile3.setName("goktug");
            auth3.setUserProfile(userProfile3);
            authService.add(auth3);
        };
    }
}
