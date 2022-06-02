package kz.projectestimate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kz.projectestimate.entity.Comments;
import kz.projectestimate.service.CommentsService;


@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class CommentsRestController {

	@Autowired
	private CommentsService commentsService;

	@GetMapping("/commentsList")
	public ResponseEntity<List<Comments>> getCommentsList() {
		return new ResponseEntity<List<Comments>>(commentsService.getCommentsList(), HttpStatus.OK);
	}

	@GetMapping("/comments/id/{id}")
	public ResponseEntity<Comments> getComments(@PathVariable Integer id) {
		return new ResponseEntity<Comments>(commentsService.getCommentsById(id), HttpStatus.OK);
	}

	@PostMapping("/comments/save")
	public ResponseEntity<Void> saveOrUpdateComments(@RequestBody Comments comments) {
		commentsService.saveOrUpdateComments(comments);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/comments/delete/{id}")
	public ResponseEntity<Void> deleteComments(@PathVariable Integer id) {
		commentsService.deleteComments(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/comments/{name}")
	public ResponseEntity<Comments> getCommentsbySubsection(@PathVariable String name) {
		return new ResponseEntity<Comments>(commentsService.getCommentsbyName(name), HttpStatus.OK);
	}
	
}
