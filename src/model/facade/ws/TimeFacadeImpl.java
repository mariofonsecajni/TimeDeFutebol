package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.TimeDao;
import model.domain.Time;
import model.facade.TimeFacade;

@WebService(serviceName="ws/time")
public class TimeFacadeImpl implements TimeFacade {
	
	@Inject
	private TimeDao timeDao;
			
	@WebMethod
	public List<Time> getTimes() {
		return timeDao.getTimes(new Time());
	}
	
	@Override
	@WebMethod(operationName="getTimeCodigo")
	public List<Time> getTimes(@WebParam(name="codigoTime") 
							Integer codigo) {
		Time time = new Time();
		time.setCodigo(codigo);
		return timeDao.getTimes(time);
	}
	
	@WebMethod
	public Time salvar(@WebParam(name="time") Time time) {
		return timeDao.salvar(time);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="time") Time time) {
		timeDao.atualizar(time);
	}
	
	@WebMethod
	public void deletarTime(@WebParam(name="codigoTime") Integer codigo) {
		Time time = new Time();
		time.setCodigo(codigo);
		timeDao.excluir(time);
	}

	

	



}
