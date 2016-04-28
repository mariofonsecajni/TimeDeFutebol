package model.dao;

import java.util.List;

import model.domain.Time;

public interface TimeDao {

	List<Time> getTimes(Time time);
	
	public void excluir(Time time);

	Time salvar(Time time);

	void atualizar(Time time);

}