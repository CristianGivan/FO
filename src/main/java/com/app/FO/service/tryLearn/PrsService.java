package com.app.FO.service.tryLearn;


import com.app.FO.config.ServiceAll;
import com.app.FO.model.tryLearn.Prs;
import com.app.FO.model.tryLearn.PrsPrs;
import com.app.FO.repository.tryLearn.PrsPrsRepository;
import com.app.FO.repository.tryLearn.PrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrsService {
    private PrsRepository prsRepository;

    private ServiceAll serviceAll;

    @Autowired
    private PrsPrsRepository prsPrsRepository;

    @Autowired
    public PrsService(PrsRepository prsRepository, ServiceAll serviceAll) {
        this.prsRepository = prsRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Prs postPrs(String prsText) {

        Prs prs = new Prs(prsText);

        return prsRepository.save(prs);
    }

    //-- Put

    public Prs putPrsToPrs(Long prsId, Long prsRelId) {
        Prs prs = prsRepository.getPrsByPrsId(prsId);
        Prs prsRel = prsRepository.getPrsByPrsId(prsRelId);

        PrsPrs prsPrs = new PrsPrs(prs, prsRel);
        prs.getPrsPrsList().add(prsPrs);

//        prs.getFollowers().add(prsRel);
//        prs.getFollowing().add(prsRel);
        return prsRepository.save(prs);
    }

    //--Delete


    public Prs deletePrsFromPrs(Long prsId, Long relatedPrsId) {


        Prs prs = new Prs("test");
        return prs;
    }

    public List<Prs> deletePrs(Long prsId) {

        List<Prs> prsList = new ArrayList<>();
        Prs prs = new Prs("test");
        prsList.add(prs);
        prsRepository.delete(prsRepository.getPrsByPrsId(prsId));
        return prsList;
    }
    //-- GET

    public List<Prs> getPrsListByPrsId(Long prsId) {

        return prsRepository.getPrsListByPrsId(prsId);
    }

    //-- Other


}
