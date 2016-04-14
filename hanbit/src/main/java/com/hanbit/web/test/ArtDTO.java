package com.hanbit.web.test;

import com.hanbit.web.global.Constants;

public class ArtDTO {
	String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	public String writeForm(){
		return this.getContext()+Constants.ID+"/writeForm";
	}
	
}
