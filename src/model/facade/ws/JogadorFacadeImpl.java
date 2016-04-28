package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.JogadorDao;
import model.domain.Jogador;
import model.facade.JogadorFacade;

@WebService(serviceName="ws/jogador")
public class JogadorFacadeImpl implements JogadorFacade {
	
	@Inject
	private JogadorDao jogadorDao;
			
	@WebMethod
	public List<Jogador> getJogadores() {
		return jogadorDao.getJogadores(new Jogador());
	}
	
	@Override
	@WebMethod(operationName="getJogadorCodigo")
	public List<Jogador> getJogadores(@WebParam(name="codigoJogador") 
							Integer codigo) {
		Jogador jogador = new Jogador();
		jogador.setCodigo(codigo);
		return jogadorDao.getJogadores(jogador);
	}
	
	@WebMethod
	public Jogador salvar(@WebParam(name="jogador") Jogador jogador) {
		return jogadorDao.salvar(jogador);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="jogador") Jogador jogador) {
		jogadorDao.atualizar(jogador);
	}
	
	@WebMethod
	public void deletarJogador(@WebParam(name="codigoJogador") Integer codigo) {
		Jogador jogador = new Jogador();
		jogador.setCodigo(codigo);
		jogadorDao.excluir(jogador);
	}

	

	



}
