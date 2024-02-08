package DaoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.joey.DAO.ComputerDAO;
import br.com.joey.DAO.IComputerDAO;
import br.com.joey.domain.Computer;
import factory.EntitiesFactory;

public class ComputerDAOTest {
	
	private EntitiesFactory entityFactory = new EntitiesFactory();
	private Computer computer;
	private IComputerDAO computerDAO;
	
	public ComputerDAOTest() {
		computerDAO = new ComputerDAO();
	}
	
	@Before
	public void setUp() {
		List<Computer> computerList = computerDAO.selectAll();
		for (Computer computer : computerList) {
			computerDAO.delete(computer.getId());
		}
		computer = entityFactory.createComputerInstance("CPT01");
	}
	
	@After
	public void end() {
		List<Computer> computerList = computerDAO.selectAll();
		for (Computer computer : computerList) {
			computerDAO.delete(computer.getId());
		}
	}
	
	@Test
	public void insertTest() {
		computer = entityFactory.createComputerInstance("CPT01");
		Computer computerDB = computerDAO.insert(computer);
		assertNotNull(computerDB);
		assertNotNull(computerDB.getId());
		assertEquals(computer, computerDB);
	}
	

}
