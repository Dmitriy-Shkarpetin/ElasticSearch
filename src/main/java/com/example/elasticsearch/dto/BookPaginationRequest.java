package com.example.elasticsearch.dto;

public class BookPaginationRequest {
    private String author;
    // Номер страницы
    private Integer number;
    // Количество книг
    private Integer size;

    //Допустим number = 0 (1-ая страница), size = 2 (две книги)
    // (а всего книг 5 штук с одинаковым автором),
    //тогда выведется 1-ая страница (подсчет от нуля) с двумя книгами
    // остальные две страницы с двумя и одной книгой в фильтр не попадут

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
