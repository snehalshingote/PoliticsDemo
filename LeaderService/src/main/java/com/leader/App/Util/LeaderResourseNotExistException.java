package com.leader.App.Util;

@SuppressWarnings("serial")
public class LeaderResourseNotExistException extends RuntimeException{
	
	public LeaderResourseNotExistException(String str) {
		super(str);
	}

}
