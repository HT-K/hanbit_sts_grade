package com.hanbit.web.member;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml",
		"classpath:META-INF/*-context.xml"})
public class MemberControllerTest {
	/*@Mock
    private IInvoiceDao invoiceDaoMock;*/
	
    @InjectMocks
    @Autowired
    private MemberService service;
     
     
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
