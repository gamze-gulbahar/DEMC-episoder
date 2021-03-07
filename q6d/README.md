# Soru 6d

### On Kosullar

Oncelikle `application.properties` dosyasina dogru bir database baglanti linki, kullanici adi ve sifresi girilmeli.
Canli database giris bilgilerini raporuma ekledim. Oradan ulasarak ekleyebilirsiniz.

### Calistirma
`application.properties` dosyasi dogru dbye baglanacak sekilde ayarlandiktan sonra asagidaki komut ile jar olusturunuz.


`mvn clean package`

Target dizinin altinda olusan jari asagidaki komut ile calistirabilirsiniz.

`java -jar target/q6d-0.0.1-SNAPSHOT.jar `

### Uygulama Icerisinde calistirilan sorgu

Bu java uygulamasi dbye baglanarak asagidaki sorguyu calistiriyor.

```
SELECT primary_title, te.season_number, te.episode_number, tr.num_votes
            FROM title_basics tb
            JOIN title_episode te on tb.tconst = te.tconst
            JOIN title_ratings tr on te.tconst = tr.tconst
            WHERE te.parent_tconst = (
                select tconst\n
                from title_basics\n
                where title_type = 'tvSeries'
                  and primary_title='Breaking Bad')
            ORDER BY num_votes LIMIT 5
```

### Cikti

Ugulama loglarinda Breaking Bad dizisinin en az oy almis ilk 5 bolumunu asagidaki gibi gorebilirsiniz.

```
Primary Title : Más ---- Number of Votes : 13589 ---- Season Number : 3 ---- Episode Number : 5
Primary Title : Bullet Points ---- Number of Votes : 13684 ---- Season Number : 4 ---- Episode Number : 4
Primary Title : Shotgun ---- Number of Votes : 13706 ---- Season Number : 4 ---- Episode Number : 5
Primary Title : Abiquiu ---- Number of Votes : 13803 ---- Season Number : 3 ---- Episode Number : 11
Primary Title : Cornered ---- Number of Votes : 13884 ---- Season Number : 4 ---- Episode Number : 6
```






