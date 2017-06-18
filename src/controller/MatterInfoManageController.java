package controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import model.*;

public class MatterInfoManageController implements IInfoManage {
	/*记事本处理系统*/
	@Override
	public void create(List<Info> infos, Info info) {
		// TODO Auto-generated method stub
		infos.add(info);
		this.sort(infos);
	}

	@Override
	public void update(List<Info> infos, int i, Info info) {
		// TODO Auto-generated method stub
		infos.set(i, info);
		this.sort(infos);
	}

	@Override
	public void delete(List<Info> infos, int i) {
		// TODO Auto-generated method stub
		infos.remove(i);
		this.sort(infos);
	}

	public List<Info> sort (List<Info> infos){
		Collections.sort(infos, new Comparator<Info>(){
			public int compare(Info arg0, Info arg1) {
				return ((MatterInfo)arg0).getRemindTime().compareTo(((MatterInfo)arg1).getRemindTime());
			}
		});
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		while(((MatterInfo)infos.get(0)).getRemindTime().getTime() < now.getTime()){
			infos.remove(0);
		}
		return infos;
	}
	
	public String remind (List<Info> infos){
		String result = "";
		result += ((MatterInfo)infos.get(0)).getTitle();
		result += "记录将在";
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		long time = ((MatterInfo)infos.get(0)).getRemindTime().getTime() - now.getTime();
		time = time / 1000 / 60;
		int hour = (int) time / 60;
		int min = (int) time % 60;
		result += hour + "小时" + min + "分钟";
		return result;
	}
}
