<h2 id="endpoint"> :floppy_disk: Endpointler</h2>


### Publisher Endpoint

| Method   | URL                                              | Açıklama                                               |
|----------|--------------------------------------------------|--------------------------------------------------------|
| `GET`    | `/v1/publishers`                                 | Tüm yayınevlerini geri döner.                          |
| `GET`    | `/v1/publishers?page={id}&pageSize={pageSizeId}` | Page id ve page size göre yayınevlerini geri döner. |
| `PUT`    | `/v1/publishers`                                 | Yayınevinin bilgilerini günceller.                     |
| `POST`   | `/v1/publishers`                                 | Yeni bir yayınevi oluşturur.                           |
| `GET`    | `/v1/publishers/{id}`                            | ID'si verilen yayınevinin bilgilerini getirir.         |
| `DELETE` | `/v1/publishers/{id}`                            | ID'si {publisher_id} olan yayınevinin bilgilerini siler. |


### Category Endpoint

| Method   | URL                   | Açıklama                                       |
|----------|-----------------------|------------------------------------------------|
| `GET`    | `/v1/categories`      | Tüm categorileri getirir.                      |
| `GET`    | `/v1/categories?page={id}&pageSize={pageSizeId}`      | Page id ve page size göre categorileri getirir.|
| `PUT`    | `/v1/categories`      | Categori bilgilerini günceller.                |
| `POST`   | `/v1/categories`      | Yeni bir categori oluşturur.                   |
| `GET`    | `/v1/categories/{id}` | ID'si verilen categorinin bilgilerini getirir. |
| `DELETE` | `/v1/categories/{id}` | ID'si verilen categoriyi siler.                |


### Book Endpoint


| Method   | URL                     | Açıklama                                               |
|----------|-------------------------|--------------------------------------------------------|
| `GET`    | `/v1/books`             | Tüm kitapları geri döner.                              |
| `GET`    | `/v1/books?page={id}&pageSize={pageSizeId}`             | Page id ve page size göre kitapları geri döner.                              |
| `PUT`    | `/v1/books`             | Kitap bilgilerini günceller.                           |
| `POST`   | `/v1/books`             | Yeni bir kitap oluşturur.                              |
| `GET`    | `/v1/books/{id}`        | ID'si verilen kitabın bilgilerini getirir.             |
| `DELETE` | `/v1/books/{id}`        | ID'si verilen kitabı siler.                            |
| `GET`    | `/v1/books/{id}/author` | ID'si belirtilen kitabın yazar bilgilerini getirir. |


### Author Endpoint


| Method   | URL                  | Açıklama                                                                    |
|----------|----------------------|-----------------------------------------------------------------------------|
| `GET`    | `/v1/authors`        | Tüm yazarlraı getirir.                                                      |
| `GET`    | `/v1/authors?page={id}&pageSize={pageSizeId}`        | Page id ve page size göre yazarlraı getirir.                                                      |
| `PUT`    | `/v1/authors`        | Yazar bilgilerini günceller.                                                |
| `POST`   | `/v1/authors`        | Yeni bir yazar oluşturur.                                                   |
| `GET`    | `/v1/authors/{id}`   | ID'si belirtilen yazarın bilgilerini getirir.                               |
| `DELETE` | `/v1/authors/{id}`   | ID'si belirtilen yazarın bilgilerini siler. |

### Book-Borrowing Endpoint


| Method   | URL                          | Açıklama                                                                       |
|----------|------------------------------|--------------------------------------------------------------------------------|
| `GET`    | `/v1/book-borrowings`        | Kullanıcıların ödünç aldığı tüm kitapları listeler.                            |
| `GET`    | `/v1/book-borrowings?page={id}&pageSize={pageSizeId}`        | Page id ve page size göre kullanıcıların ödünç aldığı kitapları listeler.   |
| `PUT`    | `/v1/book-borrowings`        | ID'si belirtilen ödünç alma işleminin durumunu günceller.                      |
| `POST`   | `/v1/book-borrowings`        | Bir kullanıcı tarafından belirli bir kitabın ödünç alınması için istek yapılır. |
| `GET`    | `/v1/book-borrowings/{id}`   | ID'si verilen ödünç alma işleminin detaylarını getirir.                        |
| `DELETE` | `/v1/book-borrowings/{id}`   | ID'si verilen ödünç alma işlemini iptal eder.                                  |
