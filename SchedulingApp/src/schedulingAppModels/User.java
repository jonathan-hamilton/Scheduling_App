package schedulingAppModels;

public class User {
	private int userId;
	private String userName;
	private String password;
	private int active;
	private String createBy;
	private Object createDate; //need to make into temporal object type
	private Object lastUpdate; //need to make into temporal object type
	private String lastUpdatedBy;
	
	public int getUserID(){return 1;}
	public void setUserID(){}
	
	public String getUserName(){return null;}
	public void setUserName(){}
	
	public String getPassword(){return null;}
	public void setPassword(){}
	
	public int getActive(){return 1;}
	public void setActive(){}
	
	public String getCreatedBy(){return null;}
	public void setCreatedBy(){}
	
	public Object getCreateDate(){return null;}
	public void setCreateDate(){}
	
	public Object getLastUpdate(){return null;}
	public void setLastUpdate(){}
	
	public String getLastUpdateBy(){return null;}
	public void setLastUpdateBy(){}
}
