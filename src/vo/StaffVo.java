package vo;

public class StaffVo {
	private int staffId;
	private String staffName;
	private String gender;
	private String onDutyDate;
	private String postName;
	private String depName;
	
	public String getDepName() {
		return depName;
	}


	public void setDepName(String depName) {
		this.depName = depName;
	}


	public StaffVo() {
		
	}
	

	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getOnDutyDate() {
		return onDutyDate;
	}

	public void setOnDutyDate(String postId) {
		this.onDutyDate = postId;
		
	}
	

	@Override
	public String toString() {
		return "\n StaffVo [staffId=" + staffId + ",  staffName=" + staffName + ", gender="
				+ gender + ", onDutyDate=" + onDutyDate + ", postName=" + postName + "]";
	}
	
}
