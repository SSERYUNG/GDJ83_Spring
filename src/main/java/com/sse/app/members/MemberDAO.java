package com.sse.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sse.app.members.MemberDAO.";

	public int join(MemberDTO memberDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "join", memberDTO);

	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
	}

	public int update(MemberDTO memberDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "update", memberDTO);

	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", memberDTO);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", memberDTO);
	}

	public int joinFile(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "joinFile", memberFileDTO);
	}

	public MemberDTO search(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "search", memberDTO);
	}

}
