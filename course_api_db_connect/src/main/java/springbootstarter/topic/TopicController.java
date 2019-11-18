package springbootstarter.topic;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TopicController {

    private final
    TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    //default page
    @RequestMapping("/")
    public String homeTopic(){
        return "Welcome, to Topics home.";
    }

    //list all the topics
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    //get a topic
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    //add a new topic
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
    //edit a topic
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic){
        topicService.updateTopic(id, topic);
    }
    //delete a topic
    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
