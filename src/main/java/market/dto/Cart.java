package market.dto;

public class Cart {
	private int cartId;	//
	private String memberId; 	// 회원 아이디
	private String orderNo;		// 주문 번호
	private String p_id; 		// 상품아이디
	private String p_name;		// 상품이름
	private int p_unitPrice;	//가격
	private int cnt;			// 수량
	
	
	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getP_unitPrice() {
		return p_unitPrice;
	}

	public void setP_unitPrice(int p_unitPrice) {
		this.p_unitPrice = p_unitPrice;
	}

	
}
