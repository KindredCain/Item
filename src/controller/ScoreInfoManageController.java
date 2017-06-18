package controller;

import java.util.List;

import model.*;

public class ScoreInfoManageController implements IInfoManage {
	/*成绩统计处理系统*/
	@Override
	public void create(List<Info> infos, Info info) {
		// TODO Auto-generated method stub
		infos.add(info);
	}

	@Override
	public void update(List<Info> infos, int i, Info info) {
		// TODO Auto-generated method stub
		infos.set(i, info);
	}

	@Override
	public void delete(List<Info> infos, int i) {
		// TODO Auto-generated method stub
		infos.remove(i);
	}

	public String remind (List<Info> infos){
		String result = "";
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		for(int i = 0; i < infos.size(); i++){
			if(((ScoreInfo)infos.get(i)).getScore() < 60){
				d += ((ScoreInfo)infos.get(i)).getCredit();
			}
			else{
				if(((ScoreInfo)infos.get(i)).getTitle().equals("必修")){
					a += ((ScoreInfo)infos.get(i)).getCredit();
				}
				else if(((ScoreInfo)infos.get(i)).getTitle().equals("限选")){
					b += ((ScoreInfo)infos.get(i)).getCredit();
				}
				else if(((ScoreInfo)infos.get(i)).getTitle().equals("公选")){
					c += ((ScoreInfo)infos.get(i)).getCredit();
				}
			}
		}
		result += "总修学分：" + (a+b+c+d) + "分，必修：" + a + "分，限选：" + b + "分，公选：" + c + "分，未过：" + d + "分。";
		return result;
	}
}
