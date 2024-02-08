package factory;

import br.com.joey.domain.Computer;

public class EntitiesFactory {
	
	public EntitiesFactory() {}
	
	public Computer createComputerInstance(String code) {
		return new Computer(null, code, "Auto Description");
	}

}
