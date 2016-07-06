package myclass.dal;

import java.util.Date;
import java.text.SimpleDateFormat;

public class timeDal {
//生成当前日期
	public String getNowtime(){
		String time="";
		 Date dt=new Date();
	     SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		time=matter1.format(dt);
		return time;
	}
}
