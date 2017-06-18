package controller;

import java.util.List;

import model.Info;

public interface IInfoManage {
	public void create (List<Info> infos, Info info);
	public void update (List<Info> infos, int i, Info info);
	public void delete (List<Info> infos, int i);
}
