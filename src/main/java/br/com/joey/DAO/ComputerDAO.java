package br.com.joey.DAO;

import br.com.joey.DAO.generic.GenericDAO;
import br.com.joey.domain.Computer;

public class ComputerDAO extends GenericDAO<Computer, String> implements IComputerDAO{

	@Override
	public Class<Computer> getClazz() {
		return Computer.class;
	}
}
