package dao;


import java.util.List;

import mypack.cfusers;

public interface CfuserDAO 
{
	public cfusers checklogin(cfusers cfuser);
	public void saveuser(cfusers cfuser);
	public List<cfusers> getrevlist(String state);
}