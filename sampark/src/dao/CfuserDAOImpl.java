package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import mypack.cfusers;
@Component
public class CfuserDAOImpl implements CfuserDAO{

	@Autowired
	private HibernateTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public cfusers checklogin(cfusers cfuser) {
		String username=cfuser.getUser_name();
		String pass=cfuser.getPass();
		List<cfusers> list=new ArrayList<cfusers>();  
		list=template.find("from cfusers k where k.user_name=? and k.pass=?",username,pass);
	//	list=template.loadAll(Employee.class);
		cfusers ref=list.get(0);
		return ref; 
	}

	@Override
	public void saveuser(cfusers cfuser) {
		// TODO Auto-generated method stub
		template.save(cfuser);
	}

	@Override
	public List<cfusers> getrevlist(String state) {
		List<cfusers> list=new ArrayList<cfusers>();  
		list=template.find("from cfusers m where m.authority='reviewer' and m.state=?",state);
		return list; 
	}

}