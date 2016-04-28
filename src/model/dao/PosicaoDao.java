package model.dao;

import java.util.List;

import model.domain.Posicao;

public interface PosicaoDao {

	List<Posicao> getPosicoes(Posicao posicao);
	
	public void excluir(Posicao posicao);

	Posicao salvar(Posicao posicao);

	void atualizar(Posicao posicao);

}