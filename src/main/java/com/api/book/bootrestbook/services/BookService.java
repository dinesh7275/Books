package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
   @Autowired
    private BookRepository bookRepository;
    
//    private static List <Book>list = new ArrayList<>();
//    static{
//         list.add(new Book(12 , " java 1","abcd"));
//         list.add(new Book(13 , " java 2","abcde"));
//         list.add(new Book(14 , " java 3","abcdef"));
//     }
    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;

    }

    // to read book
    public Book getBookById(int id)
    {
        Book book= null;
        try{
          book=  this.bookRepository.findById(id);
      // book= list.stream().filter(e->e.getId()==id).findFirst().get();
        }
        catch(Exception e)
        {
           
            e.printStackTrace();
        }
        return book;
    }

    // to add book
    public Book addBook(Book b)
    {
        Book result= bookRepository.save(b);
     return result;
    // list.add(b);
    // return b ;
}


// to delete book
 public void deleteBook(int bid)
 {
  // list= list.stream().filter(book->book.getId()!=bid).
  // collect(Collectors.toList());
  bookRepository.deleteById(bid);
 }


 // to update book
 public void updateBook(Book book, int bookId)
 {
     book.setId(bookId);
     bookRepository.save(book);
//    list=list.stream().map(b->{if (b.getId()==bookId)
//     {
//         b.setTitle(book.getTitle());
//         b.setAuthor(book.getAuthor());
//     }
//      return b;}).collect(Collectors.toList());
 }

}
