package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Comments;
import kz.projectestimate.repository.CommentsRepository;


@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	public List<Comments> getCommentsList() {
		return commentsRepository.findAll();
	}

	public Comments getCommentsById(Integer id) {
		return commentsRepository.findById(id).get();
	}

	public void saveOrUpdateComments(Comments сomments) {
		commentsRepository.save(сomments);
	}
	
	public void deleteComments(Integer id) {
		commentsRepository.deleteById(id);
	}

	public Comments getCommentsbyName(String name) {
		return commentsRepository.findByName(name);
	}

}
