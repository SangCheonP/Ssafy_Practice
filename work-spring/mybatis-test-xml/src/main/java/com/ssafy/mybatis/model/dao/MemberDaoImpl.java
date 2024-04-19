package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.config.SqlMapConfig;
import com.ssafy.mybatis.model.MemberDto;

public class MemberDaoImpl implements MemberDao {
	
	private final String NAME_SPACE = "com.ssafy.mybatis.model.dao.MemberDao.";
	
	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try(SqlSession session = SqlMapConfig.getSqlSession()){
			session.insert(NAME_SPACE + "joinMember", memberDto);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("join중 실패");
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try(SqlSession session = SqlMapConfig.getSqlSession()){
			List<MemberDto> list = session.selectList(NAME_SPACE + "listMember");
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("join중 실패");
		}
		return null;
	}

}
