package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Topic;

public interface TopicDao {
  public abstract List<Topic> getAllTopics();
  public abstract Topic getTopicById(int topicId);
  public abstract void addTopic(Topic topic);
  public abstract void updateTopic(Topic topic);
  public abstract void deleteTopic(int topicId);
  public abstract boolean TopicExists(String title, String category);
}
