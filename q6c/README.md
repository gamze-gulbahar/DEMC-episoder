# Soru 6c

### On Kosullar

Oncelikle `application.properties` dosyasina dogru bir database baglanti linki, kullanici adi ve sifresi girilmeli.
Canli database giris bilgilerini raporuma ekledim. Oradan ulasarak ekleyebilirsiniz.
 
### Calistirma
`application.properties` dosyasi dogru dbye baglanacak sekilde ayarlandiktan sonra asagidaki komut ile jar olusturunuz.


`mvn clean package`

Target dizinin altinda olusan jari asagidaki komut ile calistirabilirsiniz.

`java -jar target/q6c-0.0.1-SNAPSHOT.jar `

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
            ORDER BY num_votes DESC LIMIT 5
```

### Cikti

Ugulama loglarinda Breaking Bad dizisinin en cok oy almis ilk 5 bolumunu asagidaki gibi gorebilirsiniz.
 
```
Primary Title : Ozymandias ---- Number of Votes : 133279 ---- Season Number : 5 ---- Episode Number : 14 
Primary Title : Felina ---- Number of Votes : 91085 ---- Season Number : 5 ---- Episode Number : 16 
Primary Title : Face Off ---- Number of Votes : 45635 ---- Season Number : 4 ---- Episode Number : 13 
Primary Title : Granite State ---- Number of Votes : 34418 ---- Season Number : 5 ---- Episode Number : 15 
Primary Title : To'hajiilee ---- Number of Votes : 34214 ---- Season Number : 5 ---- Episode Number : 13 
```
