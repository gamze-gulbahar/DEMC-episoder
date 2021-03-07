# Soru 6a

### On Kosullar

Oncelikle `application.properties` dosyasina dogru bir database baglanti linki, kullanici adi ve sifresi girilmeli.
Canli database giris bilgilerini raporuma ekledim. Oradan ulasarak ekleyebilirsiniz.
 
### Calistirma
`application.properties` dosyasi dogru dbye baglancak sekilde ayarlandiktan sonra asagidaki komut ile jar olusturunuz.


`mvn clean package`

Target dizinin altinda olusan jari asagidaki komut ile calistirabilirsiniz.

java -jar target/q6a-0.0.1-SNAPSHOT.jar 

### Uygulama Icerisinde calistirilan sorgu
Bu java uygulamasi dbye baglanarak asagidaki sorguyu calistiriyor.
```
SELECT primary_title, tr.average_rating, te.season_number, te.episode_number
            FROM title_basics tb
            JOIN title_episode te on tb.tconst = te.tconst
            JOIN title_ratings tr on te.tconst = tr.tconst
            WHERE te.parent_tconst = (
                select tconst\n
                from title_basics\n
                where title_type = 'tvSeries'\n
                  and primary_title='Breaking Bad')\n
            ORDER BY average_rating DESC LIMIT 5
```

### Cikti
Ugulama loglarinda Breaking Bad dizisinin en yuksek ratinge sahib ilk 5 bolumunu asagidaki gibi gormelisiniz.
 
```
Primary Title : Ozymandias ---- Average Rating : 10.0 ---- Season Number : 5 ---- Episode Number : 14 
Primary Title : Felina ---- Average Rating : 9.9 ---- Season Number : 5 ---- Episode Number : 16 
Primary Title : Face Off ---- Average Rating : 9.9 ---- Season Number : 4 ---- Episode Number : 13 
Primary Title : To'hajiilee ---- Average Rating : 9.8 ---- Season Number : 5 ---- Episode Number : 13 
Primary Title : Crawl Space ---- Average Rating : 9.7 ---- Season Number : 4 ---- Episode Number : 11 
```






