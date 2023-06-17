package com.app.FO.controller;

import com.app.FO.mapper.dto.snooze.SnoozeDTO;
import com.app.FO.mapper.mappers.SnoozeDTOMapper;
import com.app.FO.model.snooze.Snooze;
import com.app.FO.service.snooze.SnoozeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snooze")
public class SnoozeController {

    private SnoozeService snoozeService;
    private SnoozeDTOMapper snoozeDTOMapper;

    @Autowired
    public SnoozeController(SnoozeService snoozeService, SnoozeDTOMapper snoozeDTOMapper) {
        this.snoozeService = snoozeService;
        this.snoozeDTOMapper = snoozeDTOMapper;
    }


    //-- PostMapping

    @PostMapping("/postNewSnooze")
    public SnoozeDTO postNewSnooze(@RequestParam String subject) {
        Snooze snooze = snoozeService.postSnooze(subject);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);

    }


    //-- PutMapping
    @PutMapping("/putSubjectToSnooze")
    public SnoozeDTO putSubjectToSnooze(@RequestParam Long snoozeId, @RequestParam String subject) {
        Snooze snooze = snoozeService.putSubjectToSnooze(snoozeId, subject);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @PutMapping("/putSnoozeTimeToSnooze")
    public SnoozeDTO putSnoozeTimeToSnooze(@RequestParam Long snoozeId, @RequestParam String snoozeTimeTime) {
        Snooze snooze = snoozeService.putSnoozeTimeToSnooze(snoozeId, snoozeTimeTime);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @PutMapping("/putUserToSnooze")
    public SnoozeDTO putUserToSnooze(@RequestParam Long snoozeId, @RequestParam Long userId) {
        Snooze snooze = snoozeService.putUserToSnooze(snoozeId, userId);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromSnooze")
    public SnoozeDTO deleteUserFromSnooze(@RequestParam Long snoozeId, @RequestParam Long userId) {
        Snooze snooze = snoozeService.deleteUserFromSnooze(snoozeId, userId);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }


    @DeleteMapping("/deleteSnooze")
    public List<SnoozeDTO> deleteSnooze(@RequestParam Long snoozeId) {
        List<Snooze> snoozeList = snoozeService.deleteSnooze(snoozeId);
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }


    //---GetMapping

    @GetMapping("/getAllSnooze")
    public List<SnoozeDTO> getAllSnooze() {
        List<Snooze> snoozeList = snoozeService.getAllSnooze();
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }


    @GetMapping("/getSnoozeById")
    public SnoozeDTO getSnoozeById(@RequestParam Long snoozeId) {
        Snooze snooze = snoozeService.getSnoozeBySnoozeId(snoozeId);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @GetMapping("/getSnoozeBySubject")
    public SnoozeDTO getSnoozeBySubject(@RequestParam String subject) {
        Snooze snooze = snoozeService.getSnoozeBySubject(subject);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @GetMapping("/getSnoozeListBySubjectContains")
    public List<SnoozeDTO> getSnoozeListBySubjectContains(@RequestParam String subjectContain) {
        List<Snooze> snoozeList = snoozeService.getSnoozeListBySubjectContains(subjectContain);
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }

    @GetMapping("/getSnoozeBySnoozeTime")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public SnoozeDTO getSnoozeBySnoozeTime(@RequestParam String snoozeTime) {
        Snooze snooze = snoozeService.getSnoozeBySnoozeTime(snoozeTime);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @GetMapping("/getSnoozeListBySnoozeTimeBetween")
    public List<SnoozeDTO> getSnoozeListBySnoozeTimeBetween(@RequestParam String snoozeTimeTimeMin, @RequestParam String snoozeTimeTimeMax) {
        List<Snooze> snoozeList = snoozeService.getSnoozeListBySnoozeTimeBetween(snoozeTimeTimeMin, snoozeTimeTimeMax);
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }

    @GetMapping("/getSnoozeByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public SnoozeDTO getSnoozeByCreatedDate(@RequestParam String createdDate) {
        Snooze snooze = snoozeService.getSnoozeByCreatedDate(createdDate);
        return snoozeDTOMapper.snoozeToSnoozeDTO(snooze);
    }

    @GetMapping("/getSnoozeListByCreatedDateBetween")
    public List<SnoozeDTO> getSnoozeListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Snooze> snoozeList = snoozeService.getSnoozeListByCreatedDateBetween(createdDateMin, createdDateMax);
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }

    @GetMapping("/getSnoozeListByUserId")
    public List<SnoozeDTO> getSnoozeListByUserId(@RequestParam Long userId) {
        List<Snooze> snoozeList = snoozeService.getSnoozeListByUserId(userId);
        return snoozeDTOMapper.snoozeListToSnoozeDTOList(snoozeList);
    }

    //--- Other


}
