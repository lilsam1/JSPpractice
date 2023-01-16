package product.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	// 데이터베이스 없이 샘플 데이터를 MAP 형태로 저장하고 전체 상품 목록과
	// 특정 상품의 정보를 컨트롤러에 제공하기 위한 서비스 클래스
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		// 생성자를 통해 MAP에 추가
		Product product = new Product("101","애플사과폰 12","애플전자",1200000,"2020.12.12");
		products.put("101", product);
		product = new Product("102","삼전우주폰 21","삼전전자",1300000,"2021.2.2");
		products.put("102", product);
		product = new Product("103","엘스듀얼폰","엘스전자",1500000,"2021.3.2");
		products.put("103", product);
	}
	
	public List<Product> findAll() {
		// MAP의 리스트 형태로 변환해서 리턴
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		// 인자로 받은 키값으로 상품을 검색해서 Product 객체를 반환
		return products.get(id);
	}
}
