package model.facade;

import java.util.List;

import model.domain.Time;

public interface TimeFacade {

	List<Time> getTimes();

	List<Time> getTimes(Integer codigo);

	Time salvar(Time album);

	void atualizar(Time album);

	void deletarTime(Integer codigo);

	
}