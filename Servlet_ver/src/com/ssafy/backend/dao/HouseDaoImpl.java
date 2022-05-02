package com.ssafy.backend.dao;

import java.sql.*;

import com.ssafy.backend.dto.HouseDto;
import com.ssafy.backend.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
	private DBUtil dbUtil = DBUtil.getInstance();
	private static HouseDaoImpl instance = new HouseDaoImpl();

	private HouseDaoImpl() {}

	public static HouseDaoImpl getInstance() {
		if (instance == null)
			instance = new HouseDaoImpl();
		return instance;
	}


	@Override
	public List<HouseDto> searchByDong(String dongCode, String memId) throws SQLException{
		List<HouseDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			
			String searchDongSQL = "SELECT no, hd.aptCode, hi.aptName, hi.buildYear, hd.dealAmount, hd.dealYear, hd.dealMonth,\r\n" + 
					"CASE WHEN no in (SELECT no FROM happyhouse.houseLike where memId = ?)\r\n" + 
					"THEN 'true'\r\n" + 
					"ELSE 'false'\r\n" + 
					"END\r\n" + 
					"from houseinfo hi RIGHT OUTER JOIN housedeal hd\r\n" + 
					"ON hd.aptCode = hi.aptCode\r\n" + 
					"where dongCode = ? ;";

//					"SELECT no, hd.aptCode, hi.aptName, hi.buildYear, hd.dealAmount, hd.dealYear, hd.dealMonth\r\n" + 
//					"from houseinfo hi RIGHT OUTER JOIN housedeal hd\r\n" + 
//					"ON hd.aptCode = hi.aptCode\r\n" + 
//					"where dongCode = ? and\r\n" + 
//					"not no in (SELECT no FROM happyhouse.houseLike where memId = ?)";
			pstmt = conn.prepareStatement(searchDongSQL);
			pstmt.setString(1, memId);
			pstmt.setString(2, dongCode);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				HouseDto dto = new HouseDto();
				dto.setAptNo(rst.getString(1));
				dto.setAptCode(rst.getInt(2));
				dto.setAptName(rst.getString(3));
				dto.setBuildYear(rst.getInt(4));
				dto.setDealAmount(rst.getString(5));
				dto.setDealYear(rst.getInt(6));
				dto.setDealMonth(rst.getInt(7));
				dto.setUserLiked(rst.getBoolean(8));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rst,pstmt, conn);
		}
		return list;
	}

	@Override
	public List<HouseDto> searchByApt(String aptName, String memId) throws SQLException{
		List<HouseDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			String searchAptSQL = "   SELECT no, hi.aptCode, aptName, buildYear, dealAmount, dealYear, dealMonth\r\n" + 
					"   from houseinfo hi RIGHT OUTER JOIN housedeal hd\r\n" + 
					"   ON hd.aptCode = hi.aptCode\r\n" + 
					"   where aptName like concat('%', ?,'%');";
			
			pstmt = conn.prepareStatement(searchAptSQL);
			pstmt.setString(1, aptName);
			rst = pstmt.executeQuery();

			while(rst.next()) {
				HouseDto dto = new HouseDto();
				dto.setAptNo(rst.getString(1));
				dto.setAptCode(rst.getInt(2));
				dto.setAptName(rst.getString(3));
				dto.setBuildYear(rst.getInt(4));
				dto.setDealAmount(rst.getString(5));
				dto.setDealYear(rst.getInt(6));
				dto.setDealMonth(rst.getInt(7));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rst,pstmt, conn);
		}
		
		return list;
	}

	@Override
	public int addFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			
			String searchFavoriteApt = "select count(*) from houseLike where no=? and memId = ? and aptCode= ?";
			String addFavoriteAptSQL = "insert into houseLike(no, memId, aptCode, addDate)\r\n" + 
					"values (?, ?, ?, now())";
			
			pstmt = conn.prepareStatement(searchFavoriteApt);
			pstmt.setString(1, aptNo);
			pstmt.setString(2, memId);
			pstmt.setString(3, aptCode);
			rst = pstmt.executeQuery();
			rst.next();
			if(rst.getInt(1) == 0) {
				pstmt = conn.prepareStatement(addFavoriteAptSQL);
				System.out.println(Integer.parseInt(aptCode)+" "+memId);
				pstmt.setString(1, aptNo);
				pstmt.setString(2, memId);
				pstmt.setString(3, aptCode);
				res = pstmt.executeUpdate();
			}else {
				res = 2;
			}
			
		} finally {
			dbUtil.close(rst,pstmt, conn);
		}
		return res;
	}

	@Override
	public List<HouseDto> inquireFavorite(String memId) throws SQLException {
		List<HouseDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			String inquireFavoriteSQL = "SELECT hl.no, hi.aptCode ,hi.aptName, hi.dongName, hi.buildYear, hd.dealAmount, hd.dealYear, hd.dealMonth\r\n" + 
					"FROM houseLike hl LEFT OUTER JOIN housedeal hd\r\n" + 
					"ON hd.no = hl.no\r\n" + 
					"LEFT OUTER JOIN houseinfo hi\r\n" + 
					"ON hd.aptCode = hi.aptCode\r\n" + 
					"WHERE memId = ?";
			
			pstmt = conn.prepareStatement(inquireFavoriteSQL);
			pstmt.setString(1, memId);
			rst = pstmt.executeQuery();

			while(rst.next()) {
				HouseDto dto = new HouseDto();
				dto.setAptNo(rst.getString(1));
				dto.setAptCode(rst.getInt(2));
				dto.setAptName(rst.getString(3));
				dto.setDongName(rst.getString(4));
				dto.setBuildYear(rst.getInt(5));
				dto.setDealAmount(rst.getString(6));
				dto.setDealYear(rst.getInt(7));
				dto.setDealMonth(rst.getInt(8));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rst,pstmt, conn);
		}
		
		return list;
	}

	@Override
	public int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			String deleteFavoriteAptSQL = "delete from houseLike\r\n" + 
					"where no = ? and memId = ? and aptCode = ?";
			
			pstmt = conn.prepareStatement(deleteFavoriteAptSQL);
			pstmt.setString(1, aptNo);
			pstmt.setString(2, memId);
			pstmt.setString(3, aptCode);
			res = pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(rst,pstmt, conn);
		}
		return res;
	}

}
