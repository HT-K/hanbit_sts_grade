/**
 * 
 */
package com.hanbit.web.member;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hanbit.web.mapper.MemberMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @author Administrator
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {MyServiceInjectingMocksTest.MemberServiceTestConfig.class, MyAppConfig.class})
public class MemberServiceImplTest {
	private MemberService memberService;
	private MemberMapper memberMapper;
	private MemberDTO member;

    @Before
    public void setupMock() {
    	memberService = new MemberServiceImpl();
    	member = mock(MemberDTO.class);
    	memberMapper = mock(MemberMapper.class);
    }
    @Test
    public void testMockCreation(){
        assertNotNull(member);
    }
	@Test
	public void testJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		// fail("Not yet implemented");
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCount() {
		fail("Not yet implemented");
	}
	static class MemberServiceTestConfig{
        /**
         * @Primary indicates Spring to use this bean in priority to the one that is component-scanned
         */
        @Bean
        @Primary
        public MemberService getHelloService(){
            return mock(MemberService.class);
        }
    }
}
