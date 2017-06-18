package controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import model.*;

public class SpendInfoManageController implements IInfoManage {
	/*记账处理系统*/
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
		double sum = 0;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String start = year + "-" + month + "-1 00:00:00";
		String end = year + "-" + (month+1) + "-1 00:00:00";
		for(int i = 0; i < infos.size(); i++){
			if((((SpendInfo)infos.get(i)).getCreateTime().getTime() < Timestamp.valueOf(end).getTime()) && (((SpendInfo)infos.get(i)).getCreateTime().getTime() >= Timestamp.valueOf(start).getTime())){
				if(((SpendInfo)infos.get(i)).getTitle().equals("支出")){
					sum -= ((SpendInfo)infos.get(i)).getMoney();
				}
				else if(((SpendInfo)infos.get(i)).getTitle().equals("收入")){
					sum += ((SpendInfo)infos.get(i)).getMoney();
				}
			}
		}
		result += sum + "元";
		return result;
	}
}
