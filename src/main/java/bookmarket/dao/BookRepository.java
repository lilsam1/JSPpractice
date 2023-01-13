package bookmarket.dao;

import java.util.ArrayList;

import bookmarket.dto.Book;

public class BookRepository {
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	private static BookRepository instance = new BookRepository();	//
	
	public static BookRepository getInstance() {	//
		return instance;
	}
	
	public BookRepository() {
		Book history = new Book("B1111", "占쏙옙, 占쏙옙, 占쏙옙", 11000);
		history.setAuthor("占쏙옙占쏙옙占쏙옙 占쏙옙占싱아몌옙占�");
		history.setCategory("占쏙옙회占쏙옙占쏙옙");
		history.setDescription("占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 1占쏙옙 占쏙옙占쏙옙 : 占쏙옙占쏙옙占쏙옙 占쌩댐옙占쏙옙 占승울옙占싹댐옙 占십쇽옙占쏙옙奴占� 占쏙옙占쏙옙 占실뱄옙占쌍댐옙 占쏙옙占쏙옙");
		history.setPublisher("占쏙옙占싻삼옙占�");
		history.setTotalPages(752);
		history.setUnitsinStock(100);
		history.setReleaseDate("2018/03/07");
		history.setCondition("占신규듸옙占쏙옙");
		history.setFilename("B1111.jpg");
		
		Book novel = new Book("B1112", "占쌔몌옙占쏙옙占싶울옙 占쏙옙占쏙옙 占쏙옙", 35000);
		novel.setAuthor("j.k.占싼몌옙");
		novel.setCategory("占쌀쇽옙");
		novel.setDescription("占쌔몌옙占쏙옙占쏙옙 占시몌옙占쏙옙占쏙옙 占쏙옙 占쏙옙째 占쏙옙");
		novel.setPublisher("占쏙옙占싻쇽옙첩");
		novel.setTotalPages(1200);
		novel.setUnitsinStock(120);
		novel.setReleaseDate("2017/03/07");
		novel.setCondition("占쌩곤옙占쏙옙");
		novel.setFilename("B1112.jpg");
		
		Book it = new Book("B1113", "占쌘뱄옙占쏙옙 占쏙옙占쏙옙", 22000);
		it.setAuthor("占쏙옙占시쇽옙");
		it.setCategory("IT");
		it.setDescription("占쌘듸옙占쏙옙 처占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쌉뱄옙占쏙옙");
		it.setPublisher("占쏙옙占쏙옙占쏙옙占쏙옙");
		it.setTotalPages(300);
		it.setUnitsinStock(50);
		it.setReleaseDate("2020/03/07");
		it.setCondition("e-book");
		it.setFilename("B1113.jpg");
		
		listOfBooks.add(history);
		listOfBooks.add(novel);
		listOfBooks.add(it);
	}
	
	public ArrayList<Book> getAllProducts() {
		return listOfBooks;
	}
	
	public Book getBookById(String booktId) {
		Book bookById = null;
		
		for (int i =  0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (book != null && book.getBooktid() != null && book.getBooktid().equals(booktId)) {
				bookById = book;
				break;
			}
		}
		return bookById;
	}
	
	public void addBook(Book book) {	//
		listOfBooks.add(book);
	}
	
}
