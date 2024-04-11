package s240319_과제;

import java.util.LinkedList;

public class addressNode {
    private String name;
    private String phone;
    private String email;
    private String address;

    public addressNode(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "이름 : " + name + ' ' +
                "번호 : " + phone + ' ' +
                "이메일 : " + email + ' ' +
                "주소 : " + address + ' ';
    }
}

class AddressBook {
    LinkedList<addressNode> contacts;

    public AddressBook() {
        contacts = new LinkedList<>();
    }

    public void addContact(addressNode contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        if (searchContact(name)!= null) {
            contacts.remove(searchContact(name));
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("해당 이름을 가진 요소를 찾을 수 없습니다.");
        }

    }

    public void DisplayAllContacts() {
        System.out.println("===주소록===");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.print("이름 : " + contacts.get(i).getName() + " ");
            System.out.print("번호 : " + contacts.get(i).getPhone() + " ");
            System.out.print("이메일 : " + contacts.get(i).getEmail()+ " ");
            System.out.print("주소 : " + contacts.get(i).getAddress()+ " ");
            System.out.println();
        }

    }

    public addressNode searchContact(String name) {
        for (addressNode contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

}

class ContactsTest {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new addressNode("이정훈", "010-5123-7370", "wjdgns4019@gmail.com", "대구광역시 수성구"));
        addressBook.addContact(new addressNode("홍길동", "010-1234-1234","honggill@gmail.com","대구광역시 북구"));
        addressBook.addContact(new addressNode("김아무개", "010-3333-3333","abcd@gmail.com","대구광역시 북구 복현동"));
        addressBook.addContact(new addressNode("김철수", "02-7290-0123","yju@gmail.com", "대구광역시 남구"));

        addressBook.DisplayAllContacts();

        addressBook.removeContact("홍길동");

        addressBook.DisplayAllContacts();

        System.out.println("김아무개 검색 결과 ");
        System.out.println(addressBook.searchContact("김아무개"));

        System.out.println("역방향 출력 ");
        for(int i = addressBook.contacts.size() - 1; i != -1; i--) {
            System.out.println(addressBook.contacts.get(i));
        }
    }
}
