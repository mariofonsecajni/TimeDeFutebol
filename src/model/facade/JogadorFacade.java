package model.facade;

import java.util.List;

import model.domain.Jogador;

public interface JogadorFacade {

	List<Jogador> getJogadores();

	List<Jogador> getJogadores(Integer codigo);

	Jogador salvar(Jogador jogador);

	void atualizar(Jogador jogador);

	void deletarJogador(Integer codigo);

	
}