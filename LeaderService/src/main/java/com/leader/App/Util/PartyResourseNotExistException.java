package com.leader.App.Util;

@SuppressWarnings("serial")
public class PartyResourseNotExistException extends RuntimeException{
	
	public PartyResourseNotExistException(String str) {
		super(str);
	}
}
