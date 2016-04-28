package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.PosicaoDao;
import model.domain.Posicao;
import model.facade.PosicaoFacade;

@Path("/posicao")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PosicaoFacadeImpl implements PosicaoFacade {

	@Inject
	private PosicaoDao posicaoDao;
	
	
	@Override
	@GET
	public List<Posicao> getPosicoes() {
		return posicaoDao.getPosicoes(new Posicao());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Posicao> getPosicoes(@PathParam("codigo") Integer codigo) {
		Posicao posicao = new Posicao();
		posicao.setCodigo(codigo);
		return posicaoDao.getPosicoes(posicao);
	}
	
	
	@Override
	@POST 
	public Posicao salvar(Posicao posicao) { 
		posicao = posicaoDao.salvar(posicao);
	 	return posicao;
	}
	
	@Override
	@PUT 
	public void atualizar(Posicao posicao) { 
		posicaoDao.atualizar(posicao);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarPosicao(@PathParam("codigo") Integer codigo) {
		Posicao posicao = new Posicao();
		posicao.setCodigo(codigo);
		posicaoDao.excluir(posicao);
	}

}
