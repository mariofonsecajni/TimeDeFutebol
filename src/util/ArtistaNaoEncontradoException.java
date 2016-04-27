package util;

public class ArtistaNaoEncontradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArtistaNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
