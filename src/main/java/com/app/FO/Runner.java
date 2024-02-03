package com.app.FO;


import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.service.user.RoleService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Runner implements CommandLineRunner {


    private UserService userService;
    private RoleService roleService;
    private UserRepository userRepository;

    @Autowired
    public Runner(UserService userService, RoleService roleService, UserRepository userRepository) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
//        dbUsers();

    }

    public void dbUsers() {
        User user1;
        User user2;
        User user3;
        Role admin;
        Role standard;

        if (roleService.findRoleByType(RoleType.ROLE_ADMIN) == null) {
            admin = roleService.saveRole(new Role(RoleType.ROLE_ADMIN));
        } else {
            admin = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        }

        if (roleService.findRoleByType(RoleType.ROLE_STANDARD) == null) {
            standard = roleService.saveRole(new Role(RoleType.ROLE_STANDARD));
        } else {
            standard = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }
        // Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTY5ODA2NjYyNH0.tZag2BFxFCLg7eIPcQHA7OO4RnFf4LXSlDUH5y0DAjMuORF17Wyfx0Pam62p79FTMC5u7bJkH5XaowsEB3u6gg
        // Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTY5Njg4MTg3NX0.fBU-cMbgrvQMJeI2FQ4rbLQkVQBNX5OlycIJ04F8msQWsC-LfB7gq_UddQIIIy1K5DvgEg1uyOnw8OHYPGw0yA
        if (userService.getUserByUserId(1L) == null) {
            user1 = new User("User1",
                    "$2a$12$sJZ7/SZpCOTSeMg1jos87ulm.OcN31uQKnYisY/5r5XlNXSoQKPRi");//pas1
            UserRole userRole1 = new UserRole(user1, admin);
            UserRole userRole2 = new UserRole(user1, standard);
            user1.getUserRoleList().add(userRole1);
            user1.getUserRoleList().add(userRole2);
            userRepository.save(user1);
        }
        // Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMiIsImV4cCI6MTY5ODA2NjY5OH0.yDS-I7a1e-nPz7jgFtjJ6RcB_y_LisgcsojwmYpCq6RsT5X8APNQT5cZn6iYYN1W7kMQI5eJuZUtyEGlZ4z3Fg
        if (userService.getUserByUserId(2L) == null) {
            user2 = new User("User2",
                    "$2a$12$gaUsXx4r4JlzHYXomu/XguBgQZbj2XXOWq5h683u7KCOPUozoRy56");//pas2
            UserRole userRole2 = new UserRole(user2, standard);
            user2.getUserRoleList().add(userRole2);
            userRepository.save(user2);

        }
        //Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY5ODA2NjgxNn0.W7Jer3Al5x5Me2DxmuM-l89dvQDs7yYTYsg0XCCGSRKGhT8kQyb7WaIvIiPTrFYGpGLZDDmFqviP0sMhrlX8XA
        if (userService.getUserByUserId(3L) == null) {
            user3 = new User("User3",
                    "$2a$12$b/jcMc9LC8sTk.8mV6Mzv.0GFCqgD7O/oK6m96nojFVKuGj8LlJv2");//pas3
            UserRole userRole1 = new UserRole(user3, admin);
            user3.getUserRoleList().add(userRole1);
            userRepository.save(user3);
        }
    }
}