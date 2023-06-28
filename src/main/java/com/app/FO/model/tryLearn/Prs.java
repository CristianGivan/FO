package com.app.FO.model.tryLearn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prs")
public class Prs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prs_seq")
    @SequenceGenerator(name = "prs_seq",
            sequenceName = "prs_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "prs_id")
    private Long id;

    @Column(name = "prs")
    private String prs;
    @OneToMany(mappedBy = "prs", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PrsPrs> prsTo;
    @OneToMany(mappedBy = "relatedPrs", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PrsPrs> prsPrsList;

    //    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following")
//    private List<Prs> followers = new ArrayList<>();
//    @JoinTable(name = "prs_followers",
//            joinColumns = {@JoinColumn(name = "prs_id")},
//            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Prs> following = new ArrayList<>();


    public Prs() {
    }

    public Prs(String prs) {
        this.prs = prs;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrs() {
        return prs;
    }

    public void setPrs(String prs) {
        this.prs = prs;
    }

    public List<PrsPrs> getPrsPrsList() {
        return prsPrsList;
    }

    public void setPrsPrsList(List<PrsPrs> prsPrsList) {
        this.prsPrsList = prsPrsList;
    }

    public List<PrsPrs> getPrsTo() {
        return prsTo;
    }

    public void setPrsTo(List<PrsPrs> prsTo) {
        this.prsTo = prsTo;
    }
//    public List<Prs> getFollowers() {
//        return followers;
//    }
//
//    public void setFollowers(List<Prs> followers) {
//        this.followers = followers;
//    }

//    public List<Prs> getFollowing() {
//        return following;
//    }
//
//    public void setFollowing(List<Prs> following) {
//        this.following = following;
//    }
}
