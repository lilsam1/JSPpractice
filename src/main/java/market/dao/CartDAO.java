package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import market.dto.Cart;
import market.dto.Product;
import mvc.database.DBconnection;


public class CartDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	void connect() {
		try {
			connection = DBconnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CartDAO() {
		connect();
	}
	
	public boolean updateCart(Product product, String orderNo, String memberId) {
		// ������ �ֹ���ȣ�� ���� productId�� ������ update, ������ insert
		int flag = 0;
		String productId = product.getProductId();
		String sql = "select cartId from cart where orderNo = ? and productId = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int cartId = resultSet.getInt("cartId");
				sql = "UPDATE cart SET cnt = cnt + 1 WHERE cartId = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartId);
				flag = preparedStatement.executeUpdate();
			}
			else {
				sql = "INSERT INTO cart VALUES (null, ?, ?, ?, ?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, memberId);
				preparedStatement.setString(2, orderNo);
				preparedStatement.setString(3, productId);
				preparedStatement.setString(4, product.getPname());
				preparedStatement.setInt(5, product.getUnitPrice());
				preparedStatement.setInt(6, 1);
				flag = preparedStatement.executeUpdate();
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return flag == 1;
	} 
	
	public ArrayList<Cart> getCartList(String orderNo) {
		ArrayList<Cart> cartArrayList = new ArrayList<>();
		String sql = "SELECT * FROM cart WHERE orderNo = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setCartId(resultSet.getInt("cartId"));
				cart.setP_id(resultSet.getString("productId"));
				cart.setP_name(resultSet.getString("p_name"));
				cart.setP_unitPrice(resultSet.getInt("p_unitPrice"));
				cart.setCnt(resultSet.getInt("cnt"));
				cartArrayList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartArrayList;
	}
	
	public boolean updateCartBylogin(HttpSession session) {
		int flag = 0;
		String orderNo = session.getId();
		String id = (String)session.getAttribute("sessionId");
		// ���� �α��ο� ���� ��ǰ ������Ʈ
		String sql = "UPDATE cart SET orderNo = ? WHERE memberId = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderNo);
			preparedStatement.setString(2, id);
			flag = preparedStatement.executeUpdate();
			
			// �α��� ���� ���� ��ǰ ������Ʈ
			sql = "UPDATE cart SET memberId = ? WHERE orderNo = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, orderNo);
			flag = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag !=0;
	}
	
	public boolean deleteCartById(String orderNo, int cartId) throws SQLException {
		// ��ٱ��� ���� ����
		int flag = 0;
		String sql = "SELECT * FROM cart WHERE orderNo = ? AND cartId = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		preparedStatement.setInt(2, cartId);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			sql = "DELETE FROM cart WHERE cartId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartId);
			flag = preparedStatement.executeUpdate();
		}
		return flag == 1;
	}

	
	public boolean deleteCart(String orderNo) throws SQLException {
		// ��ٱ��� ��ü ����
		int flag = 0;
		String sql = "DELETE FROM cart WHERE orderNo = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		flag = preparedStatement.executeUpdate();
		return flag != 0;

	}
	
	public boolean deleteCartBySelId(String orderNo, String chkdId) throws SQLException {
		int flag = 0;
		String sql = "DELETE FROM cart WHRE orderNo = '" + orderNo + "' AND cartId IN (" + chkdId + ") ";
		statement = connection.createStatement();
		flag = statement.executeUpdate(sql);
		return flag != 0;
	}

}
