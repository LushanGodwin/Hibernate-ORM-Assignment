import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.lang.annotation.Target;

public class Main {
    public static void main(String[] args) {
        //    create New object in book type
        Book book = new Book("B001","Harry Potter");
        Book book1 = new Book("B002","Apitath wasikiliyak");

        // Get the Hibernate session instance from the factory configuration.
        Session session = FactoryConfiguration.getInstance().getSession();

        // Begin a new transaction.
        Transaction transaction = session.beginTransaction();

         /*Save the "book" object to the database table.
         The "persist" method is used to save the object, making it persistent.
         The book object should have been properly mapped as an entity in Hibernate.*/
        session.persist(book);
        session.persist(book1);

         /* Commit the transaction to make the changes permanent in the database.
         If there are any errors or exceptions during this process, the transaction will be rolled back.*/
        transaction.commit();

        System.out.println("Books save successfully");

        Transaction transaction1 = session.beginTransaction();

        // Use the session's get method to retrieve the Book entity by its ID
        Book book2 = session.get(Book.class, "B001");

        System.out.println("Retrieve the book successfully");

        if (book2!=null){
            // Update the book attributes
            book2.setName("Game of Thrones");

            //update automatically book object changes in  database
            transaction1.commit();

            System.out.println("Update the book successfully");
        }

        Transaction transaction2 = session.beginTransaction();

        // Remove permanently the book object from the database.
        session.remove(book);
        transaction2.commit();

        System.out.println("Remove the book successfully");
    }
}
