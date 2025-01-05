package fitness;



public class Program {

	private String title;
	private String duration;
	private String level;
	private String goals;
	private String videoPath;
	private String imagePath;
	private String documentPath;
	private String price;
	private String sessionType;
	private String sessionDay;
	private String sessionTime;

	public Program(String title, String duration, String level, String goals, String videoPath,
			String imagePath, String documentPath, String price, String sessionType, String sessionDay, String sessionTime) {
		this.title=title;
		this.duration=duration;
		this.level=level;
		this.goals=goals;
		this.videoPath=videoPath;
		this.imagePath=imagePath;
		this.documentPath=documentPath;
		this.price=price;
		this.sessionType=sessionType;
		this.sessionDay=sessionDay;
		this.sessionTime=sessionTime;
		
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getDuration() {
		
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLevel() {
		
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}


	public String getGoals() {
		
		return goals;
	}
	
	public void setGoals(String goals) {
		this.goals = goals;
	}


	public String getVedioPath() {
		
		return videoPath;
	}
	public void setVedioPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getImagePath() {
	
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDocumentPath() {
		
		return documentPath;
	}
	
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public String getPrice() {
		
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getSessionType() {
		
		return sessionType;
	}
	
	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}
	
	public String getSessionDay() {
		
		return sessionDay;
	}
	
	public void setSessionDay(String sessionDay) {
		this.sessionDay = sessionDay;
	}
	
	public String getSessionTime() {
		
		return sessionTime;
	}
	
	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}
	
	
 
}
