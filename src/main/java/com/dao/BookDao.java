package com.dao;

import java.util.List;
import java.util.ArrayList;

public class BookDao {

   public List<Book> getBooks(){
       List<Book> lbook=new ArrayList<Book>();
       lbook.add(new Book(111,"Annu",24));
       lbook.add(new Book(115,"Sonu",34));
       lbook.add(new Book(161,"Junnu",21));
       lbook.add(new Book(131,"Vanu",44));

       return lbook;
   }

}
