package com.app.FO.controller;


import com.app.FO.model.tryLearn.Prs;
import com.app.FO.service.tryLearn.PrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("prs")
public class PrsController {
    private PrsService prsService;


    @Autowired
    public PrsController(PrsService prsService) {
        this.prsService = prsService;
    }

    //-- PostMapping

    @PostMapping("/postNewPrs")
    public Prs postNewPrs(@RequestParam String nickName) {
        return prsService.postPrs(nickName);
    }


    //-- PutMapping


    @PutMapping("/putPrsToPrs")
    public Prs putPrsToPrs(@RequestParam Long prsId, @RequestParam Long relatedPrsId) {
        return prsService.putPrsToPrs(prsId, relatedPrsId);
    }

    //-- DeleteMapping


    @DeleteMapping("/deletePrsFromPrs")
    public Prs deletePrsFromPrs(@RequestParam Long prsId, @RequestParam Long relatedPrsId) {
        return prsService.deletePrsFromPrs(prsId, relatedPrsId);
    }


    @DeleteMapping("/deletePrs")
    public List<Prs> deletePrs(@RequestParam Long prsId) {
        return prsService.deletePrs(prsId);
    }


    //---GetMapping


    @GetMapping("/getPrsListByPrsId")
    public List<Prs> getPrsListByPrsId(@RequestParam Long prsId) {
        return prsService.getPrsListByPrsId(prsId);
    }
    //--- Other


}
