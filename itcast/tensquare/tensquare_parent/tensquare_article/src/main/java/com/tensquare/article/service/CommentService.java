package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentRepository;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName CommentService
 * @Description
 * @Author xlf
 * @Date 2020/10/20 1:29
 **/
@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private IdWorker idWorker;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Comment> findAll() {
		List<Comment> commentList = commentRepository.findAll();
		return commentList;
	}
	
	public Comment findById(String commentId) {
		Optional<Comment> optional = commentRepository.findById(commentId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void save(Comment comment) {
		//分布式ID生成器
		comment.set_id(idWorker.nextId()+ "");
		//初始化数据
		comment.setThumbup(0);
		comment.setPublishdate(new Date());
		///保存数据
		commentRepository.save(comment);
	}
	
	public void updateById(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteById(String commentId) {
		commentRepository.deleteById(commentId);
	}
	
	public List<Comment> findByArticleId(String articleId) {
		//调用持久层，根据文章id查询
		List<Comment> commentList = commentRepository.findByArticleid(articleId);
		return commentList;
	}
	
	public void thumbup(String commentId) {
		// //根据评论id查询评论数据
		// Comment comment = commentRepository.findById(commentId).get();
		// //对评论点赞数据加一
		// comment.setThumbup(comment.getThumbup() + 1);
		// //保存修改数据
		// commentRepository.save(comment);
		
		//点赞功能优化
		//封装修改的条件
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(commentId));
		//封装修改的数值
		Update update = new Update();
		//使用inc列值增长
		update.inc("thumbup", 1);
		
		//直接修改数据
		//第一个参数是修改的条件
		//第二个参数是修改的数值
		//第三个参数是MongoDB的集合名称
		mongoTemplate.updateFirst(query, update, "comment");
	}
}
