package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.ProjectRepository;
import com.app.model.Projects;

@Service
public class ProjectService {
@Autowired
private ProjectRepository rep1;

public Projects addUser(Projects unit) {
	
	return rep1.save(unit);
	
}

public boolean UserExists(int id){
	List<Projects> count= rep1.findById1(id);
	
	if(!(count.isEmpty())) {
		
		return true;
	}else {
		return false;
	}
	
}

public List<Projects> getAllUsers() {
	
	return rep1.findAll();
}

public void delete(int id) {
	rep1.deleteById(id);

}
 
    public Projects editUser(Projects s) {
    	
        return rep1.saveAndFlush(s);
    }

public Projects getById(int id) {
    return rep1.findById(id);
}
public List<Projects> getById1(int id) {
    return rep1.findById1(id);
}
public List<Projects> getallProjectsBybuId(int id) {
	List<Projects> projects=new ArrayList<>();
	rep1.findbyBusinessUnitId(id).forEach(projects::add);
	return projects;
}
public boolean getallProjectsBybuIdExists(int id){
	List<Projects> count= rep1.findbyBusinessUnitId(id);
	
	if(!(count.isEmpty())) {
		
		return true;
	}else {
		return false;
	}
	
}


public List<Projects> getBybIdandid(int bid,int id) {
    return rep1.findBybIdandid(bid, id);
}
public boolean getBybIdandidExists(int bid,int id){
	List<Projects> count= rep1.findBybIdandid(bid, id);
	
	if(!(count.isEmpty())) {
		
		return true;
	}else {
		return false;
	}
	
}
public boolean getAllExists(){
	List<Projects> count= rep1.findAll();
	
	if(!(count.isEmpty())) {
		
		return true;
	}else {
		return false;
	}
	
}
}
