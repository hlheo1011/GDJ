package prac1;

public class Watch {
	
	int hour;
	int minute;
	int second;

	Watch (int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	
	void addHour(int hour) {
		System.out.println(hour + "시간 후");
	}
	
	void addMinute(int hour) {
		System.out.println(hour + "분 후(" + hour / 60 + "시간 " + hour % 60 + "분)");
	}
	
	void addSecond(int hour) {
		System.out.println(hour + "초 후(" + hour / 3600 + "시간 " + hour % 60 + "분 " + hour % 3660 + "초)");
	}
	
	

		
	void see() {
		System.out.println();
	}
	

}
