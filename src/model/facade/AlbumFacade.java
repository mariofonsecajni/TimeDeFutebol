package model.facade;

import java.util.List;

import model.domain.Time;

public interface AlbumFacade {

	List<Time> getAlbums();

	List<Time> getAlbums(Integer codigo);

	Time salvar(Time album);

	void atualizar(Time album);

	void deletarAlbum(Integer codigo);

	
}