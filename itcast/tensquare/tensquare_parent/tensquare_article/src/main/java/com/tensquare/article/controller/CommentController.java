package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommentController
 * @Description
 * @Author xlf
 * @Date 2020/10/20 2:33
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private RedisTemplate redisTemplate;
	
	//PUT /comment/thumbup/{commentId} 根据评论id点赞评论
	@RequestMapping(value = "/thumbup/{commentId}", method = RequestMethod.PUT)
	public Result thunbup(@PathVariable String commentId) {
		//把用户点赞信息保存到redis中
		//每次点赞之前，先查询用户点赞信息 该条评论没有该用户点赞信息，可以点赞;否则不可以
		//模拟用户id
		String userId = "1234";
		//查询用户点赞信息，根据用户id和评论id
		Object flag = redisTemplate.opsForValue().get("thumbup_" + userId + "_" + commentId);
		//判断查询到的结果是否为空
		if (flag == null) {
			//表示该用户没有在该评论下点赞，可以点赞
			commentService.thumbup(commentId);
			//点赞成功，保存点赞信息
			redisTemplate.opsForValue().set("thumbup_" + userId + "_" + commentId, 1);
			return new Result(true, StatusCode.OK, "点赞成功");
		}
		//如果不为空，表示用户点过赞，不可以重复点赞
		return new Result(false, StatusCode.REPERROR, "不能重复点赞");
	}
	//GET /comment/article/{articleId} 根据文章id查询文章评论
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public Result findByArticleId(@PathVariable String articleId) {
		List<Comment> commentList = commentService.findByArticleId(articleId);
		return new Result(true, StatusCode.OK, "查询成功", commentList);
	}
	//GET /comment 查询所有评论
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		List<Comment> commentList = commentService.findAll();
		return new Result(true, StatusCode.OK, "查询所有评论成功", commentList);
	}
	//GET /comment/{commentId} 根据评论id查询评论数据
	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public Result findById(@PathVariable String commentId) {
		Comment comment = commentService.findById(commentId);
		return new Result(true, StatusCode.OK, "根据评论id查询评论数据成功", comment);
	}
	
	//POST /comment 新增评论
	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Comment comment) {
		commentService.save(comment);
		return new Result(true, StatusCode.OK, "新增评论成功");
	}
	//PUT /comment/{commentId} 修改评论
	@RequestMapping(value = "/{commentId}", method = RequestMethod.PUT)
	public Result updateById(@PathVariable String commentId,
							 @RequestBody Comment comment) {
		//设置评论主键
		comment.set_id(commentId);
		//执行修改
		commentService.updateById(comment);
		return new Result(true, StatusCode.OK, "修改成功");
	}
	//DELETE /comment/{commentId} 根据id删除评论
	@RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String commentId) {
		commentService.deleteById(commentId);
		return new Result(true, StatusCode.OK, "删除成功");
	}
}
