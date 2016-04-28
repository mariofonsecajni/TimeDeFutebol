package model.dao;

import java.util.List;

import model.domain.Posicao;

public interface PosicaoDao {

	List<Posicao> getArtistas(Posicao artista);
	
	public void excluir(Posicao artista);

	Posicao salvar(Posicao artista);

	void atualizar(Posicao artista);

}