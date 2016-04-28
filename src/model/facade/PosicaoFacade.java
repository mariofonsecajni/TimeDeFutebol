package model.facade;

import java.util.List;

import model.domain.Posicao;

public interface PosicaoFacade {

	List<Posicao> getPosicoes();

	List<Posicao> getPosicoes(Integer codigo);

	Posicao salvar(Posicao posicao);

	void atualizar(Posicao posicao);

	void deletarPosicao(Integer codigo);

	
}