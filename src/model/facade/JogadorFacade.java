package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Jogador;

public interface JogadorFacade {

	List<Jogador> getJogadores();

	List<Jogador> getJogadores(Integer codigo);
	
	@ValidateOnExecution
	Jogador salvar(@Valid Jogador jogador);

	void atualizar(Jogador jogador);

	void deletarJogador(Integer codigo);

	
}