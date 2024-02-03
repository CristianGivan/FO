package com.app.FO.service.snooze;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.snooze.Snooze;
import com.app.FO.model.snooze.SnoozeUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.snooze.SnoozeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SnoozeService {
    private SnoozeRepository snoozeRepository;

    private ServiceAll serviceAll;

    @Autowired
    public SnoozeService(SnoozeRepository snoozeRepository, ServiceAll serviceAll) {
        this.snoozeRepository = snoozeRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Snooze postSnooze(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySubject(logInUser.getId(), subject);
        if (snooze != null) {
            throw new SnoozeAlreadyExistException("Snooze with this subject already exist");
        }

        snooze = snoozeRepository.save(new Snooze(subject, logInUser));

        SnoozeUser snoozeUser = new SnoozeUser(snooze, logInUser);
        snooze.getSnoozeUserList().add(snoozeUser);

        return snoozeRepository.save(snooze);
    }

    //-- Put
    public Snooze putSubjectToSnooze(Long snoozeId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found in your list");
        }

        if (snooze.getSubject().equals(subject)) {
            throw new SnoozeAlreadyExistException("Snooze has already the same subject");
        }

        snooze.setSubject(subject);

        return snoozeRepository.save(snooze);
    }


    public Snooze putSnoozeTimeToSnooze(Long snoozeId, String snoozeTimeText) {
/*
Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
*/
        LocalTime snoozeTime = DateTime.textToLocalTime(snoozeTimeText);
        User logInUser = serviceAll.getLogInUser();

        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found in your list");
        }

        snooze.setSnoozeTime(snoozeTime);
        return snoozeRepository.save(snooze);
    }


    public Snooze putUserToSnooze(Long snoozeId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        SnoozeUser snoozeUser = serviceAll.getSnoozeUser(snoozeId, userId);
        if (snoozeUser != null) {
            throw new SnoozeUserAlreadyExistException("The snooze already has the user");
        }

        snoozeUser = new SnoozeUser(snooze, user);
        snooze.getSnoozeUserList().add(snoozeUser);

        return snoozeRepository.save(snooze);
    }

    //--Delete


    public Snooze deleteUserFromSnooze(Long snoozeId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        SnoozeUser snoozeUser = serviceAll.getSnoozeUser(snoozeId, userId);
        if (snoozeUser == null) {
            throw new SnoozeUserNotFoundException("The snooze don't has the user");
        }
        snooze.getSnoozeUserList().remove(snoozeUser);

        return snoozeRepository.save(snooze);
    }


    public List<Snooze> deleteSnooze(Long snoozeId) {
        User logInUser = serviceAll.getLogInUser();

        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("Snooze not found in your list");
        }
        snoozeRepository.delete(snooze);
        return getAllSnooze();
    }
    //-- GET


    public List<Snooze> getAllSnooze() {
        User logInUser = serviceAll.getLogInUser();
        List<Snooze> snoozeList = snoozeRepository.getSnoozeListFromUserId(logInUser.getId());
        if (snoozeList.isEmpty()) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snoozeList;
    }

    public Snooze getSnoozeBySnoozeId(Long snoozeId) {
        User logInUser = serviceAll.getLogInUser();
        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeId(logInUser.getId(), snoozeId);
        if (snooze == null) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snooze;
    }

    public Snooze getSnoozeBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySubject(logInUser.getId(), subject);
        if (snooze == null) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snooze;
    }

    public List<Snooze> getSnoozeListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Snooze> snoozeList = snoozeRepository.getSnoozeListBySubjectContains(logInUser.getId(), subjectContains);
        if (snoozeList.isEmpty()) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snoozeList;
    }


    public Snooze getSnoozeBySnoozeTime(String snoozeTimeText) {
        LocalTime snoozeTime = DateTime.textToLocalTime(snoozeTimeText);
        User logInUser = serviceAll.getLogInUser();
        Snooze snooze = snoozeRepository.getSnoozeFromUserIdBySnoozeTime(logInUser.getId(), snoozeTime);
        if (snooze == null) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snooze;
    }

    public List<Snooze> getSnoozeListBySnoozeTimeBetween(String snoozeTimeMinText, String snoozeTimeMaxText) {
        LocalTime snoozeTimeMin = DateTime.textToLocalTime(snoozeTimeMinText);
        LocalTime snoozeTimeMax = DateTime.textToLocalTime(snoozeTimeMaxText);
        User logInUser = serviceAll.getLogInUser();
        List<Snooze> snoozeList = snoozeRepository.getSnoozeListFromUserIdBySnoozeTimeBetween(logInUser.getId(), snoozeTimeMin, snoozeTimeMax);
        if (snoozeList.isEmpty()) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snoozeList;
    }


    public Snooze getSnoozeByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Snooze snooze = snoozeRepository.getSnoozeFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (snooze == null) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snooze;
    }

    public List<Snooze> getSnoozeListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Snooze> snoozeList = snoozeRepository.getSnoozeListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (snoozeList.isEmpty()) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snoozeList;
    }

    public List<Snooze> getSnoozeListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Snooze> snoozeList = snoozeRepository.getSnoozeListFromUserIdByUserId(logInUser.getId(), userId);
        if (snoozeList.isEmpty()) {
            throw new SnoozeNotFoundException("No snooze found");
        }
        return snoozeList;
    }


    //-- Other


}
