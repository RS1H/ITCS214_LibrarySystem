# Library System (Java)

A simple **Object-Oriented** library system written in Java. It models **books**, **library members**, and a minimal **library manager** that stores collections in memory and supports basic operations (add, delete, search, list size checks).

> Educational project (intro OOP / data structures). No database or GUI; console-only.

---

## Features

- Create and manage **Book** records (title, authors, publisher, year, ISBN, accession number).
- Create and manage **LibMember** records (name, gender, CPR, phone).
- Add / delete books and members (with basic safety checks).
- Search for a book or member by key (accession number / CPR).
- Query collection sizes and emptiness.
- Clean `toString()` outputs for quick inspection.

---

## Project Structure

```
Main.java            # Entry point: creates demo data and prints sample output
Book.java            # Book entity
LibMember.java       # Library member entity
LibrarySystem.java   # Manager: holds lists and exposes operations
```

---

## Quick Start

### Requirements
- Java 8+ (JDK installed)
- Any terminal / command prompt

### Build & Run
```bash
javac Main.java Book.java LibMember.java LibrarySystem.java
java Main
```

### Example Output
```
Books in system: 1
Members in system: 1
Title: Java Basics | Authors: Ryan & Ali | Publisher: OUP | Year: 2020 | ISBN: 12345 | Accession: 1001
Name: Ahmed Hassan | CPR: 123456789 | Books issued: 0
```

> You can edit `Main.java` to add more books/members and call other methods.

---

## Design Overview

### Class Diagram (high-level)

```
+----------------+         0..1   issuedTo   +----------------+
|     Book       |--------------------------->|   LibMember    |
+----------------+                             +----------------+
| - title        |                             | - firstName    |
| - author1      |                             | - lastName     |
| - author2      |                             | - gender       |
| - publisher    |                             | - cprNum       |
| - yearPub      |                             | - teleNum      |
| - isbn         |                             | - booksIssued[]|
| - accessionNum |                             | - numBooks     |
+----------------+                             +----------------+

                 managed by
                 contains lists of
                         |
                         v
                  +------------------+
                  |  LibrarySystem   |
                  +------------------+
                  | + addBook(...)   |
                  | + deleteBook(...)|
                  | + addMember(...) |
                  | + deleteMember(..)|
                  | + searchBook(...)|
                  | + searchMember(..)|
                  | + size* / isEmpty |
                  +------------------+
```

### Key Decisions
- Equality:  
  - `Book.equals()` compares **accessionNum**
  - `LibMember.equals()` compares **cprNum**
- Collections: `LinkedList` for simplicity (intro DS level).  
- No persistence: data is in-memory only (resets each run).

---

## Public API (core methods)

### `LibrarySystem`
- `boolean addBook(Book book)` — Adds if not duplicated by accession number.
- `boolean deleteBook(long accessionNum)` — Deletes if found and **not issued**.
- `boolean addMember(LibMember member)` — Adds if not duplicated by CPR.
- `boolean deleteMember(long cprNum)` — Deletes if found and **has no books**.
- `int searchBook(long accessionNum)` — Returns index or `-1`.
- `int searchMember(long cprNum)` — Returns index or `-1`.
- `int sizeBooksList()` / `int sizeMembersList()` — Counts.
- `boolean isEmptyBooksList()` / `boolean isEmptyMembersList()` — Emptiness checks.

### `Book`
- Fields: `title, author1, author2, publisher, yearPublication, isbn, accessionNum, issuedTo`
- Typical setters/getters and `toString()` for readable printouts.

### `LibMember`
- Fields: `firstName, lastName, gender, cprNum, teleNum, booksIssued[10], numBooksIssued`
- Typical setters/getters and `toString()`.

> Note: Issuing/returning logic is not implemented in this version; only storage & lookups.

---

## Customization Ideas (Optional)
- Add **issue / return** workflows that update `Book.issuedTo` and member counters.
- Replace `LinkedList` with `ArrayList` or a **Map** keyed by accession/CPR for O(1) lookups.
- Persist to a JSON/CSV file or a DB.
- Unit tests with JUnit.

---

## License
MIT — do what you want, just keep the notice.

## Authors
- **Rayan**
- **Mohammed**
