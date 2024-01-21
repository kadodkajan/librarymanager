package library.model;

import java.util.ArrayList;
import java.util.List;

enum MemberType {
    GUEST, REGISTERED
}

public class Member {
    private String name;
    private List<Book> borrowedBooks;
    private MemberType memberType;

    // Constructor for GUEST
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.memberType = MemberType.GUEST; // Default to GUEST
    }

    // Constructor For REGISTERED members
    public Member(MemberType memberType, String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.memberType = memberType;
    }


    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public MemberType getMemberType() {
        return memberType;
    }
}
