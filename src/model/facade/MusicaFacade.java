package model.facade;

import java.util.List;

import model.domain.Musica;

public interface MusicaFacade {

	List<Musica> getMusicas();

	List<Musica> getMusicas(Integer codigo);

	Musica salvar(Musica musica);

	void atualizar(Musica musica);

	void deletarMusica(Integer codigo);

	
}