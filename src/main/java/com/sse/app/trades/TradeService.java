package com.sse.app.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.accounts.AccountDAO;
import com.sse.app.accounts.AccountDTO;

@Service
public class TradeService {

	@Autowired
	private TradeDAO tradeDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int trade(TradeDTO tradeDTO) throws Exception {

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBank_id(tradeDTO.getBank_id());
		accountDTO = accountDAO.detail(accountDTO);

		if (accountDTO.getBalance() >= tradeDTO.getDifference()) {

			tradeDTO.setDifference(tradeDTO.getDifference() * -1);
			int result = tradeDAO.add(tradeDTO);
			result = tradeDAO.update(tradeDTO);

			TradeDTO newtradeDTO = new TradeDTO();
			newtradeDTO.setBank_id(tradeDTO.getBank_id());
			tradeDTO.setDifference(tradeDTO.getDifference() * -1);
			tradeDTO.setBank_id(tradeDTO.getAccount_u());
			tradeDTO.setAccount_u(newtradeDTO.getBank_id());
			result = tradeDAO.add(tradeDTO);
			result = tradeDAO.update(tradeDTO);

			return result;
		} else {
			return 0;
		}

	}
}
