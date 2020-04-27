import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/Services/book.service';
import { Book } from 'src/app/common/book';




@Component({
  selector: 'app-book-list',
 // templateUrl: './book-list.component.html',
  templateUrl: './book-grid.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[]; 

  constructor(private _bookService: BookService) { }

  ngOnInit() {
    this.listBooks();
  }

  listBooks(){
    this._bookService.getBooks().subscribe(
      data => {
        console.log(data);
        this.books=data;
      }

    )
  }

}
