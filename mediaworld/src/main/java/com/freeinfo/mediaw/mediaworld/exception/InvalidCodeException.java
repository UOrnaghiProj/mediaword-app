package com.freeinfo.mediaw.mediaworld.exception;


public class InvalidCodeException extends Exception {

	private static final long serialVersionUID = 9212859365878018696L;
	
	private String messaggio = "Codice prodotto non valido";
	
	public InvalidCodeException()
	{
		super();
	}
	
	public InvalidCodeException(String Messaggio)
	{
		super(Messaggio);
		this.messaggio = Messaggio;
	}

	public String getMessaggio()
	{
		return messaggio;
	}

	public void setMessaggio(String messaggio)
	{
		this.messaggio = messaggio;
	}

}
