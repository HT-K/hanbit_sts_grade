package com.hanbit.web.global;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
	public static Command createCommand(String pkg,String crud,
			String pageNO,String keyField,String keyword,int count){
		Command command = new Command();
		if (crud.equals("list")) {
			command = new ListCommand(pkg,crud,pageNO,keyField,keyword,count);
		}
		return command;
	}
}
