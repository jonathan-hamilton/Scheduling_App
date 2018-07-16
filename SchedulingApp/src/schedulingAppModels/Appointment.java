package schedulingAppModels;

public class Appointment {
	private int appointmentId;
	private int customerId;
	private String title;
	private String description;
	private String location;
	private String contact;
	private String url;
	private Object start; //need to make into temporal object type
	private Object end; //need to make into temporal object type
	private Object createDate; //need to make into temporal object type
	private String createdBy;
	private Object lastUpdate; //need to make into temporal object type
	private String lastUpdateBy;
}
