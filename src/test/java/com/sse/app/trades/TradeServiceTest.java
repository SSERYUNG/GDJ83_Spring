package com.sse.app.trades;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sse.app.DefaultTest;

public class TradeServiceTest extends DefaultTest {

	@Autowired
	private TradeService tradeService;

	@Test
	public  transferTest() throws Exception {
		tradeService.trade();

		System.out.println("종료");
	}

}
