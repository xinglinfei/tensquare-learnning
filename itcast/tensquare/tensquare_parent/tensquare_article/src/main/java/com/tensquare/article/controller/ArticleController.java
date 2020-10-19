package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleController
 * @Description
 * @Author xlf
 * @Date 2020/10/19 17:04
 **/
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private PaginationInterceptor paginationInterceptor;
	
	//分页查询
	@RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
	//之前接受文章数据，使用pojo，但是现在根据条件查询
	//而所有的条件都需要进行判断，遍历pojo的所有属性需要使用反射的方式，成本较高，性能较低
	//直接使用集合的方式遍历，这里接受数据改为Map集合
	public Result findByPage(@PathVariable Integer page,
							 @PathVariable Integer size,
							 @RequestBody Map<String, Object> map) {
		//根据条件分页查询
		Page<Article> pageData = articleService.findByPage(map , page, size);
		//封装分页返回对象
		PageResult<Article> pageResult = new PageResult<>(pageData.getTotal(), pageData.getRecords());
		//返回数据
		return new Result(true, StatusCode.OK, "查询成功", pageResult);
	}
	//条件查询
	
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		List<Article> list = articleService.findAll();
		return new Result(true, StatusCode.OK, "查询成功", list);
	}
	
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public Result findById(@PathVariable String articleId) {
		Article article = articleService.findById(articleId);
		return new Result(true, StatusCode.OK, "查询成功", article);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Article article) {
		articleService.save(article);
		return new Result(true, StatusCode.OK, "新增成功");
	}
	
	@RequestMapping(value = "{articleId}", method = RequestMethod.PUT)
	public Result updateById(@PathVariable String articleId,
							 @RequestBody Article article) {
		//设置ID
		article.setId(articleId);
		//执行修改
		articleService.updateById(article);
		return new Result(true, StatusCode.OK, "修改成功");
	}
	
	@RequestMapping(value = "{articleId}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String articleId) {
		articleService.deleteById(articleId);
		return new Result(true, StatusCode.OK, "删除成功");
	}
}
