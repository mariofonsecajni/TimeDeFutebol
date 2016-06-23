package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Posicao;

public interface PosicaoFacade {

	List<Posicao> getPosicoes();

	List<Posicao> getPosicoes(Integer codigo);
	
	@ValidateOnExecution
	Posicao salvar(@Valid Posicao posicao);

	void atualizar(Posicao posicao);

	void deletarPosicao(Integer codigo);

	
}