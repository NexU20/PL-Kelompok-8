# Tugas Pemrograman Lanjut  
## Untuk File Students.java 
Method: 
1. Insert Data ke Database
2. Melihat Data Santri yang Terdata
3. Menghitung Jumlah Santri yang Terdata

```java
generateNIS();  //Auto Generated NIS berdasarkan tahun ini
generateNIS();  //Output: (String)

insert(name, kelas, gender, ttl, wali, note);        //Memasukan Data ke Tabel 'santri'
insert("Lerdi", "Kubro", "Laki-Laki", "Jakarta, 30 Juli 2004", "Murad", "Bocah Tengil");  //Output: True (Jika berhasil), False (Jika Gagal)

viewStudents(gender);    //Membaca data yang ada di tabel 'santri'. Param: null (untuk melihat semua), "Laki-Laki" (untuk melihat santri), "Perempuan" (untuk melihat santriwati)
viewStudents("Perempuan");  //Output: (ArrayList<Santri>)

count(type);    //Menghitung jumlah santri di dalam tabel. Param: "all" (jumlah seluruhnya), "santri" (jumlah santri), "santriwati" (jumlah santriwati)
count(all);  //Output: (Integer)
``` 
**Note:** Untuk fungsi insert sudah digenerate NIS secara otamatis dalam fungsinya!

--- 
## Untuk File Teachers.java 
Method: 
1. Insert Data ke Database
2. Melihat Data Pengajar yang Terdata
3. Menghitung Jumlah Pengajar yang Terdata

```java

insert(name, waliKelas, gender, ttl);        //Memasukan Data ke Tabel 'pengajar'
insert("Lerdi", "Kubro", "Laki-Laki", "Jakarta, 30 Juli 2004");  //Output: True (Jika berhasil), False (Jika Gagal)

viewTeachers();    //Membaca data yang ada di tabel 'pengajar'.
viewTeachers();  //Output: (ArrayList<Pengajar>)

count();    //Menghitung jumlah santri di dalam tabel. Param: "all" (jumlah seluruhnya), "santri" (jumlah santri), "santriwati" (jumlah santriwati)
count();  //Output: (Integer)
```

---

**Fungsi Login ada di DatabaseConnection.java**
