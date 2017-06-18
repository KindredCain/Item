package controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomController {
	/*随机点名系统类*/
	Date date = new Date();
	Random random = new Random(date.getTime());
	public String randomNum(int start, int end) throws Exception{
		if(start > end)
			throw new Exception("起始学号大于结束学号");
		else{
			String result = "";
			int length = end - start + 1;
			result = "" + (random.nextInt(length) + start);
			return result;
		}
	}

	public String randomMatter(List<String> matters){
		String result = "";
		int num = random.nextInt(matters.size());
		result = matters.get(num);
		return result;
	}
}