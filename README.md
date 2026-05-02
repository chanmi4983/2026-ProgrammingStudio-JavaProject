# 2026 Programming Studio Java Project

---

## 주제 선택 이유

## 주제 선택 이유

읽은 책이나 읽고 싶은 책을 따로 정리하지 않으면 책 제목이나 진행 상태를 잊어버리기 쉽다.  
그리고 어떤 책을 먼저 읽을지 고민이 될 때도 많다.  

이러한 문제를 해결하기 위해 사용자가 직접 책을 등록하고 관리할 수 있는 프로그램이 필요하다고 생각하였다.  
특히 단순히 목록을 저장하는 것뿐만 아니라 현재 읽고 있는 상태나 카테고리(분야)를 기준으로 정리할 수 있도록 구성하면 더 효율적인 관리가 가능하다.  

또한 사용자가 선택에 어려움을 느낄 때 랜덤 추천 기능을 통해 책을 선택할 수 있도록 하여 단순한 저장 기능을 넘어서 실제로 활용할 수 있는 기능을 추가하고자 하였다.  

이 프로그램은 사용자의 개인적인 독서 기록을 관리하는 일종의 책 장바구니 역할을 하며 책들을 관리할 수 있도록 도와준다.  
따라서 본 프로젝트에서는 책 정보를 등록 조회 수정 삭제할 수 있는 콘솔 기반 책 관리 프로그램을 구현하였다.

---

## 데이터 필드

### Book 클래스 필드

- id  
각 책을 구분하기 위한 고유 번호이다.  
사용자가 특정 책을 수정하거나 삭제할 때 기준이 되는 값으로 사용된다.

- title  
책의 제목을 저장하는 필드이다.  
검색 기능에서 키워드로 활용되며 사용자가 책을 식별하는 가장 기본적인 정보이다.

- author  
책을 집필한 저자의 이름을 저장한다.  
같은 제목의 책이 있을 수 있기 때문에 저자 정보는 책을 구분하는 데 중요한 역할을 한다.

- publisher  
출판사를 저장하는 필드이다.  
책의 출판 정보를 관리하기 위해 추가하였으며, 동일한 책이라도 출판사에 따라 판본이 다를 수 있기 때문에 의미 있는 정보이다.

- category  
책의 주제를 분류하기 위한 필드이다.  
예를 들어 CS AI Novel 등의 값이 들어갈 수 있으며, 카테고리 필터링 기능에서 사용된다.

- status  
현재 독서 상태를 나타내는 필드이다.  
읽는중 완료 미완료 등의 값을 통해 사용자가 책의 진행 상황을 쉽게 파악할 수 있도록 한다.

- rating  
책에 대한 개인적인 평가 점수를 나타낸다.  
정수 값으로 저장되며 사용자의 만족도를 표현하고 이후 정렬이나 추천 기능에 활용될 수 있다.

---

## 기능 구성

1. 책 등록  
2. 전체 책 조회  
3. 책 정보 수정  
4. 책 삭제  
5. 제목 검색  
6. 카테고리 필터링  
7. 랜덤으로 책 골라주기  
8. 파일 저장  
9. 파일 불러오기  
10. 임시 데이터 저장
0. 종료  

---

## 부가기능

제목 검색  
카테고리 필터링  
랜덤 책 추천  

---

## 클래스 구조

Main.java  
Book.java  
BookManager.java  
ICRUD.java  

---

## 파일 설명

### 1. main()

Main 클래스의 main() 메소드는 프로그램 실행을 담당한다.  
유저가 화면을 봤을 때 직접적으로 볼 수 있는 화면이다.  

먼저 Scanner를 생성해서 사용자의 메뉴 입력을 받고 BookManager 객체를 생성해서 실제 기능을 실행할 수 있게 한다.  
while(true) 반복문을 사용해서 메뉴를 선택할 수 있게끔 만들었고 사용자가 0을 입력하면 break를 통해 프로그램을 종료하도록 구현하였다.  

각 메뉴 번호는 if-else if 조건문으로 구분하였고 선택한 번호에 따라 BookManager의 메소드를 호출한다.  
사용자가 원하는 메뉴를 선택할 수 있다.  

예를 들어 사용자가 1을 입력하면 manager.addBook()이 실행되고 2를 입력하면 manager.listBooks()가 실행된다.  
이렇게 Main은 직접 책 데이터를 처리하지 않고 메뉴 선택과 메소드 호출 역할만 담당하도록 하였다.  

---

### 2. BookManager()

BookManager 생성자는 책 데이터를 저장할 ArrayList<Book>을 만들고 입력을 받기 위한 Scanner 객체를 초기화한다.  

books = new ArrayList<>();  
s = new Scanner(System.in);  

books 리스트는 등록된 책들을 저장하는 공간으로 이후 등록 조회 수정 삭제 기능에서 사용된다.  

---

### 3. Book()

Book.java는 책 한 권의 정보를 저장하는 데이터 클래스이다.  

id title author publisher category status rating 필드를 가지고 있으며 각 필드는 private으로 선언하였다.  

외부에서는 getter와 setter를 통해 값에 접근하거나 수정할 수 있도록 구현하였다.  

또한 toString() 메소드를 overriding하여 책 정보를 출력할 때 보기 좋은 형식으로 나타나도록 하였다.  

---

### 4. ICRUD

ICRUD 인터페이스는 BookManager에서 구현해야 하는 주요 기능의 틀을 정의한다.  

addBook listBooks updateBook deleteBook saveBooks loadBooks searchBook filterByCategory recommendBook 메소드를 선언하였다.  

BookManager 클래스는 implements ICRUD를 사용하여 이 인터페이스를 구현한다.  

---

## 메소드 설명

### 1. addBook()

addBook()은 새로운 책 정보를 등록하는 메소드이다.  
사용자로부터 id title author publisher category status rating 값을 순차적으로 입력받는다.  

입력 과정에서 nextInt()와 nextLine()을 함께 사용하기 때문에 입력 버퍼 문제를 방지하기 위해 nextInt() 이후 nextLine()을 추가로 호출하여 남아있는 개행 문자를 제거하였다.  

입력받은 값들을 이용하여 Book 객체를 생성하고 이를 books ArrayList에 추가한다.  

Book book = new Book(id, title, author, publisher, category, status, rating);  
books.add(book);  

이 과정에서 ArrayList를 사용함으로써 동적으로 책 데이터를 관리할 수 있도록 하였으며 새로운 데이터가 추가될 때마다 리스트의 크기가 자동으로 증가하도록 구현하였다.  

또한 addBook()은 사용자 입력 기반으로 데이터를 생성하는 메소드이며 addBook(Book book) 메소드와 함께 오버로딩 구조를 이루어 다양한 방식으로 책 데이터를 추가할 수 있도록 설계하였다.  

등록된 데이터는 이후 saveBooks() 메소드를 통해 파일에 콤마(,)를 기준으로 저장되며 loadBooks() 메소드에서 동일한 형식을 기반으로 다시 불러올 수 있도록 일관성을 유지하였다.  

이 메소드는 CRUD 중 Create 기능에 해당한다.

---

### 2. addBook(Book book)

이 메소드는 addBook()의 오버로딩 메소드이다.  

기존 addBook()은 사용자에게 직접 입력을 받아 책을 추가하지만 addBook(Book book)은 이미 만들어진 Book 객체를 매개변수로 받아 리스트에 추가한다.  

public void addBook(Book book) {  
    books.add(book);  
}  

메소드 이름은 같지만 매개변수가 다르기 때문에 method overloading에 해당한다.  

---

### 3. listBooks()

listBooks()는 등록된 책 전체를 출력하는 메소드이다.  

먼저 books.isEmpty()로 가지고 있는 리스트가 비어있는지 확인하고 비어 있으면 No books found.를 출력한다.  

책이 있으면 StringBuilder를 사용해서 책 정보를 하나의 문자열로 모은 뒤 출력한다.  

StringBuilder sb = new StringBuilder();  

for (int i = 0; i < books.size(); i++) {  
    sb.append(books.get(i)).append("\n");  
}  

여기서 books.get(i)를 출력하면 Book 클래스의 toString() 메소드가 자동으로 호출된다.  

이 메소드는 CRUD 중 Read 기능에 해당한다.  

---

### 4. updateBook()

updateBook()은 책 정보를 수정하는 메소드이다.  

먼저 수정할 책의 id를 입력받고 for문으로 리스트를 처음부터 끝까지 확인한다.  

for (int i = 0; i < books.size(); i++) {  
    Book book = books.get(i);  
}  

각 책의 getId() 값과 입력받은 id가 같으면 해당 책을 찾은 것이므로 제목 저자 출판사 카테고리 상태 평점을 새로 입력받아 setter로 수정한다.  

book.setTitle(s.nextLine());  
book.setAuthor(s.nextLine());  
book.setPublisher(s.nextLine());  
book.setCategory(s.nextLine());  
book.setStatus(s.nextLine());  
book.setRating(s.nextInt());  

수정이 끝나면 return으로 메소드를 종료한다.  

일치하는 id가 없으면 Book not found.를 출력한다.  

이 메소드는 CRUD 중 Update 기능에 해당한다.  

---

### 5. deleteBook()

deleteBook()은 책을 삭제하는 메소드이다.  

삭제할 책의 id를 입력받고 for문으로 리스트를 검사한다.  

if (books.get(i).getId() == id) {  
    books.remove(i);  
}  

입력한 id와 같은 책을 찾으면 books.remove(i)로 해당 인덱스의 책을 삭제한다.  

삭제 후에는 return으로 종료해서 더 이상 반복하지 않도록 했다.  

일치하는 id가 없으면 Book not found.를 출력한다.  

이 메소드는 CRUD 중 Delete 기능에 해당한다.  

---

### 6. saveBooks()

saveBooks()는 현재 리스트에 있는 책 정보를 파일에 저장하는 메소드이다.  

PrintWriter와 FileWriter를 사용해서 books.txt 파일에 데이터를 저장한다.  

for문으로 책을 하나씩 꺼내고 각 필드를 쉼표로 연결해서 한 줄에 저장한다.  

id,title,author,publisher,category,status,rating  

예를 들면 다음과 같은 형식으로 저장된다.  

1,Java,Kim,Hanbit,Programming,읽는중,5  

파일 입출력 중 오류가 날 수 있기 때문에 try-catch 문으로 예외를 처리하였다.  

---

### 7. loadBooks()

loadBooks()는 books.txt 파일에 저장된 책 정보를 다시 프로그램으로 불러오는 메소드이다.  

File 객체와 파일용 Scanner를 사용해서 파일을 한 줄씩 읽는다.  

먼저 books.clear()를 사용해서 기존 리스트를 비운다.  

이렇게 하지 않으면 불러오기를 여러 번 했을 때 같은 데이터가 중복으로 들어갈 수 있기 때문이다.  

읽은 한 줄은 split(",")으로 나누고 각 값을 다시 Book 객체로 만든다.  

String[] data = line.split(",");  

그 후 books.add(book)으로 리스트에 다시 추가한다.  

파일이 없을 경우 FileNotFoundException을 catch해서 저장된 파일이 없습니다.를 출력한다.  

---

### 8. searchBook()

searchBook()은 제목으로 책을 검색하는 부가기능이다.  

사용자에게 검색어를 입력받고 모든 책의 제목과 비교한다.  

if (book.getTitle().contains(keyword))  

contains()를 사용했기 때문에 제목 전체가 아니라 일부 단어만 입력해도 검색이 가능하다.  

검색 결과가 있으면 책 정보를 출력하고 없으면 No matching book found.를 출력한다.  

---

### 9. filterByCategory()

filterByCategory()는 특정 카테고리에 해당하는 책만 확인할 수 있는 부가기능이다.  

사용자가 카테고리를 입력하면 각 책의 category 값과 비교한다.  

if (book.getCategory().equals(category))  

문자열 비교에는 ==가 아니라 equals()를 사용했다.  

입력한 카테고리와 같은 책만 출력하고 없으면 No books in this category.를 출력한다.  

---

### 10. recommendBook()

recommendBook()은 랜덤으로 책을 추천하는 부가기능이다.  

먼저 리스트가 비어 있으면 추천할 책이 없으므로 No books available.을 출력한다.  

책이 있으면 Random 객체를 사용해서 리스트 크기 안에서 랜덤 인덱스를 만든다.  

int index = rand.nextInt(books.size());  

그리고 해당 인덱스의 책을 출력한다.  

사용자가 어떤 책을 볼지 고민할 때 임의로 책을 추천해주는 기능이다.  

---

### 11. addTestData()

addTestData()는 개발 중 테스트를 쉽게 하기 위해 만든 메소드이다.  

books.add(new Book(1, "Java", "Kim", "Hanbit", "Programming", "읽는중", 5));  

이 메소드는 제출용 핵심 기능이라기보다는 기능 테스트를 위한 보조 메소드이다.