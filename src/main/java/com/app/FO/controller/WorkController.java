package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.work.WorkDTO;
import com.app.FO.mapper.mappers.WorkDTOMapper;
import com.app.FO.model.work.Work;
import com.app.FO.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

    private WorkService workService;

    private WorkDTOMapper workDTOMapper;

    @Autowired
    public WorkController(WorkService workService, WorkDTOMapper workDTOMapper) {
        this.workService = workService;
        this.workDTOMapper = workDTOMapper;
    }


    //-- PostMapping

    @PostMapping("/postWork")
    public WorkDTO postWork(@RequestBody TextDTO workText) {
        Work work = workService.postWork(workText.getText());
        return workDTOMapper.workToWorkDTO(work);
    }

    //-- PutMapping


    //-- DeleteMapping


    //-- GetMapping


    //--- Other
}
