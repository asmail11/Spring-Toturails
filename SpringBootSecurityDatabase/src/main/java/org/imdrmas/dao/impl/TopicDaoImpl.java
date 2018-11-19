package org.imdrmas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.imdrmas.dao.TopicDao;
import org.imdrmas.entities.Topic;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDaoImpl implements TopicDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		String HQL = "FROM Topic as t ORDER BY t.topicID";
		return (List<Topic>) entityManager.createQuery(HQL).getResultList();
	}

	@Override
	public Topic getTopicById(int topicId) {
		return entityManager.find(Topic.class, topicId);
	}

	@Override
	public void addTopic(Topic topic) {
		entityManager.persist(topic);
		
	}

	@Override
	public void updateTopic(Topic topic) {
		Topic topicFromDb = getTopicById(topic.getTopicId());
		if (topicFromDb != null) {
			topicFromDb.setTitle(topic.getTitle());
			topicFromDb.setCategory(topic.getCategory());
			entityManager.flush();
		} else {
			System.out.println("Topic doesn't exist which you want update.");
		}
	}

	@Override
	public void deleteTopic(int topicId) {
		Topic topic = getTopicById(topicId);
		if (topic != null) {
			entityManager.remove(topic);
		}else {
			System.out.println("Topic doesn't exits which you want delete.");
		}
		
	}

	@Override
	public boolean TopicExists(String title, String category) {
		String hql = "FROM TOPIC as t WHERE t.title =? AND t.category =?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
				.setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}

}
