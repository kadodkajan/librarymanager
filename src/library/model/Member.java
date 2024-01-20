package library.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

enum MemberType {
    GUEST, REGISTERED
}

class Member {
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
class GuestMember extends Member {
    public GuestMember(String name) {
        super(name);
    }
}

class RegisteredMember extends Member {
    private int memberID;
    private LocalDate membershipDate;
    private LocalDate renewalDate;
    public RegisteredMember(int memberID,String name) {
        super(MemberType.REGISTERED,name);
        this.memberID = memberID;
        this.membershipDate = LocalDate.now();
        this.renewalDate = LocalDate.now().plusYears(1);
    }
    public LocalDate getRenewalDate() {
        return renewalDate;
    }
    public LocalDate membershipDate() {
        return membershipDate;
    }
    public void renewMembership() {
        this.renewalDate = LocalDate.now().plusYears(1);
    }

}
