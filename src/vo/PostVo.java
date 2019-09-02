package vo;

public class PostVo {
	
	private int postId;
	private String postName;
	private String depId;
	private String depName;
	public PostVo() {
		
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
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "PostVo [postId=" + postId + ", postName=" + postName + ", depId=" + depId + ", depName=" + depName
				+ "]";
	}
	
}
