package com.bikkadit.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import com.bikkadit.dao.ContactDaoI;
//if we dont want to take print from database then we are try to Mocking 
//and we create a dummy name for Junit test
class ContactServiceImplTest {
    @Test
public void getNameByIdTest() {
		//we are depend on Dao mock
 ContactDaoI daoProxy = EasyMock.createMock(ContactDaoI.class);
 // EasyMock.expect(daoProxy.findNameById(101)).andReturn(null);// fail test
 EasyMock.expect(daoProxy.findNameById(101)).andReturn("krishna");
 EasyMock.expect(daoProxy.findNameById(102)).andReturn("bikkadit");
 EasyMock.replay(daoProxy);   //kisko uthana hai ye btaega Easy mopck k replay method kaam karega
    
    //creating obj and setting the dao
  ContactServiceImpl contactServiceImpl=new  ContactServiceImpl();
  contactServiceImpl.setContactDaoI(daoProxy);
    
    //calling Actual Method
   String name=contactServiceImpl.getNameById(102);//here if give those id which are not in above query the test fail
   System.out.println(name);                       //if above name any one null & if we call it then it wil be Test Failure
    	//Assert for checking the actual result,if null are presnt then it gives test fail due to null
    	//assertNotNull(name);
   //assertEquals("krishnak",name); //equals k barabr agar internal output aaega then test pass dega	
    assertEquals("KRISHNA",name); 	//expeted outpt:KRISHNA,Actual output:KRISHNA, so test pass
	}

}
