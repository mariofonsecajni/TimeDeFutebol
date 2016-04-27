package model.facade;

import java.util.List;

import model.domain.Posicao;

public interface ArtistaFacade {

	List<Posicao> getArtistas();

	List<Posicao> getArtistas(Integer codigo);

	Posicao salvar(Posicao artista);

	void atualizar(Posicao artista);

	void deletarArtista(Integer codigo);

	
}