package com.leader.App.Util;

@SuppressWarnings("serial")
public class PartyIdandLeadIdNotExistException extends RuntimeException{
	
	public PartyIdandLeadIdNotExistException(String str) {
		super(str);
	}
}
