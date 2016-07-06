package myclass.bol;

public class borrowBook {
	private String readerID=null;
	private String bookID=null;
	private String borrowDate=null;
	private String returnDate=null;
	public borrowBook() {
		
	}
	public borrowBook(String readerID, String bookID, String borrowDate,
			String returnDate) {
		super();
		this.readerID = readerID;
		this.bookID = bookID;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	public String getReaderID() {
		return readerID;
	}
	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
		
}
