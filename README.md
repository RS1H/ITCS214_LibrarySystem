# Library System (Java) – Fixed Version

**Same structure as your code**, but with the real bugs fixed so it stores data correctly and deletes safely.

## What was fixed
- Constructors & setters now assign fields with `this.field = param;` (previously they assigned nothing).
- `addMember` checks for duplicates using `membersList.contains(member)` instead of `membersList.equals(member)`.
- Safe deletion using an `Iterator` inside `deleteBook` / `deleteMember` (avoids concurrent modification).
- Typos in `toString()` (`Title`, `CPR`) and null/empty safety for second author.
- Kept your manual counters (`booksListSize`, `membersListSize`) so the public API stays identical.

## Files
```
Main.java
Book.java
LibMember.java
LibrarySystem.java
```

## Build & Run
```bash
javac Main.java Book.java LibMember.java LibrarySystem.java
java Main
```

### Expected Output
```
Books in system: 1
Members in system: 1
Title: Java Basics | Authors: Ryan & Ali | Publisher: OUP | Year: 2020 | ISBN: 12345 | Accession: 1001
Name: Ahmed Hassan | CPR: 123456789 | Books issued: 0
```

## Authors
- **Rayan Ali Mohammed**
- **Rayan Alharthy**
- **(Third teammate name not specified)**
