package am.developer.bookstore.payload

class BookResponse(
    var id: Long?,
    var username: String,
    var email: String) {
    constructor() :  this(0, "", "");
}