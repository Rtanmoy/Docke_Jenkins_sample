package java8;

import com.dao.Book;
import com.dao.BookDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LamdaEx{

    public List<Book> getBookInSort() {
        List<Book> books=new BookDao().getBooks();
        Collections.sort(books,(o1,o2)->{
                return o1.getName().compareTo(o2.getName());
        });
        return books;
    }

   /* class MyComparator implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }*/

    public static void main(String[] args) {
        System.out.println(new LamdaEx().getBookInSort());
    }
}
