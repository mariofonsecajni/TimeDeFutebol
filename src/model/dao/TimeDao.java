package model.dao;

import java.util.List;

import model.domain.Time;

public interface TimeDao {

	List<Time> getAlbums(Time album);
	
	public void excluir(Time album);

	Time salvar(Time album);

	void atualizar(Time album);

}