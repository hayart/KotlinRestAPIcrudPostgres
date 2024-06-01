package am.developer.bookstore.payload

class BookResponse(
    var username: String,
    var email: String) {
    constructor() :  this("", "");
}