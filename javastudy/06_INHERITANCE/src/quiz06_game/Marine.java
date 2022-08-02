package quiz06_game;

public class Marine extends GameUnit {

	// 생성자
	public Marine(String name) {
		super(name, 50, 5);
	}

	@Override
	public void attack(GameUnit unit) {

		// 내 에너지 : getEnergy(), this.getEnergy()
		// 내 공격력 : getPower(), this.getPower()
		// 내 이름   : getName(), this.getName()
		
		// 상대 에너지 : unit.getEnergy()
		// 상대 공격력 : unit.getEnergy()
		// 상대 이름   : unit.getEnergy()
		
		// 40% 확률로 KO 시킬 수 있다.
		if(Math.random() < 0.4) {
			unit.setEnergy(0);
			unit.setAlive(false); 	// 죽여줘야 한다.
			System.out.println(unit.getName() + "를 한 방에 죽였다.");
		} else {
			int unitEnergy = unit.getEnergy() - getPower() < 0 ? 0 : unit.getEnergy() - getPower();
			// unitEnergy상대편 에너지
			unit.setEnergy(unitEnergy);
			unit.setAlive(unitEnergy > 0);
			System.out.println(unit.getName() + "의 남은 에너지 " + unit.getEnergy());
		}

		
	}
	

}
