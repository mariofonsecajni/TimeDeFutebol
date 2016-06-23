package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Time;

public interface TimeFacade {

	List<Time> getTimes();

	List<Time> getTimes(Integer codigo);
	@ValidateOnExecution
	Time salvar(@Valid Time album);

	void atualizar(Time album);

	void deletarTime(Integer codigo);

	
}