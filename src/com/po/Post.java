package com.po;

public class Post {
	
	private int postId;
	private String postName;
	private String depId;
	public Post() {
		
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName + ", depId=" + depId + "]";
	}
	
}
