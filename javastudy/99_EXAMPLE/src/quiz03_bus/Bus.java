package quiz03_bus;

public class Bus {
	
	private Seat[] seats;
	private int limit;

	public Bus(int cnt) {
		seats = new Seat[cnt];
		limit = cnt;
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	public void ride(int seatNo, Person person) {
		if(seatNo <= 0 || seatNo > limit) {
			return;
		}
		Seat seat = seats[seatNo - 1];
		Person p = seat.getPerson();
		if(p == null) {
			seat.setPerson(person);
		}
	}
		
		
		
	public void info() {
		for(int i = 0; i < limit; i++) {
			Seat seat = seats[i];
			Person person = seat.getPerson();
			if(person != null) {
				System.out.println((i + 1) + ", " + person.getName());
			} else {
				System.out.println((i + 1) + ", 비어있음");
			}
		
	}


	}
	
		
}
