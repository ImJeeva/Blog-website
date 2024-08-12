package com.blog.model;

import java.sql.Date;

public class Post {
	private int postId;
	private int userId;
	private String title;
	private String content;
	private Date updatedAt;
	private String imagePath;
	private String videoPath;
	
	public Post() {
		
	}

	public Post(int postId, int userId, String title, String content, Date updatedAt, String imagePath,
			String videoPath) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.updatedAt = updatedAt;
		this.imagePath = imagePath;
		this.videoPath = videoPath;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	public String toString() {
		return postId+" "+userId+" "+title+" "+content+" "+updatedAt+" "+imagePath+" "+videoPath;
	}
	

}
