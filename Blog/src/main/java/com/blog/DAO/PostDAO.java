package com.blog.DAO;

import java.util.List;

import com.blog.model.Post;

public interface PostDAO {
	public void deltePostById(int postId);
	public void updatePostById(int postId);
	public List<Post> search(String search);
	

}
