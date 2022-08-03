package quiz07_song;

public class Singer {
	
	// 필드
	private String name;
	private Song[] songs;
	private int idx;
	
	// 생성자
	public Singer(String name, int cnt) {
		this.name = name;
		songs = new Song[cnt];
	}
	
	// 메소드
	public void addSong(Song song) {
		if(idx == songs.length) {
			return;
		}
		songs[idx++] = song;
	}

	public void info() {
		System.out.println("가수이름 " + name);
		System.out.println("대표곡");
		for(int i = 0; i < idx; i++) {
			System.out.println(songs[i]);
		}
	}
	
	
	
	
	
}
