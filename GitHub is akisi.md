## GitHub -- İki Seviyeli İş Akışı

32 kişilik sınıfta bir ortak çalışma örneği üretmek için, 6 ve 9 Şubat tarihli iki adet commit ile böyle başladık:

![Böyle başladık](images/first%20two%20commits.png)


### Fork & Clone

GitHub iş akışı modellerinden bize en uygun olanı [Fork & Clone](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow). Bu modelde her repo tek daldan ibaret, ama herbiri projenin bir dalını oluşturuyor. Böylece, Git'in branch yapısını kullanmaya gerek kalmadı.

Öğrenci sayısı bir kişinin yönetebileceğinden çok fazla olduğu için birkaç takım lideri gönüllü oldu, diğer öğrenciler liderlerin reposundan kopyaladılar. Ana reponun 32 adet kopyası oldu:

![clone](images/clone.png)

Bu modelin iyi tarafı şu: herkes kendi reposunun sahibi ve hiç kimseye yazma hakkı vermek gerekmiyor. 


### Branch

Öğrenciler kendi repolarına birer dosya ekleyip ilk günden itibaren PR (Pull Request) göndermeye başladılar:

![Feb 11](images/Network%20Feb%2011.PNG)

Ertesi gün, proje ağacında [hemen herkesin bir dalı olmuştu](https://raw.githubusercontent.com/maeyler/Automata-2016/master/images/Network%20Feb%2012.PNG) (Henüz hiçbir PR kabul edilmeden)

Buradaki iş akışı şöyle özetlenebilir:

1. _modify work area_ -- öğrenci işini yerel PC'de yapıyor
2. _commit & push/sync_ -- kendi reposuna kaydediyor
3. _send PR_ -- takım liderine haber gönderiyor


### Merge

İki seviyeli yaklaşımda, takım liderleri PR'ları kabul ediyor, takımın işi tamam olunca proje sahibine PR gönderiyor:

![modify](images/modify.png)



### Update

Projenin sonunda her öğrenci ana repodan kendi reposunu güncelledi ve [bütün repolar eşitlenmiş oldu](https://raw.githubusercontent.com/maeyler/Automata-2016/master/images/branch%26merge.png). Aslında repoların hepsi aynı seviyede olduğu için, herhangi biri ile eşitlemek mümkün. Bunun için yazılan bat dosyasını `./accept.bat maeyler` şeklinde çalıştırınca ana repo ile eşitlenmiş oluyor.

![update](images/update.png)

Fakat ana reponun diğerlerinden önemli bir farkı var: hızlı kelime aramasına izin veriyor. Diğer repolarda arama özelliği yok.
