# Soru 6a

### On Kosullar

Oncelikle `application.properties` dosyasina dogru bir database baglanti linki, kullanici adi ve sifresi girilmeli.
Canli database giris bilgilerini raporuma ekledim. Oradan ulasarak ekleyebilirsiniz.
 
### Calistirma
`application.properties` dosyasi dogru dbye baglanacak sekilde ayarlandiktan sonra asagidaki komut ile jar olusturunuz.


`mvn clean package`

Target dizinin altinda olusan jari asagidaki komut ile calistirabilirsiniz.

`java -jar target/q6b-0.0.1-SNAPSHOT.jar `

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
                where title_type = 'tvSeries'
                  and primary_title='Breaking Bad')
            ORDER BY average_rating LIMIT 5
```

### Cikti

Ugulama loglarinda Breaking Bad dizisinin en dusuk ratinge sahip ilk 5 bolumunu asagidaki gibi gorebilirsiniz.
 
```
Primary Title : Fly ---- Average Rating : 7.8 ---- Season Number : 3 ---- Episode Number : 10 
Primary Title : Open House ---- Average Rating : 8.1 ---- Season Number : 4 ---- Episode Number : 3 
Primary Title : Down ---- Average Rating : 8.3 ---- Season Number : 2 ---- Episode Number : 4 
Primary Title : Cancer Man ---- Average Rating : 8.3 ---- Season Number : 1 ---- Episode Number : 4 
Primary Title : Thirty-Eight Snub ---- Average Rating : 8.3 ---- Season Number : 4 ---- Episode Number : 2 
```






