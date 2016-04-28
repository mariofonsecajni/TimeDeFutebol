package model.dao;

import java.util.List;

import model.domain.Jogador;

public interface JogadorDao {

	List<Jogador> getJogadores(Jogador jogador);
	
	public void excluir(Jogador jogador);

	Jogador salvar(Jogador jogador);

	void atualizar(Jogador jogador);

}