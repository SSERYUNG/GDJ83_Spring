package com.sse.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sse.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "add", accountDTO);

	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}

//	public int transfer(AccountInfoDTO accountInfoDTO) throws Exception {
//
//		int num1 = sqlSession.insert(NAMESPACE + "transfer", accountInfoDTO);
//		int num2 = sqlSession.update(NAMESPACE + "resultyou", accountInfoDTO);
//		int num3 = sqlSession.update(NAMESPACE + "resultmy", accountInfoDTO);
//		int num4 = sqlSession.insert(NAMESPACE + "transfer2", accountInfoDTO);
//
//		return num1 + num2 + num3 + num4;
//	}

	public AccountInfoDTO password(AccountInfoDTO accountInfoDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "password", accountInfoDTO);
	}
}