package model.dao;

import java.util.List;

import model.domain.Musica;

public interface MusicaDao {

	List<Musica> getMusicas(Musica musica);
	
	public void excluir(Musica musica);

	Musica salvar(Musica musica);

	void atualizar(Musica musica);

}