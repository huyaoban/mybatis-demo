package com.huyaoban.mybatis3.domain.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.huyaoban.mybatis3.domain.PhoneNumber;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String column)
			throws SQLException {
		return new PhoneNumber(rs.getString(column));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber phone, JdbcType jdbcType) throws SQLException {
		ps.setString(i, phone.getAsString());
	}

}
