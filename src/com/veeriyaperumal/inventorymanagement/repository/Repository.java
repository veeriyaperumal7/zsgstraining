package com.veeriyaperumal.inventorymanagement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.veeriyaperumal.inventorymanagement.dto.Product;
import com.veeriyaperumal.inventorymanagement.model.JdbcConnection;

public class Repository {
	private String query;
	private static Repository repository;
	private ArrayList<Product> productList;

	private Repository() {
		productList = new ArrayList<>();
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public boolean addProduct(Product product) {
		int rowsAffected = 0;
		query = "insert into product_info (product_name, product_unit, product_price, product_status) values('"
				+ product.getProductName().replace("'", "''") + "','" + product.getUnit().replace("'", "''") + "','"
				+ product.getPrice() + "','ONLINE')";

		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		return (rowsAffected >= 1) ? true : false;
	}

	public ArrayList<Product> getProductList() {
		productList.clear();
		query = "SELECT * FROM product_info WHERE  product_status='ONLINE' order by product_id";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		if (result == null) {
			productList = null;
		} else {
			try {
				while (result.next()) {
					Product product = new Product();
					product.setId(result.getInt("product_id"));
					product.setPrice(result.getFloat("product_price"));
					product.setProductName(result.getString("product_name"));
					product.setUnit(result.getString("product_unit"));
					productList.add(product);
				}
			} catch (SQLException e) {
				productList = null;
				JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting productList", query);
				e.printStackTrace();
			} finally {
				JdbcConnection.getInstance().closeSQLConnection();
			}
		}
		return productList;
	}

	public ArrayList<Product> getProductStockList() {
		productList.clear();
		query = "SELECT * FROM product_stock WHERE  stock_status='ONLINE' order by product_id";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		if (result == null) {
			productList = null;
		} else {
			try {
				while (result.next()) {
					Product product = new Product();
					product.setId(result.getInt("product_id"));
					product.setPrice(result.getFloat("product_price"));
					product.setProductName(result.getString("product_name"));
					product.setUnit(result.getString("product_unit"));
					product.setQuantity(result.getInt("product_price"));
					productList.add(product);
				}
			} catch (SQLException e) {
				productList = null;
				JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting productList", query);
				e.printStackTrace();
			} finally {
				JdbcConnection.getInstance().closeSQLConnection();
			}
		}
		return productList;
	}

}
