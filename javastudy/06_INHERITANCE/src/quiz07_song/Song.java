package quiz07_song;

public class Song {
	
	// 필드
	private String titel;
	private double playTime;
	
	// 생성자
	public Song(String titel, double playTime) {
		this.titel = titel;
		this.playTime = playTime;
	}

	@Override
	public String toString() {
		return "Song [titel=" + titel + ", playTime=" + playTime + "]";
	}
	
	

}
