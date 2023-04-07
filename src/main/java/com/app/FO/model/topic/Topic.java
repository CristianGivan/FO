package com.app.FO.model.topic;

import com.app.FO.model.event.EventTopic;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
@Getter
@Setter
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq")
    @SequenceGenerator(name = "topic_seq",
            sequenceName = "topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicTag> topicTagList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "topic")
    private List<TopicUser> usersTopicList;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "topic")
    private List<TopicHistory> topicHistoryList;

    @OneToMany(mappedBy = "topic")
    private List<Remainder> remainderList;

    @OneToMany(mappedBy = "topic")
    private List<EventTopic> eventTopicList;

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", topicNotes=" + topicNoteList +
                ", topicTags=" + topicTagList +
                ", userId=" + creator.getId() +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistoryList +
                ", remainders=" + remainderList +
                ", eventTopics=" + eventTopicList +
                '}';
    }

    //todo tnu
    public Topic(String subject, User user, LocalDateTime createdDate) {
        this.subject = subject;
        this.creator = user;
        this.createdDate = createdDate;
    }
    public Topic(String subject, User user) {
        this.subject = subject;
        this.creator = user;
        this.createdDate = LocalDateTime.now();
    }

    public List<TopicNote> getTopicNoteList() {
        if(topicNoteList ==null){
            topicNoteList =new ArrayList<>();
        }
        return topicNoteList;
    }

    public List<TopicTag> getTopicTagList() {
        if (topicTagList ==null){
            topicTagList =new ArrayList<>();
        }
        return topicTagList;
    }

    public List<TopicUser> getUsersTopicList() {
        if (usersTopicList ==null){
            usersTopicList =new ArrayList<>();
        }
        return usersTopicList;
    }

    public List<TopicHistory> getTopicHistoryList() {
        if (topicHistoryList ==null){
            topicHistoryList =new ArrayList<>();
        }
        return topicHistoryList;
    }
}
