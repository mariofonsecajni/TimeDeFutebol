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

import model.dao.JogadorDao;
import model.domain.Jogador;
import model.facade.JogadorFacade;

@Path("/jogador")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class JogadorFacadeImpl implements JogadorFacade {

	@Inject
	private JogadorDao jogadorDao;
	
	
	@Override
	@GET
	public List<Jogador> getJogadores() {
		return jogadorDao.getJogadores(new Jogador());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Jogador> getJogadores(@PathParam("codigo") Integer codigo) {
		Jogador jogador = new Jogador();
		jogador.setCodigo(codigo);
		return jogadorDao.getJogadores(jogador);
	}
	
	
	@Override
	@POST 
	public Jogador salvar(Jogador jogador) { 
		jogador = jogadorDao.salvar(jogador);
	 	return jogador;
	}
	
	@Override
	@PUT 
	public void atualizar(Jogador jogador) { 
		jogadorDao.atualizar(jogador);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarJogador(@PathParam("codigo") Integer codigo) {
		Jogador jogador = new Jogador();
		jogador.setCodigo(codigo);
		jogadorDao.excluir(jogador);
	}

}
