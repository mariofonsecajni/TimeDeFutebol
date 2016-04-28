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

import model.dao.TimeDao;
import model.domain.Time;
import model.facade.TimeFacade;

@Path("/time")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TimeFacadeImpl implements TimeFacade {

	@Inject
	private TimeDao timeDao;
	
	
	@Override
	@GET
	public List<Time> getTimes() {
		return timeDao.getTimes(new Time());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Time> getTimes(@PathParam("codigo") Integer codigo) {
		Time time = new Time();
		time.setCodigo(codigo);
		return timeDao.getTimes(time);
	}
	
	
	@Override
	@POST 
	public Time salvar(Time time) { 
		time = timeDao.salvar(time);
	 	return time;
	}
	
	@Override
	@PUT 
	public void atualizar(Time time) { 
		timeDao.atualizar(time);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarTime(@PathParam("codigo") Integer codigo) {
		Time time = new Time();
		time.setCodigo(codigo);
		timeDao.excluir(time);
	}

}
