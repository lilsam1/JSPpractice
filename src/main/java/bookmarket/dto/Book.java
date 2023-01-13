package bookmarket.dto;

public class Book {
	private String booktid;		// 占쏙옙占쏙옙 占쏙옙占싱듸옙
	private String name;		// 占쏙옙占쏙옙占쏙옙
	private Integer unitPrice;	// 占쏙옙占쏙옙
	private String author;		// 占쏙옙占쏙옙
	private String description;	// 占쏙옙占쏙옙
	private String publisher;	// 占쏙옙占실삼옙
	private String category;	// 占싻뤄옙
	private long unitsinStock;	// 占쏙옙占� 占쏙옙
	private long totalPages;	// 占쏙옙占쏙옙占쏙옙 占쏙옙
	private String releaseDate;	// 占쏙옙占쏙옙占쏙옙(占쏙옙/占쏙옙)
	private String condition;	// 占신깍옙 占쏙옙占쏙옙 or 占쌩곤옙 占쏙옙占쏙옙 or E-Book
	private String filename;	// 占싱뱄옙占쏙옙 占쏙옙占싹몌옙
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Book() {
		super();
	}

	public Book(String booktid, String name, Integer unitPrice) {
		this.booktid = booktid;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getBooktid() {
		return booktid;
	}

	public void setBooktid(String booktid) {
		this.booktid = booktid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsinStock() {
		return unitsinStock;
	}

	public void setUnitsinStock(long unitsinStock) {
		this.unitsinStock = unitsinStock;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
