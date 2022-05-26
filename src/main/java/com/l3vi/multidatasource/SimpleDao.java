package com.l3vi.multidatasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 996kid@gmail.com
 * @Description SimpleDao
 * @Date 2022/5/26 15:04
 */
@Component
public class SimpleDao extends JdbcDaoSupport {


    public SimpleDao (@Qualifier("customDataSource") DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Item> getItemsLow() {
        List<Item> result = getItemsHigh();
        System.out.println(result);
        DataSoutceContextHolder.setSourceName(SourceTypeEnum.LOW);
        String query = "select name, price from item_low";
        return getJdbcTemplate().query(query, new RowMapper<Item>() {
            public Item mapRow(ResultSet rs, int row) throws SQLException {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                return new Item(name, price);
            }
        });
    }

    private List<Item> getItemsHigh() {
        DataSoutceContextHolder.setSourceName(SourceTypeEnum.HIGH);
        String query = "select name, price from item_high";
        return getJdbcTemplate().query(query, new RowMapper<Item>() {
            public Item mapRow(ResultSet rs, int row) throws SQLException {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                return new Item(name, price);
            }
        });
    }

}
