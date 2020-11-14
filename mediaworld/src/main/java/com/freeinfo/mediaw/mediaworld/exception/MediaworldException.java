package com.freeinfo.mediaw.mediaworld.exception;


public class MediaworldException extends Exception {

	private static final long serialVersionUID = -9187786877211486250L;
	
	private String messaggio = "Errore proveniente dai servizi Mediaworld";
	
	public MediaworldException()
	{
		super();
	}
	
	public MediaworldException(String Messaggio)
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
