package test.main;


import org.springframework.context.support.GenericXmlApplicationContext;

import com.webapp.board.dao.BoardDao;

public class DummyDataGenerator {
	
	static BoardDao dao;
	

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/dao.xml");
		ctx.refresh();
		
		dao = ctx.getBean(BoardDao.class);
		
		int num = 0;
		for (int i = 1 ; i <= 1000 ; i++) {
			num += 1;
			dao.insertDummyData("김구", "1234", "테스트" + num , "테스트 입니다.");
		}
		
		
		
		
		ctx.close();
	}

}
