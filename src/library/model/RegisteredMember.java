package library.model;


import java.time.LocalDate;

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
