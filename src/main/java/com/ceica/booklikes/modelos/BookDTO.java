package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDTO extends Book {
    private Long likeCount;

    public BookDTO() {
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public List<BookDTO> getBookDTOsDB() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Object> objectList = new Book().leerTodos("select books.idBook, books.title, books.author, books.description," +
                " books.creationDate, books.imageSource, books.idUser, count(likes.idBook) as likeCount from likes \n" +
                "right join books on books.idBook = likes.idBook\n" +
                "group by books.idBook");
        return getBookDTOS(bookDTOList, objectList);
    }

    public List<BookDTO> getBookDTOsByUser(User user) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Object> objectList = new Book().leerTodos("select books.idBook, books.title, books.author, books.description," +
                " books.creationDate, books.imageSource, books.idUser, count(likes.idBook) as likeCount from likes \n" +
                "right join books on books.idBook = likes.idBook\n" +
                "where books.idUser = " + user.getId() + " group by books.idBook");
        return getBookDTOS(bookDTOList, objectList);
    }

    private List<BookDTO> getBookDTOS(List<BookDTO> bookDTOList, List<Object> objectList) {
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId((int) objects[0]);
            bookDTO.setTitle((String) objects[1]);
            bookDTO.setAuthor((String) objects[2]);
            bookDTO.setDescription((String) objects[3]);
            bookDTO.setCreationDate((LocalDateTime) objects[4]);
            bookDTO.setImageSource((String) objects[5]);
            bookDTO.setIdUser((int) objects[6]);
            bookDTO.setLikeCount((Long) objects[7]);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public BookDTO getBookDTOById(int idBookDTO) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Object> objectList = new Book().leerTodos("select books.idBook, books.title, books.author, books.description," +
                " books.creationDate, books.imageSource, books.idUser, count(likes.idBook) as likeCount from likes \n" +
                "right join books on books.idBook = likes.idBook\n" +
                "where books.idBook = " + idBookDTO + " group by books.idBook");
        return getBookDTOS(bookDTOList, objectList).get(0);
    }
}