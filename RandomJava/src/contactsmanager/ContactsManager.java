package RandomJava.src.contactsmanager;

public class ContactsManager {
    // Fields
    Contact[] myFriends;
    int friendsCount;

    // Default Constructor
    public ContactsManager() {
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    // Methods
    // Add a contact
    void addContact(Contact contact) {
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    // Search for a contact by name and return it
    Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i].name.equals(searchName)) {
                return myFriends[i];
            }
        }
        return null;
    }

    // Main method
    class Main {
        public static void main(String[] args) {
            // Create a new ContactsManager object
            ContactsManager myContactManager = new ContactsManager();
            // Create new Contact objects
            Contact friend1 = new Contact();
            friend1.name = "John";
            friend1.phoneNumber = "123456789";
            friend1.email = "john@gmail.com";
            myContactManager.addContact(friend1);
            Contact friend2 = new Contact();
            friend2.name = "Jane";
            friend2.phoneNumber = "987654321";
            friend2.email = "jane@gmail.com";
            myContactManager.addContact(friend2);
            Contact friend3 = new Contact();
            friend3.name = "Bob";
            friend3.phoneNumber = "456789123";
            friend3.email = "bob@gmail.com";
            myContactManager.addContact(friend3);
            Contact friend4 = new Contact();
            friend4.name = "Alice";
            friend4.phoneNumber = "321654987";
            friend4.email = "alice@gmail.com";
            myContactManager.addContact(friend4);
            // Search for a contact by name
            Contact foundContact = myContactManager.searchContact("John");
            // Print the contact's information
            System.out.println("Name: " + foundContact.name);
            System.out.println("Phone Number: " + foundContact.phoneNumber);
            System.out.println("Email: " + foundContact.email);
            // Search for a contact by name
            foundContact = myContactManager.searchContact("Jane");
            // Print the contact's information
            System.out.println("Name: " + foundContact.name);
            System.out.println("Phone Number: " + foundContact.phoneNumber);
            System.out.println("Email: " + foundContact.email);
            // Search for a contact by name
            foundContact = myContactManager.searchContact("Bob");
            // Print the contact's information
            System.out.println("Name: " + foundContact.name);
            System.out.println("Phone Number: " + foundContact.phoneNumber);
            System.out.println("Email: " + foundContact.email);
            // Search for a contact by name
            foundContact = myContactManager.searchContact("Alice");
            // Print the contact's information
            System.out.println("Name: " + foundContact.name);
            System.out.println("Phone Number: " + foundContact.phoneNumber);
            System.out.println("Email: " + foundContact.email);
        }
    }
}
