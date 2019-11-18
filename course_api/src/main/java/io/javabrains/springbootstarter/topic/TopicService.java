package io.javabrains.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("0","Spring Boot","Course of scpring boot framework"),
            new Topic("1","Asp .Net MVC","Microsoft Solution for web develpment"),
            new Topic("2","Java Server Faces","Control Long and intranet apps"),
            new Topic("3","React","Build React apps")
    ));

    List<Topic> getAllTopics(){
        return topics;
    }

    Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    void addTopic(Topic topic) {
        topics.add(topic);
    }

    void updateTopic(String id, Topic topic) {
        for(int i = 0; i < topics.size(); i ++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
