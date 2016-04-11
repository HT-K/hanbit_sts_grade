package com.hanbit.web.global;

import java.util.List;


public class ListCommand extends Command{
	public ListCommand(String pkg,String command, String strPageNO,
			String keyField, String keyword, int count) {
		super(pkg, command, strPageNO, keyField, keyword, count);
	}
}
