package lms.service;

import lms.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateLateFee(daysLate));
        }
    }

    public void lend(Loanable thing, Member member) {
        thing.loan(member);
    }

    public void reserveIfPossible(LibraryItem item, Member member) {
        if (item instanceof Reservable r) {
            r.reserve(member);
        } else {
            System.out.println(item.getTitle() + " cannot be reserved.");
        }
    }

    public void printMembersByActivity() {
        System.out.println("--- Members ranked by activity ---");
        List<Member> sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        for (Member m : sortedMembers) {
            System.out.println(m.getName() + " (" + m.getBorrowedCount() + " borrowed)");
        }
    }
}