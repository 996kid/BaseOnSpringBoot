package com.l3vi.multidatasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try {
            DataSourceStackContextHolder.push(SourceTypeEnum.LOW);
            String query = "select name, price from item_low";
            List<Item> r1 = getJdbcTemplate().query(query, (rs, row) -> {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                return new Item(name, price);
            });
            System.out.println(r1);
            List<Item> result = getItemsHigh();
            System.out.println(result);

            List<Item> r2 = getJdbcTemplate().query(query, (rs, row) -> {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                return new Item(name, price);
            });
            System.out.println(r2);
            return r2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceStackContextHolder.pop();
        }
        return null;
    }

    private List<Item> getItemsHigh() {
        try {
            DataSourceStackContextHolder.push(SourceTypeEnum.HIGH);
            String query = "select name, price from item_high";
            return getJdbcTemplate().query(query, (rs, row) -> {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                return new Item(name, price);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceStackContextHolder.pop();
        }
        return null;
    }

}
