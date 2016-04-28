package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.PosicaoDao;
import model.domain.Posicao;
import model.facade.PosicaoFacade;

@WebService(serviceName="ws/posicao")
public class PosicaoFacadeImpl implements PosicaoFacade {
	
	@Inject
	private PosicaoDao posicaoDao;
			
	@WebMethod
	public List<Posicao> getPosicoes() {
		return posicaoDao.getPosicoes(new Posicao());
	}
	
	@Override
	@WebMethod(operationName="getPosicaoCodigo")
	public List<Posicao> getPosicoes(@WebParam(name="codigoPosicao") 
							Integer codigo) {
		Posicao posicao = new Posicao();
		posicao.setCodigo(codigo);
		return posicaoDao.getPosicoes(posicao);
	}
	
	@WebMethod
	public Posicao salvar(@WebParam(name="posicao") Posicao posicao) {
		return posicaoDao.salvar(posicao);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="posicao") Posicao posicao) {
		posicaoDao.atualizar(posicao);
	}
	
	@WebMethod
	public void deletarPosicao(@WebParam(name="codigoPosicao") Integer codigo) {
		Posicao posicao = new Posicao();
		posicao.setCodigo(codigo);
		posicaoDao.excluir(posicao);
	}

	

	



}
