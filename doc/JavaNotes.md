### C ve Sistem Programcıları Derneği
### Java ile Nesne Yönelimli Programlama
### Eğitmen: Oğuz KARAN

#### 21 Eylül 2024 - 22 Eylül 2024

> Java 1995 yılında Sun firması'nda çalışan `James Gosling` tarafından tasarlanmıştır. Sun firması daha sonra Oracle tarafından satın alınmıştır ve şu an Java aslında Oracle firmasına aittir. Java 1.0 versiyonu ile çıkmıştır şu an 17 Eylül 2024 itibariyle Java 23 son sürüm olarak ilan edilmiştir. Java ismi hem programlama diline hem de ortama verilen genel bir isimdir. Java'da yıllar içerisinde pek çok değişiklikler olmuştur. Bu anlamda bazı sürümler majör bazı eklentilerle ve değişikliklerle yayınlanmıştır. Majör değişiklikler genel olarak programlama yaklaşımının bile değişebilmesine yol açabilabilen değişiklikleri kapsar. Bu anlamda programlama dilinde ve ortamında da değişiklikler olabilmektedir. Java sürümleri içerisinde majör değişikliklerin en belirgin olduğu iki sürüm Java 5 ve Java 8 sürümleridir. Bu sürümlerde Java'ya hem ortam hem de programlama dili anlamında radikal eklentiler yapılmıştır. Bazı sürümlerde yine önemli eklentiler olabilir ancak bunların sayısı az olabilmektedir. Örneğin Java 11, Java 17 ve Java 21 sürümleri bu şekildedir. Yine bazı sürümlerde çok önemli olmayan da değişiklikler olabilmektedir. Bazı sürümlerde eklenen değişiklikler **preview/experimental** denilen biçimdedir. Bu değişiklikler doğrudan kullanılamaz. Derleme işleminde bir takım switch'lerin verilmesi gerekir. 

##### Java Ortamının Temel Özellikleri

> **1. Arakodlu Çalışma Sistemi:** C, C++ ve Go gibi dillerde yazılan kodlardan elde edilen (hangi aşamalardan geçilerek elde edildiği şu an için önemsizdir) çalışabilir dosya (executable file) sisteme (genel olarak işletim sistemi, donanım vb.) özgüdür ve bazı durumlarda yazılan kodlar her sisteme göre ayrı olabilmektedir. Eğer kod sistemden bağımsız olarak yani standart olarak yazılmışsa bile her sistem için ayrı executable file'lar elde edilmelidir. Oysa Java programlama dili ile yazılmış bir program derlendiğinde (compilation) elde edilen dosyanın içerisinde hiç bir sistemin dili olmayan yapay bir kod bulunur. Bu arakoda Java dünyasında **byte code (BC)** denilmektedir. BC doğrudan çalışıtırılamaz. Çalıştırılabilmesi için ayrı bir uygulama gerekir. Bu uygulama BC'yi yorumlayarak makine koduna yani sisteme özgü kod dönüştürerek programı çalıştırır. Bu dönüştürme işlemine JIT (Just In Time) compilation denilmektedir. Geliştirme ve çalıştırma ortamında 3 tane temel kavram söz konusudur:
> - **JVM (Java Virtual Machine):** BC'yi makine koduna dönüştürür. JVM aslında BC'nin nasıl makine koduna dönüştürüleceğini tanımlayan soyut bir kavramdır.
>
> - **JRE (Java Runtime Environment):** Genel olarak Java ile yazılmış bir uygulamayı çalıştırmak (run) için gereken araçları ve uygulamaları içeren bir pakettir. Yani BC elde edildiğinde çalıştırılabilmesi için JRE'ye ihtiyaç vardır. 
> 
> - **JDK (Java Development Kit):** Geliştirme (development) araçlarını ve çalıştırma araçlarının bir çoğunu içeren bir pakettir. Buradaki çalıştırma araçları geliştirme aşamasında kullanılabilmektedir. 
> 
> Java 11 ile birlikte ticari kullanımlarda Oracle tarafından bazı değişikliklere gidilmiştir. Özet (genel) olarak şunlar söylenebilir: Java'da geliştirme ortamı ücretsizdir. Çalıştırma araçları kullanılan araca göre ücretlendirilebilmektedir. Tamamen ücretsiz olarak kullanılabilen çalıştırma araçları da mevcuttur. Bunlardan en tipik olanı "Open JRE"'dir. Burada anlatılanların detayları olduğu unutulmamalıdır. 
> 
> Java 11 ile Long Term Support (LTS) kavramı getirilmiştir. LTS sürümleri uzun süre desteklenen ve güncellemesi (hızlandırılması, hataların düzeltilmesi (bugfix) vb) uzun süre yapılan sürümlerdir. Java'da Java 8, 11, 17 ve 21 sürümleri LTS'dir. Ticari uygulamalarda genel olarak (hatta her zaman) LTS sürümleri kullanılır. 
> 
> Arakodlu çalışma sisteminin en önemli avantajı geliştirilen uygulamaların genel olarak sistemden bağımsız olarak çalıştırılabilmesidir. Bu kavrama "Write Once Run Anywhere (WORA)" denilmektedir. Şüphesiz bunun da ayrntıları ve istisnaları vardır. 
> 
> Ayrıca unutulmamalıdır ki arakodlu çalışma sistemi az da olsa bir performans kaybına yol açar. Ancak Java'nın hedeflediği uygulamalar düşünüldüğünde bu kaybın pek de önemi yoktur.
> 
> **Anahtar Notlar:*** Aslında Java'da istenirse sisteme özgü çalışabilen bir executable file da son yıllarda elde edilebilmektedir. Bu işlem için genel olarak GraalVM kullanılmaktadır. GraalVM kullanımının belirli kısıtları olabilmektedir. GraalVM ve detayları "Java ile Uygulama 2" kursunda ele alınacaktır.
> 
> **2. Hızlı Uygulama Geliştirme Ortamı:** Java hızlı uygulama geliştirme (rapid application development) ortamı sunar. Bu anlamda hem öğrenmesi kolaydır hem de ürün çabuk elde edilir.
> 
> **3. Geniş bir sınıf kütüphanesi:** Java'da oldukça geniş sınıf kütüphanesi bulunur. Dosya işlemleri, veritabanı işlemleri vb. işlemler için hazır sınıflar bulunur. Java'nın standart olarak kullanılan kütüphanelerine "Java Standard Edition (Java SE)" denilmektedir. Ayrıca Java programlamada pratikte başka kişiler, organizasyonlar ve firmalar tarafından geliştirilmiş adeta standart gibi kullanılan pek çok kütüphane de bulunmaktadır.
> 
> **4. Güvenli çalışma ortamı:** Java'da yazılmış olan bir programın sisteme zarar verme olasılığı çok daha azdır. Yazılan bir program yüzünden yanlıkla sistemde bir problem olma olasığı oldukça düşüktür.

#### 28 Eylül 2024 - 29 Eylül 2024

##### Dil Kavramı

>İletişimde kullanılan sembollere dil denir. Dilin kurallarına gramer denir. Bir olgu en az aşağıdaki iki özelliğe sahipse bir dildir:
>**- Syntax:** Dilin öğelerinin doğru dizilimine denir. Örneğin "I am a programmer" cümlesinde dilin öğeleri doğru dizilmiştir. Cümle "am a programmer I" biçiminde yazılmış olsaydı syntax olarak hatalı olurdu.
>**- Semantic:** Doğru dizilmiş öğelerin anlamına denir. Öğeler doğru dizilse bile cümle anlamlı değilse yine hatalıdır
>
>Doğal dillerde syntax ve semantic dışında da öğeler bulunur. Bilgisayar bilimlerinde kullanılmak üzere tasarlanmış dillere bilgisayar dilleri (computer languages) denir. Bir bilgisayar dili akış (flow) içeriyorsa, o dile programlama dili (programming language) denir. Bu anlamda her programlama dili bilgisayar dilidir ancak her bilgisayar dili bir programlama dili olmayabilir. Örneğin, XML ve HTML programlama dilleri değildir ancak bilgisayar dilleridir. Bu anlamda Java akış içerdiğinden bir programlama dilidir. 
>
>Programlama dilleri zaman içerisinde birbirlerinden esinlenmişlerdir. Hatta bazı programlama kalıpları da bazı dillerden alınarak kullanılmaktadır. 
##### Programlama Dillerinin Sınıflandırılması

>Programlama dilleri çeşitli biçimlerde sınıflandırılabilse de genel olarak 3 şekilde sınıflandırma eğilimi söz konusudur:
>**- Seviyelerine göre sınıflandırma:** Programlama dilinin seviyesi (level) onun insan algısına yakınlığının bir ölçüsüdür. Yüksek seseviyeli diller (high level languages) hem dil özellikleri, hem de uygulama geliştirme anlamında insan algısına yakınlıkları dolayısıyla genel olarak daha kolay öğrenilirler. Düşük seviyeli diller (low level languages) makineye daha yakın dillerdir. Olabilecek en düşük seviyeli dil makine dilidir (machine language).
>
>**- Programlama modeline göre sınıflandıma:** Bir programı yazarken kullanılan genel model önemlidir. Bazı dillerde sınıf yoktur. Program çeşitli alt programların (function) bir araya getirilmesiyle yazılır. Bu modele "procedurel model" denir. Bazı dillerde sınıflar vardır ve programlar sınıflar kullanılarak yazılır. Bu modele "nesne yönelimli model (object oriented model)" denir. Bazı dillerde programlar matematiksel formül yazıyormuş gibi yazılır. Bu tarz programlama modeline "fonksiyonel model (functional model)" denir. Bazı diller birden fazla modeli desteklerler. Bu tarz dillere "multi-paradigm languages" denilmektedir. Birden fazla modeli destekleyen diller, modellerin tüm özelliklerini desteklemeyebilirler. 
>
>**- Kullanım alanına göre sınıflandırma:**  Dilin hangi alanlarda kullanılabileceğine göre sınıflandırmadır. Bazı diller birden fazla alanda kullanılabilirler. Bazı diller ise sadece bir alanda kullanılabilirler. Bu anlamda genel amaçlı diller, bilimsel ve mühendislik dilleri, veritabanı dilleri, oyun ve animasyon dilleri, yapay zeka dilleri vb. alanlar için diller söz konusu olabilmektedir.
>
>Buna göre Java, bilimsel ve mühendislik alanlarında, web uygulamalarında, yapay zeka uygulamalarında, mobil programlamada vb. kullanılabilen genel amaçlı, yüksek seviyeli, nesne yönelimli programlama modeli ile uygulama geliştirilebilen ve özellikle Java 8 ile birlikte fonksiyonel programlama modelinin de belirli ölçüde kullanılabildiği multi-paradigm bir dildir.
>
>**Anahtar Notlar:** Bir dilin bir çok alanda kullanılması, pratikte de ilgili alanda kullanılacağı anlamına gelmez. Bir alanda daha etkin kullanılabilen bir dil varsa o dil daha fazla tercih edilebilir.
>**Anahtar Notlar:** Yukarıda anlatılan kavramların detayları vardır. Zaman içerisinde anlaşılacaktır.

##### Temel Kavramlar

> **Çevirici Programlar, Derleyiciler ve Yorumlayıcılar:** Bir dilde yazılmış olan programı başka bir dile çeviren programlara çevirici program (translator) denir. Çevirici programlarda bir kaynak dil (source language) ve bir hedef dil (target/destination language) vardır. Kaynak dil yüksek seviyeli, hedef dil düşük seviyeli ise bu durumda çevirici programa derleyici (compiler) denir. Örneğin Java programlama dilinden Kotlin programlama diline dönüştürme yapan program bir translator, Java programlama dilinden BC'ye dönüştüren program ise bir derleyicidir. JVM'in BC'yi makine koduna dönüştürme faaliyeti de bir derleme işlemidir. Bu sebeple buna JIT compilation denir. Bazı dillerde yazılan programlar herhangi bir kod üretilmeden çalıştırılırlar. Bu tarz çalıştırma yapan programlara yorumlayıcı (interpreter) denir. Bazı diller hem derleyici ile hem de yorumlayıcı ile kullanılabilirler. Java pratikte derleyici ile kullanılan, Java 11 ile birlikte yorumlayıcı ile de kullanılabilebilen bir programlama dilidir. Yorumlayıcı ile kullanımı bu kursta ele alınmayacaktır. Yorumlayıcı ile kullanılan diller derleyici ile kullanılan dillere göre daha yavaş olma eğilimindedir. 
> 
>**Anahtar Notlar:** Bir uygulama tek bir java dosyasında oluşmak zorunda değildir. Hatta bir Java uygulaması yalnızca Java kodlarında da oluşmak zorunda değildir. Bu durumda farklı Java dosyaları ayrı ayrı derlenir. Hattı aynı dosyada bulunan farklı sınıflar bile ayrı ayrı derlenir. Bir ürün aslında tüm birimlerinin uygun şekilde derlenmesi ve ele alınması ile elde edilir. Bu işlem için genel olarak "build" terimi kullanılır. Build işlemi yalnızca derleme işlemi değildir. Yani bir uygulamanın ürün olarak elde edilme süreci build işlemidir. Burada anlatıların detayları konular içerisinde ele alınacaktır.
>
>**İşletim Sistemi:** İşletim sistemi (operating system) makinenin donanımını yöneten, bilgisayar ile kullanıcı arasında bir köprü oluşturan yazılımdır. Bir işletim sisteminin pek çok görevi vardır. Programları çalıştırmak, çeşitli cihazları ve aygıtları yönetmek, dosyaları ve dizinleri  (directory) organize etmek vb. görevler sayılabilir. İşletim sistemleri genel olarak iki gruba ayrılabilir: **masaüstü işletim sistemleri (desktop operating systems), mobil işletim sistemleri (mobile operating systems).** Şüphesiz başka çeşit işletim sistemleri de vardır. Popüler masaüstü işletim sistemleri Windows, Mac OS X, Unix ve Linux dağıtımları gibi işletim sistemleridir. Popüler mobil işletim sistemleri Android ve IOS'dur.
>
>**Açık kaynak kodlu yazılım, özgür yazılım ve mülkiyete sahip yazılım:** Özgür yazılım (free software) ve açık kaynak kodlu (open source) yazılımlar arasında farklar olsa da genel olarak aşağıdaki ortak özelliklere sahiptirler:
>- Bedavadır. Kullanılabilmesi için herhangi bir lisans gerekmez.
>- Kaynak kodlar sahiplenilemez. Kaynak koda ekleme yapıldığında ya da bir kaynak kod kullanıldığında kodlar kapatılamaz. Onların da açılması gerekir.
>- Çoğaltılabilir, izin almadan kullanılabilir.
>
>Bunun tam tersi olarak mülkiyete sahip (propriatery) yazlımlardır. Bu yazılımlar para verilerek kullanılır ve izin almadan çoğaltılamaz.
>
>**IDE (Integrated Development Environment):** Derleyicler ve yorumlayıcılar komut satırından çalışan ve basit arayüzlere sahip programlardır. Aslında teorik olarak bir uygulamadaki tüm Java dosyaları ve diğer dosyalar basit bir editör programla yazılıp komut satırından derlenebilir. Ancak bu, uygulama büyüdükçe zahmetli olmaya başlar. Bu da programcıya zaman kaybettirir. Bu amaçla pratikte yazılım geliştirmeyi kolaylaştırmak için IDE denilen yazılımlar kullanılır. IDE'lerde örneğin bir takım yardımlar veren editörler, tasarım araçları, test araçları, debug araçları vb. programcının geliştirme sırasında kullandığı araçlar bulunur. Java ile uygulama geliştirmede iki tane IDE yoğun olarak kullanılmaktadır: **Eclipse, IntelliJIDEA**. Biz kursumuzda belirli bir zaman (yaklaşık kursun yarısına kadar) Eclipse, sonrasında IntelliJIDEA kullanacağız.

>**Sembollerin ingilizce karşılıkları

| Sembol | İngilizce Karşılığı                         			|
|--------|------------------------------------------------------|
| +      | plus                                        			|
| -      | minus, hyphen, dash                         			|
| *      | asterisk                                    			|
| /      | slash                                       			|
| \      | backslash                                   			|
| .      | period, dot                                 			|
| ,      | comma                                       			|
| :      | colon                                       			|
| ;      | semicolon                                   			|
| “      | double quote                                			|
| '      | single quote                                			|
| (...)  | parenthesis left, right, opening, closing   			|
| [...]  | (square) parenthesis left, right, opening, closing	|
| {...}  | brace left, right, opening, closing 					|
| =      | equal sign                                  			|
| &      | ampersand                                   			|
| ~      | tilda                                       			|
| @      | at                                          			|
| <...>  | less than, greater than, angular bracket    			|
| ^      | caret                                       			|
| \|     | pipe                                        			|
| _      | underscore                                  			|
| ?      | question mark                               			|
| #      | sharp, number sign                          			|
| %      | percent sign                                			|
| !      | exclamation mark                            			|
| $      | dollar sign                                 			|
| ...    | ellipsis                                    			|

##### JDK Kurulumu ve Bilgisayarın Geliştirme için Hazır Hale Getirilmesi

JDK'nın kurulumu için işletim sistemine aşağıdaki bağlantıdan ilgili "installer" program elde edilebilir:

[[https://www.oracle.com/tr/java/technologies/downloads/#jdk21-windows]]

Burada LTS olması açısından minimum Java 17 kurulması önerilir. Ancak kursumuzda Java 21 özellikleri de belirli ölçüde ele alınacağından kurulumu uygun olabilir.  Kurulum aşamasından sonra java ve javac programları -version seçeneği ile çalıştırılarak versiyon kontrolü yapılabilir:`java -version`, `java -version`.

##### 5 Ekim 2024

>Aşağıdaki programı çalıştırmak için JDK'nın kurulu olan bir bilgisayarda aşağıdaki işlemlerin yapılması gerekir:
>
>1. Herhangi bir dizinde (directory) csd isimli bir dizin açılır. Buradaki csd isminin tamamı küçük harf olacak şekilde yazılacaktır.
>
>2. csd dizini içerisinde App.java isimli bir dosya açılır. Windows sisteminde uzantılar gizlenmişse görünür hale getirip uzantının .java olarak değiştirilmesi gerekir. Buradaki dosya isminin App.java biçiminde yazılması gerekir.
>
>3. Komut yorumlayıcı program (command promt/terminal/shell) ile csd directory'sinin bulunduğu dizine geçilir. Dizin geçişi için `cd` komutu kullanılır. Örneğin `cd D:\Repositories\Java-Sep-2024\src\src-console`
>
>4. Herhangi bir editör program ile App.java dosyasının içerisine aşağıdaki programı yazınız.
> 
>5. Komut yorumlayıcı programda, csd'nin bulunduğu dizinde aşağıdaki komutları çalıştırarak derleme işlemi yapılır:
> `javac csd/App.java` -> Windows dışı sistemler için 
> `javac csd\App.java` -> Windows sistemi için
> Derleme işleminde herhangi bir hata (error) mesajı alınmazsa derleme işlemi başarılıdır ve App.class isminde byte code üretilir.
>
>6. Komut yorumlayıcı programda aşağıdaki biçimde byte code çalıştırılır:
>
>`java csd.App`
>
>**Anahtar Notlar:** Buradaki bazı zorunluluklara ilişkin detaylar konular içerisinde ele alınacaktır.

```java
package csd;

class App {
	public static void main(String [] args) 
	{
		System.out.println("Hello, World");
	}
}
```

**Anahtar Notlar:** Bir program için programcı açısından iki durum söz konusudur: **Derleme Zamanı (compile time), Çalışma zamanı (runtime)**. Derleme zamanı, derleme işlemine ilişkin süreçtir. Çalışma zamanı, programın çalıştırılmasına ilişkin süreçtir. Bu iki zaman birbirleriyle ilişkili bile olsa ayrı zamanlar ve kavramlar oldukları unutulmamalıdır.
##### Derleyicinin Verdiği Mesajlar

>Derleyiciler koda ilişkin bazı teşhis mesajları (diagnostics) verebilirler. 
>Derleyicilerin mesajları 3 gruba ayrılır:
>1. **Gerçek hatalar (errors):** Syntax veya semantic olarak geçersiz bir durumda derleyicinin verdiği mesajlardır. Bu durumda BC üretilmez. Programcının hatay yol açan kodları düzeltmesi ve derleme işlemini yeniden yapması gerektir.
>2. **Uyarılar (warnings):** Programcının olası programlama hatalarına yönelik mesajlardır. Uyarı mesajları arakodun üretimini engellemez. Programcı uyarı mesajlarını dikkate almalıdır. Özel bir durum yoksa uyarı mesajlarına yol açan durumlar ortadan kaldırılmalıdır. Bazı dıurumlarda programcının kullandığı bazı static kod analizi araçları da derleyici dışında bazı uyarılar verebilirler. Programcı bunları da mutlaka dikkate almalıdır ancak hepsinin ortadan kaldıılması gerekmeyebilir. Pratikte bir ürünün nihai (release) versiyonunda derleyicin tüm uyarı mesajlarının kaldırılmış olması gerekir. 
>3. **Ölümcül hatalar (fatal errors):** Derleme işleminin dahi tamamlanamadığı hatalardır. Örneğin derlenecek dosyanın bulunaması, erişim yetkisinin olmaması vb. durumlardır. Bu durumda programcı ölümcül hataya yol açan durumları oratadan kaldırıp derleme işlemini yapmalıdır. yani ölümcül hata durumunda programcının kodu ile ilgili bir durum yoktur.
>
>Derleme işleminin herhangi bir uyarı vermeden başarılı olması durumunda derleyiciler genel olarak hiç mesaj vermezler. Bazı derleyiciler işlemin başarılı olduğuna yönelik ya da firmaya ilişkin bilgi mesajları verebilirler. Bunlar genel teşhis mesajları kategorisine girmezler. Örneğin Oracle'ın javac derleyicisi hiç bir uyarı mesajı da yoksa hiç bir mesaj vermez.  
>
>Programın çalışma zamanında oluşan hatalı durumlara **exception** ya da **runtime error** denilmektedir. Exception handling konusuna kadar bir exception oluştuğunda program abnormal bir biçimde sonlanır olarak düşüneceğiz.

##### Atom (Token)
>Programlama dilinin bölünemeyen en küçük birimine atom denir. Java programlama dilinde atomlar şunlardır:
>- **Anahtar Sözcükler (keywords/reserved words):** Derleyicinin bildiği, tanıdığı sözcüklerdir. Anahtar sözcükler tek başına değişken ismi olamazlar.  Örneğin: `package`, `int`,  `void`, `static`
>- **Değişkenler (variables/identifiers):** İsmini programcının belirlediği ve belirli kurallara göre isimlendirilebilen atomlardır. Örneğin: `csd`, `App`, `String`
>- **Sabitler (literals/constants):** Program içerisinde doğrudan yazılan değerler denir. Örneğin: `67`, `3.4`
>- **Operatörler (operators):** Belirli bir işleme yol açan ve işlemin sonucunda bir değer üreten atomlara denir. Örneğin, `a + b` ifadesinde + bir operatördür, `!b` ifadesinde ! bir operatördür
>- **String'ler (strings/string literals):** İki tane iki tırnak (double quote) içerisinde yazılan yazılara tırnaklarıyla birlikte string ya da string literal denir. Örneğin `"Hello, World"`
>- **Ayraçlar (delimiters/punctuators):** Yukarıdakiler dışında kalan atomlara denir. Örneğin: `{` `}`, `(` `)`
>**Anahtar Notlar:** Derleme işlemi atomlara ayırmakla (tokenizing) ile başlar.
>
>**Anahtar Notlar:** Klavyeden tuşlandığında boşluk algısı yaratan karakterlere boşluk karakterleri (whitespaces) denir. Klavyeden tuşlanabilen tipik boşluk karakterleri şunlardır: `SPACE`, `TAB(ULAR)`, `ENTER`
>Java'da kod yazım kuralları şu şekilde özetlenebilir:
>- Atomlar arasında istenildiği kadar boşluk bırakılabilir
>- Anahtar sözcükler ve değişken atomlar kendi aralarında bitişik yazılamazlar, diğer tüm atomlar bitişik yazılabilirler


>Atomlar arasında istenildiği kadar boşluk bırakılabilir

```java
package csd;

class App {
	public static 					void main(					String [] args) 
	{
		




System.



out.


println("Hello, World");
	}
}
```

>Anahtar sözcükler ve değişken atomlar kendi aralarında bitişik yazılamazlar, diğer tüm atomlar bitişik yazılabilirler

```java
package csd;class App{public static void main(String[]args){System.out.println("Hello, World");}}
```

>Anahtar sözcükler ve değişken atomlar bitişik yazılamazlar. Aşağıdaki kodda error oluşur
```java
packagecsd;class App{public static void main(String[]args){System.out.println("Hello, World");}} 
```

>Programlamada derleyicinin görmezden geldiği kod parçalarına yorum satırları (comment lines) denir. Java'da iki çeşit yorum satırı yazılabilir. Yorum satırları okunabilirliği/algılanabilirliği olumsuz olarak etkilemeyecek şekilde koda eklenmelidir.

```java
package csd;

class App {
	public static void main(String [] args) 
	{
		System.out.println("Hello, World"); //Burayı derleyici görmez
		/*
			Burayı da 
			derleyici görmez
		*/
	}
}
```

##### 6 Ekim 2024

##### Eclipse IDE Programı

>Eclipse Java'nın ilk yıllarından beri free olarak kullanılabilen bir IDE programdır. Eclipse her desktop işletim sisteminde çalışabilen bir programdır. Eclipse,  [Eclipse](http://www.eclipse.org)link'inde indirilip kurulabilir. Biz kursumuzda Eclipse ile açılmış tek bir proje üzerinde çalışacağız. Eclipse ile bir Hello, World programını çalıştırmak üzere bir proje açmak için işlemler şu şekilde yapılabilir:
>1. Wokspace için bir dizin belirenir
>2. Bir Java projesi açılır. Örneğin File -> New -> Java Project seçilebilir
>3. Açılan pencerede proje ismi yazılmalıdır. Biz burada `Sample` ismini, vereceğiz. Yine bu pencerede JRE altındaki `Use an execution environment JRE` en az JavaSE 17 olarak seçilmelidir. Yine aynı pencerede `Module` altındaki `Create module-info.java file` seçeneği kaldırılmalıdır. 
>4. Bir java dosyası eklemek için src dizininde New -> Class menüsü seçilebilir.
>5. Açılan pencede package text alanına csd, Name text alanına da App yazılmalıdır. 
>6. Bu işlemden program yazılarak çalıştırılabilir. Çalıştırmak pek çok yöntem vardır. Herhangi bir tanesi tercih edilebilir. Program çalıştırıldığıdan Eclipse kendi Console penceresi açarak ilgili çıktıları orada gösterir.
>
>**Anahtar Notlar:**  Aslında çalıştırma işlemi derleme işleminden sonra yapılmaktadır. Eclipse'de `build automatically` seçili ise her kod yazımında buil işlemi dolayısıyla derleme işlemi yapılır ve error oluşmazsa arakod üretilir. Eğer `build automatically` seçili değilken çalıştırılırsa önce build işlemi yapılır sonra üretilen arakod çalıştırılır.
>
>**Anahtar Notlar:** Bir IDE programda bir işlemi yapmanın birden fazla yöntemi olabilir ve genelde de birden fazla yönetimi vardır. Yukarıdaki proje açma aşamaları dışında da yöntemler bulunmaktadır.

##### Genel Biçim Anlatım Notasyonu

>Bir dilin kurallarının genel biçimlerini anlatmaya yönelik pek çok notasyon bulunmaktadır. Biz burada genel olarak "açısal parantez-köşeli parantez" tekniğini kullanacağız.  Bu teknikte zorunlu olarak bulunması gerekenlere açıklamada açısal parantezler içerisinde yazılır. Seçenekli (optional) olması durumunda ise köşeli parantezler arasında yazılır. Herhangi bir paranteze alınmayanlar da aynı şekilde bulunması gerekenler olacaktır. Ayrıca `//...` şeklinde kullanım durumunda "burada bir takım kodlar bulunabilir ancak şu an bizi ilgilendirmiyor" anlamına gelecektir. Yaklaşık 20 yıldır programlaya ilişkin kaynaklar, bir konuyu anlatırken uydurma bazı isimler kullanabilmektedir: foo, bar, tar, car, zar vb. Biz de gerektiğnde bu isimleri kullanacağız. 
##### Bildirim (Declaration)

Bir ismin derleyiciye tanıtılmasına **bildirim (declaration)** denir.

##### Hello  World Program Genel Açıklaması

>Bir java programı genel olarak paketlerden (package), paketler sınıflardan (class), sınıflar da metotlardan (method) oluşur.
>Paket bildiriminin genel biçimi şu şekildedir:
>
```java
package <paket ismi>
```

>Burada paket ismi daha sonra ele alacağımız değişken isimlendirme kurallarına uygun olmalıdır. Paketler konusu ileride çok detaylı bir biçimde ele alınacaktır. Biz paketler konusuna gelene kadar csd isimli bir paket altında çalışacağız. Bunula birlikte yine paketler konusuna gelene kadar tek bir java dosyası ile çalışacağız.
>
>Sınıf bildiriminin genel biçimi şu şekildedir:

```java
[bildirme ilişkin bazı anahtar sözcükler] class <sınıf ismi> {
	//...
}
```

>Burada sınıf ismi yine değişken isimlendirme kurallarına uygun bir isim olmalıdır. Sınıf bildiriminin detayları konular içerisinde ele alınacaktır. Sınıf kavramı Nesne Yönelimli Programlamanın (Object Oriented Programming) temel taşlarından biridir.

>Java'da alt programlara **metot (method)** denir. Metot bildirimi (method declaration) alt programın kıdlarının yazılmasıdır. Bir metot bildirildikten sonra kodlarının çalıştırılabilmesi için **çağrılması (call/invoke)** gerekir. Metot bildiriminin genel biçimi:


```java
[erişim belirleyici] [static] <geri dönüş bilgisi> <metot ismi>([parametreler])
{
	//...
}
```

>Erişim belirleyici şunlardan biri olabilir: **public, protected, no-modifier, private**.  İlgili konuya gelene kadar tüm metotlarımızı public olarak bildireceğiz. Bir metot **static** veya **no-static** olabilir. static anahtar sözcüğü ile bildirilenler static, bildirilmeyenler non-static olur. İlgili konuya gelene kadar tüm metotları static olarak bildireceğiz. Bir metodun **geri dönüş değeri (return value)** olabilir ya da olmayabilir. Bir metodun geri dönüş değeri yoksa geri dönüş bilgisi yerine **void** anahtar sözcüğü yazılır. Hiç bir şey yazılmaması geçersizdir.  Metot ismi değişken isimlendirme kuralların uygun bir isim olmalıdır. Bir metodun parametreleri olabilir ya da olmayabilir. Metot parametreleri ileride ele alınacaktır. `{` ile `}` arasında kalan kod bölümüne **metodun gövdesi (method body)** denir. Metodun ne iş yaptığı yani kodları buraya yazılır.

##### 12 Ekim 2024

>static bir metodun çağrılmasının genel biçimi şu şekildedir:

```java
[paket ismi].[sınıf ismi].<metot ismi>([argümanlar]);
```

> Argüman kavramı ileride ele alınacaktır. **Bir metot çağrıldığında akış metodun kodlarına dallanır. Çağrılan metodun kodları çalıştırılır. Metot çağrısı bittiğinde akış çağrılan noktaya geri döner.** Akış main metodundan başlar. Akışın başladığı main metoduna **entry point** denir.  main metodu `java` programı tarafından (yani JVM) tarafında çağrılır. Özel bazı durumlar dışında main metodu bittiğinde program sonlanır. print ve println metotları aldıkları değerleri ekrana basmak için kullanılan standart metotlardır. Bu metotlar bir imleç (cursor) ile çalışırlar. İmlecin bulunduğu yere yazma yaparlar ve yazdıkları karakter kadar imleci ilerletirler. print metodu imleci yazdığı son karakterden sonraki konumda bırakır. println metodu yazdığı son karakterden sonra imleci bir sonraki satırın (line) başında bırakır. 

**Anahtar Notlar:** Aslında teknik olarak print ve println metotları ekrana yazma yapmazlar. Bu metotlar **standard output (stdout)** denilen bir dosyaya yazma yaparlar. stdout dosyası nereye yönlendirilmişse (redirection) yazma oraya yapılır. Bu durumda stdout dosyası ekrana yönlendirilmişse bu metotlar ekrana yazma yaparlar. Kursumuzda basitleştirmek için ekrana basma ya da ekrana yazdırma biçiminde kullanacağız. Benzer şekilde klavyeden okuma yapan metotlar okumayı **standard input (stdin)** denilen dosyadan yaparlar. stdout klavyeye yönlendirildiğinde okuma klavyeden yapılmış olur. Kursumuzda basitleştirmek için klavyeden okuma biçiminde kullanacağız. Masaüstü işletim sistemlerinin hemen hepsinde default olarak stdout ekrana, stdin de klavyeye yönlendirilmiştir. Ayrıca IDE'ler stdout'u kendi console pencerelerine yönlendirebilirler. 

**Anahtar Notlar:** print ve println metotları aslında non-static metotlardır. Bu anlamda System bir sınıf, out PrintStream türünden bir referans değişkendir. Bu kavramların detayları konular içerisinde ele alınacaktır. 

>Aşağıdaki örneği çalıştırıp sonucu gözlemleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Hello, World");	
		csd.Sample.foo();	
		csd.Sample.bar();	
		System.out.println("Goodbye, World");	
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("foo");		
		csd.Sample.bar();		
		//...	
	}
	
	public static void bar()
	{	
		System.out.println("bar");		
		csd.Mample.tar();		
		//...	
	}
}

class Mample {
	public static void tar()
	{	
		System.out.println("tar");	
		//...	
	}
}
```

> Çağıran metodun (caller) ait olduğu sınıf ile çağrılan metodun (callee) ait olduğu sınıf aynı paket içerisindeyse, çağrı sırasında paket ismi kullanmaya gerek yoktur. Çağıran metot ile çağrılan metot aynı sınıf içerisindeyse çağrı sırasında paket ismi kullanılmamışsa sınıf ismi de yazmaya gerek yoktur. Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Hello, World");	
		Sample.foo();	
		Sample.bar();	
		System.out.println("Goodbye, World");
	}

}

class Sample {
	public static void foo()
	{
		System.out.println("foo");		
		bar();
		
		//...
	
	}
	
	public static void bar()
	{	
		System.out.println("bar");		
		Mample.tar();		
		//...	
	}

}

class Mample {
	public static void tar()
	{	
		System.out.println("tar");	
		//...	
	}
}
```

##### Sayı Sistemleri

>Biz 10'luk sistemi **(decimal system)** kullanmaktayız. 10'luk sistemde sayıları ifade etmek için 10 sembol vardır:
>
>		0
>		1
>		2
>		3
>		4
>		5
>		6
>		7
>		8
>		9
>10'luk sistemde sayının her bir basamağı 10'nun kuvvetleriyle çarpılıp toplanmaktadır. Örneğin:
>
>		123.25 = 3 * 10^0 + 2 * 10^1 + 1 * 10^2 + 2 * 10^-1 + 5 * 10^-2
>Halbuki bilgisayarlar 2'lik sistemi **(binary system)** kullanmaktadır. 2'lik sistemde sayıları ifade etmek için 2 sembol kullanılmaktadır:
>
>		0 
>		1
>2'lik sistemde sayının her bir basamağına "bit (binary digit)" denilmektedir. 2'lik sistemde sayının her basamağı 2'nin kuvvetiyle çarpılarak sayı elde edilir. **Bit (binary digit)** en küçük bellek birimidir. 8 bite 1 byte denilmektedir. Genellikle bitler 4'erli gruplanarak yazılırlar. Örneğin:
>
>		1010 0010
>		
>Burada 1 byte'lık bir bilgi vardır. Byte temel bellek birimidir.
>
>Byte da küçük bir birimdir. Kilo diğer bilimlerde "1000 katı" anlamına gelmektedir. Ancak bilgisayarlar 2'lik sistemi kullandığj için 1000 katı iyi bir kat değildir. Bu nedenle genel olarak Kilo byte için 2'nin 10'uncu kuvveti olan 1024 katı kullanılır. Yani 1KB (kısaca 1K) 1024 byte'tır. Mega diğer bilimlerde kilonun 1000 katıdır. Dolayısıyla milyon kat anlamına gelmektedir. Ancak bilgisayar bilimlerinde genel olarak mega kilonun 1024 katı olarak alınır. Bu durumda 1 MB = 1024 x 1024 (2^20) byte'dır. Giga ise meganın 1024 katıdır. Bu durumda 1 GB = 1024 x1024 x 1024 byte'tır ( 2^30). Giga'dan sonra tera, tera'dan sonra peta, ondan sonra da exa gelmektedir.
>
>1 byte içerisinde yazılabilecek en küçük ve en büyük sayılar şöyledir:
>
>		0000 0000 ---> 0
>		1111 1111 ---> 255
>1 byte içerisinde 1 ve 0'ların bütün permütasyonları 256 tanedir. 2 byte içerisinde en büyük sayıyı yazacak olsak şöyle olurdu:
>
>		1111 1111 1111 1111 ---> 65535
>Biz burada ikilik sistemde tamsayıları ifade ettik. Ama bütün sayıları pozitif kabul ettik. Pekiyi negatif tamsayılar nasıl ifade edilmektedir?
>
>Bugün negatif tam sayıların ifade edilmesi için **ikiye tümleyen (two's complement)** sistemi denilen bir sistem kullanılmaktadır. Bu sistemde pozitif ve negatif sayılar birbirlerinin ikiye tümleyenidirler. İkiye tümleyen **bire tümleyene (one's complement)** bir eklenerek bulunmaktadır. Bir sayının bire tümleyeni sayıdaki 0'ların 1, 1'lerin 0 yapılmasıyla bulunur. Bu durumda ikiye tümleyen şöyle hesaplanır. örneğin aşağıdaki sayının ikiye tümleyenini bulmaya çalışalım:
>
>		0101 0110
>Sayının bire tümleyenine bir ekleyeceğiz:
>
>		1010 1001 + 0000 0001 = 1010 1010
>
>Aslında ikiye tümleyeni bulmanın kolay bir yolu da vardır: Sayıda sağdan sola ilk 1 görene kadar ilk 1 dahil olmak üzere aynısı yazılarak ilerlenir. Sonra 0'lar 1, 1'ler 0 yapılarak devam edilir. Örneğin:
>
>		0101 0110
>		
>sayının ikiye tümleyenini tek hamlede bulalım:
>
>		1010 1010
>		
>Negatif tam sayıları ifade edebilmek için kullanılan ikiye tümleme sisteminde **en soldaki bit (the most significant bit)** işaret bitidir (sign bit). Bu bit 0 ise sayı pozitif, 1 ise negatiftir. **Negatif ve pozitif tam sayılar birbirlerinin ikiye tümleyenidir.** Örneğin bu sistemde +10 yazmak isteyelim. Bunu işaret 0 yaparak yazabiliriz:
>
>		0000 1010	--->	+10
>
>Şimdi -10 yazmak isteyelim. Bunun için +10'un ikiye tümleyenini alalım:
>
>		1111 0110	--->	-10
>		
>Bu sistemde +n ile -n toplandığında 0 elde edilir:
>
>		  0000 1010	+ 1111 0110 = 0000 0000
>		  
>Bu sistemde tek bir sıfır vardır. O da tüm bitleri 0 olan sıfırdır. Bu sistemde 1 byte içerisinde yazılabilecek en büyük pozitif sayı şöyledir:
>
>		0111 1111	--->	+127
>		
>Şimdi bunun ikiye tümleyenini alalım:
>
>		1000 0001	--->	-127
>Pekiyi en küçük (negatif) sayı nedir? Bu sistemde bir tane sıfır olduğuna göre 256 tane permütasyon eşit bölünemez. Demek ki ya pozitif sayılar ya negatif sayılar bir tane daha fazla olmak zorundadır. Bu sistemde ikiye tümleyeni olmayan iki sayı vardır:
>
>		0000 0000 
>		1000 0000
>Birincisi 0'dır. İkinci sayı -127'den bir eksik olan sayıdır. O halde bu sayının -128 kabul edilmesi daha uygundur.
>
>Demek ki bu sistemde n byte içerisinde yazılabilecek en büyük pozitif sayı ilk biti 0 olan diğer tüm birleri 1 olan sayıdır. En küçük (negatif) sayı ise ilk biti 1 olan diğer tüm bitleri 0 olan sayıdır. Örneğin bu sistemde iki byte ile yazabileceğimiz en büyük pozitif sayı şöyledir:
>
>		0111 1111 1111 1111	--->	+32767
>		
>En küçük negatif sayı ise şöyledir:
>
>		1000 0000 0000 000	--->	-32768
>Bu sisteme ilişkin tipik sorular ve yanıtları şöyledir:
>
>**SORU**: Bu sistemde +n sayısını nasıl yazarsınız?\
>**CEVAP:** En soldaki bit 0 yapılıp n sayısı 2'lik sistemde yazılır.
>
>**SORU:** Bu sistemde -n nasıl yazarsınız?\
>**CEVAP:** Yazabiliyorsanız doğrudan yazın. Ancak doğrudan yazamıyorsanız önce +n değerini yazın ve ikiye tümleyenini alın. Örneğin bu sistemde -1 yazalım. Önce +1 yazalım:
>
>		0000 0001	--->	+1
>Şimdi bunun ikiye tümleyenini alalım:
>
>		1111 1111	---->	-1
>		
>**SORU:** Bu sistemde bir sayının kaç olduğu bize sorulsa bunu nasıl yanıtlarız?\
>**CEVAP:** Eğer en soldaki bit 0 ise sayının değeri doğrudan hesplanır. Eğer en soldaki bit 1 ise bu sayının negatif olduğunu gösterir. Bu durumda sayının ikiye tümleyeni alınır. Pozitifinden hareketle negatifi bulunur.
>Örneğin 1110 1110 sayısı kaçtır? Burada işaret biti 1 olduğuna göre sayı negatiftir. Negatif ve pozitif sayılar birbirlerinin ikiye tümleyenidirler. O zaman bu sayının ikiye tümleyenini alıp pozitifinden faydalanarak sayıyı bulalım:
>
>		0001 0010	--->	+18
>		
>o zaman bize sorulan sayı -18'dir.
>
>Bu sistemde örneğin 1 byte içerisinde yazılabilecek en büyük pozitif sayıya 1 ekleyelim:
>
>		0111 1111	--->	+127
>		1000 0000	--->	-128
>		
>Demek ki bu sistemde bir sayıyı üst limitten taşırırsak yüksek bir negatif sayıyla karşılaırız. Benzer şekilde alt limitten taşırırsak yüksek bir	pozitif sayı ile karşılaşırız
>
>Tamsayılar ikilik sistemde **işaretsiz (unsigned)** ya da **işaretli (signed)** sistemde yorumlanabilirler. İşaretsiz sistemde sayının en soldaki biti işaret biti olarak yorumlanmaz. Sayı herzaman sıfır ya da pozitiftir. İşaretli sistemde ise sayının en solundaki biti işaret bitidir. Sayı ikiye tümleyen aritmetiğine göre yorumlanır.
>
>İşlemciler aslında genellikle işaretli ve işaretsiz ayırımını yapmazlar. Çünkü ikisi de aslında aynı biçimde işleme sokulmaktadır. Sonucun yorumu değişmektedir.
>
>Pekiyi noktalı sayılar ikilik sistemde nasıl ifade edilmektedir? İşte insanlar noktalı sayıları ifade etmek için iki format geliştirmişlerdir. Bunlardan birine **sabit noktalı formatlar (fixed point formats)** diğerine **kayan noktalı formatlar (floating point formats)** denilmektedir. Sabit noktalı formatlar eski devirlerde basit bir mantıkla tasarlanmıştır. Bu formatlar bugün hala kullanılıyor olsa da büyük ölçüde artık bunların çağı kapanmıştır. Bugün kayan noktalı format denilen formatlar kullanılmaktadır.
>
>Sabit noktalı formatlarda noktalı sayı için n byte yer ayrılır. Noktanın yeri önceden bellidir. Örneğin sayı 4 byte ile ifade edilsin. Noktanın yeri de tam ortada olsun. Bu durumda sayının tam kısmı 2 byte ile noktalı kısmı 2 byte ile ifade edilir. Ancak sayının noktalı kısmı 2'nin negatif kuvvetleriyle kodlanmaktadır. Böylece iki sabit noktalı sayıyı paralel toplayıcılarla kolay bir biçimde toplayabiliriz: Örneğin bu sistemde 5.25 ile 6.25 sayılarını ifade edip toplayalım:
>
>		0000 0000 0000 0101 . 0100 0000 0000 0000	--->	5.25
>		0000 0000 0000 0110 . 0100 0000 0000 0000	--->	6.25
>		-----------------------------------------
>		0000 0000 0000 1011 . 1000 0000 0000 0000	--->	11.5
>Pekiyi bu yöntemin ne dezavantajı vardır? Yöntemin en önemli dezavantajı dinamik olmamasıdır.
>
>Sabit noktalı formatların dinamik olmaması nedeniyle kayan noktalı formatlar geliştirilmiştir. Bu formatlarda noktanın yeri sabit değildir. Noktanın yeri format içerisinde ayrıca tutulmaktadır. Noktalı sayının noktası yokmuş gibi ifade edilmesi durumunda sayının bu haline **mantis (mantissa)** denilmektedir. İşte kayan formatlarda sayı için ayrılan alanın bir bölümünde mantis bir bölümünde de "noktanın yeri" tutulmaktadır. Noktanın yerini belirleyen kısma **üstel kısım (exponential part)** denilmektedir. Tabii bir de sayının başında işaret biti bulunur. Bu durumda kayan noktalı bir sayının format aşağıdakine benzerdir:
>
>		`[işaret biti] [mantis] [noktanın yeri (exponential)]`
>		
>Bugün ağırlıklı kullanılan kayan noktalı format `IEEE 754` denilen formattır. Bu formatın üç farklı genişlikte biçimi vardır:
>
>		IEEE 754 - Short Real Format 	(4 byte)
>		IEEE 754 - Long Real Format 	(8 byte)
>		IEEE 754 - Extended Real Format (10 byte)
>		
>Bugün Intel, ARM, MIPS, Alpha, Power PC gibi yaygın işlemciler donanımsal olarak bu formatı desteklemektedir. Aynı zamanda bu format yaygın olarak Reel Sayı Ünitesi olmayan mikro denetleyicilerdeki derleyiciler tarafından da kullanılmaktadır.
>
>Kayan noktalı formatların (örneğin IEEE 754 formatının) en ilginç tarafı **yuvarlama hatası (rounding error)** denilen durumdur. Yuvarlama hatası	noktalı sayının tam olarak ifade edilemeyip onun yerine ona yakın bir sayının ifade edilmesiyle oluşan hatadır. Yuvarlama hatası sayıyı ilk kez depolarken de oluşabilir, aritmetik işlemlerin sonucunda da oluşabilir. Tabii noktalı sayıların bir bölümü bu formatta hiçbir yuvarlama hatasına maruz kalmadan ifade edilebilmektedir. Ancak bazı sayılarda bu hata oluşabilmektedir. Bu hatayı ortadan kaldırmanın yolu yoktur. Tabii sayı için daha fazla bir ayrılırsa yuvarlama hatasının etkisi de azalacaktır.
>	
>Yuvarlama hatalarından dolayı programlama dillerinde iki noktalı sayının tam eşitliğinin karşılaştırılması anlamlı değildir. Örneğin aşağıdaki işlemde	yuvarlama hatasından dolayı sayılar sanki eşit değişmiş gibi ele alınacaktır.
>
>		0.2 + 0.1 == 0.3 (false)
>		
>Pekiyi yuvarlama hatasının önemli olduğu ve bunun istenmediği tarzda uygulamalarda (örneğin finansal uygulamalarda, bilimsel birtakım uygulamalarda) ne yapmak gerekir? İşte bunun tek yolu noktalı sayıları kayan noktalı formatta tutmamak olabilir. Bazı programlama dillerinde noktalı sayıyı kayan noktalı formatta tutmayan böylece yuvarlama hatalarına maruz bırakmayan özel türler (örneğin C#'taki decimal) vardır. Ancak bu türler işlemciler tarafından desteklenmediği için yapay türlerdir. 
>
>Bilgisayar dünyasında çok kullanılan diğer bir sayı sistemi de 16'lık sistemdir. 16'lık sisteme İngilizce **hexadecimal system** denilmektedir. 16'lık sistemde sayıları ifade etmek için 16 sembol bulunmaktadır. İlk 10 sembol 10'luk sistemdeki sembollerden alınmıştır. Sonraki 6 sembol alfabetik karakterlerden alınmıştır:
>
>		0
>		1
>		2
>		3
>		4
>		5
>		6
>		7
>		8
>		9
>		A
>		B
>		C
>		D
>		E
>		F
>16'lık sistemdeki her bir basamağa **hex digit** denilmektedir. Örneğin:
>
>		1FC8
>		
>Burada 4 hex digit'lik bir sayı vardır. 16'lık sistemdeki bir sayıyı 10'luk sisteme dönüştürmek için her hex digit 16'lık kuvvetleriyle çarpılıp toplanır. Ancak 16'lık sistemdeki sayı kullanım gereği bakımından aslında 10'lu sisteme pek dönüştürülmez. 16'lık sistemdeki her bir hex digit 4 bit ile ifade edilebilmektedir:
>
>		0	0000
>		1	0001
>		2	0010
>		3	0011
>		4	0100
>		5	0101
>		6	0110
>		7	0111
>		8	1000
>		9	1001
>		A	1010
>		B	1011
>		C	1100
>		D	1101
>		E	1110
>		F	1111
>16'lık sistemden 2'lik sisteme dönüştürme yapmak çok kolaydır. Tek yapılacak şey bir hex digit'e karşılık yandaki tablodaki 4 biti getirmektir. Örneğin:
>
>		1FC9  =  0001 1111 1100 1001
>		FA3D  =  1111 1010 0011 1101
>		
>2'lik sistemdeki bir sayı da 16'lık sisteme çok kolay dönüştürülür. Tek yapılacak şey sayıyı dörderli gruplayıp ona karşı gelen hex digit'i yazmaktır. Örneğin:
>
>		1010 0001 1110 1000 0011 0101 = A1E835
>Bilgisayar dünyasında 16'lık sistem aslında 2'lik sistemin yoğun bir gösterimi olarak kullanılmaktadır. Yani 2'lik sistem çok yer kapladığı için kişiler 2'lik sistem yerine 16'lık sistemi kullanırlar. Bu nedenle belleği, dosyayı gösteren programlar bunları 2'lik sistem yerine 16'lık sistemde gösterirler.
>
>1 byte 2 hex digit ile ifade edilmektedir. Örneğin:
>
>		1A 23 5C 78
>		
>Burada 4 byte'lık bir bilgi vardır. Örneğin 2 byte içerisinde yazılabilecek en küçük negatif işaretli sayının hex karşılığı 8000 biçimindedir. Örneğin bir byte'lık işaretli sistemde yazılabilecek en büyük pozitif sayı 7F biçimindedir. İşareti tamsayı sisteminde 4 byte içerisinde -1 sayısı FFFFFFFF biçimindedir.

>Eskiden daha fazla kullanılıyor olsa da toplamda oldukça seyrek kullanılan diğer bir sayı sistemi de 8'lik sayı sistemidir. Bu sisteme İngilizce **octal system** denilmektedir. 8'lik sayı sistemindeki her bir basamağa **octal digit** denir. Octal digit sembolleri olarak 10'luk sistemin ilk 8 sembolü kullanılmaktadır:
>
>		0
>		1
>		2
>		3
>		4
>		5
>		6
>		7
>Her octal digit 3 bit ile ifade edilebilir:
>
>		0		000
>		1		001
>		2		010
>		3		011
>		4		100
>		5		101
>		6		110
>		7		111
>Bu durumda bir octal sayı 2'lik sisteme kolay bir biçimde dönüştürülebilir:
>
>		476		100 111 110
>		741		111	100	001
>Benzer biçimde 2'lik sistemdeki bir sayı da sağdan sola üçer bir gruplandırılarak 8'lik sisteme dönüştürülebilmektedir. Örneğin:
>
>		1011 1011	=  273
>		0111 1110	=  176
>		
>8'lik sistem de 2'lik sistemin yoğun bir gösterimi olarak kullanılmaktadır. Ancak 8'i tam ortalayamadığı için kullanımı seyrektir.

##### 13 Ekim 2024

##### Tür (type) Kavramı

>Bir değişkenin içerisindeki değerin ne kadar uzunlukta (length) tutulduğunu (yani bellekte o değişken için ne kadar yer ayrılacağını) ve değerin hangi formatta tutulduğunu  belirtir. Java'nın **temel türleri (primitive/built-in/predefined types)** şunlardır:

| Tür ismi | Uzunluk (byte) | Sınır Değerler                                 |
| -------- | -------------- | ---------------------------------------------- |
| short    | 2              | `[-32768, 32767]`                              |
| int      | 4              | `[-2147483648, +2147483647]`                   |
| long     | 8              | `[-9223372036854775808, +9223372036854775807]` |
| byte     | 1              | `[-128, +127]`                                 |
| float    | 4              | `[±3.6 * 10-38, ±3.6 * 10+38]`                 |
| double   | 8              | `[±1.6 * 10-308, ±1.6 * 10+308]`               |
| char     | 2              | `[0, 65535]`                                   |
| boolean  | -              | `true, false`                                  |

>**Açıklamalar:**
>
>- Java'da temel tür isimleri birer anahtar sözcüktür.
>- short, int, long ve byte türlerine **tamsayı türleri (integer/integral types)** denir.
>- Tamsayı türleri için işaretli sistemde ikiye tümleme formatı kullanılır. Java'da işaretsiz tamsayı türü yoktur.
>- double ve float türlerine **gerçek sayı türleri (real types)** denir. Gerçek sayı türleri için `IEEE 754` formatı kullanılır. Bu sebeple türlere **floating point types** da denilmektedir. Bu türlerle yapılan işlemlerde `IEEE 754` standardının çalışma sistemi gereği yuvarlama hataları (rounding error) oluşabilir. Bu yuvarlama hatalarının problem olabileceği uygulamalarda (örneğin  parasal ve finansal uygulamalarda) bu türler kullanılmaz. Bu tarz durumlarda hangi türlerin kullanılacağı ileride ele alınacaktır.
>- Programlamada kullanılan karakterler bir tabloda tutulurlar. Bu tabloya karakter tablosu denilmektedir. Programlamada pek çok karakter tablosu kullanılabilmektedir. Daha önceleri `ASCII` denilen ve 7 bit olarak tutulan ancak daha sonra 8 bit olarak ele alınan bir karakter tablosu vardır. Daha sonraları dünyada kullanılan pek çok karakterin de tutulabilmesi için `UNICODE` isimli bir karakter tablosu kullanılmaya başlanmıştır. `UNICODE` tablosunun ilk 128 karakteri `ASCII` ile aynıdır. `UNICODE` tablosunun da çeşitleri vardır. char türü içerisinde tutulan sayı ilgili tabloda sıra numarası olarak yorumlanır. Yani char türü içerisinde tutulan sayı aslında ilgili karakter tablosunda bir karakterin sıra numarasına karşılık gelir. Bu anlamda char türü `UNICODE` tablosunun 2 byte'ı ile uyumludur. Karakter tablolarına ilişkin detaylar ileride ele alıncaktır.
>- boolean türü mantıksal olarak doğru ve yanlış kavramlarını temsil eden bir türdür. boolean türünden bir değişken iki tane değer alabilir: true, false. Bu tür, örneğin flag değişkenlerde kullanılabilir. boolean türünün uzunluğu `Java Language Specifcation` dokümanında belirtilmemiştir. Zaten iki tane değer aldığı için de uzunluğunun kaç olduğunun programcı açısından önemi yoktur.
>- Her ne kadar 8 tane tür olsa da programcı tamsayı kullanacağı zaman önce int türünü düşünür, int türünün senaryoya uygun olmadığı durumda (örneğin daha fazla değer tutulması gerekirse) diğer türlerden uygun olanı tercih edilmelidir. Benzer şekilde gerçek sayılar için de öncelikle double türü düşünülmeli, duruma göre float türü tercih edilmelidir. Diğer türler (char ve boolean) zaten özel amaçlı türlerdir. Bu anlamda int ve double türlerine **default types** da denilmektedir
>- Java'da boolean türü dışında kalan temel türlerin uzunlukları her sistemde aynıdır. boolean türünün alabildiği iki tane değer olduğundan yani herhangi bir aralık söz konusu olmadığından programcı açısından uzunluğun da önemi yoktur.
>- `int` türüne "integer" demek yanlış bir tanım kullanmak demektir. integer kavramı tam sayılara verilen genel bir isimdir. int ise 4 byte'lık bir tamsayı türüdür. Ayrıca JavaSE'de Integer isimli önemli bir sınıf da bulunmaktadır.

**Anahtar Notlar:** Yazılar da aslında bilgisayar belleğinde 2'lik sistemde sayılar biçiminde tutulmaktadır. Bir yazıyı oluşturan elemanlara **karakter (character)** denilmektedir. İşte bir yazıda her bir karakter 2'lik sistemde bir sayı ile ifade edilir. Böylece yazı  aslında ikilik sistemde bir sayı dizisi gibi tutulmaktadır. İşte bir karakter için hangi sayının karşı geldiğini belirten tablolara **karakter tabloları (character table)** denilmektedir. Karakter tablosundaki karakter şekillerine **glyph** denilmektedir. Her karaktere tabloda bir sıra numarası verilmiştir. Buna da **code point (code point)** denilmektedir. Dünyanın ilk standart karakter tablosu `ASCII` (American Standard Code Information Interchange) denilen tablodur. `ASCII` tablosu aslında 7 bit bir tablodur. Dolayısıyla tabloda 128 tane glyph için code point bulundurulmuştur. `ASCII` dışında `IBM EBCDIC` tablosunu geliştirmiştir. Wang firması `WISCII` tablosunu kullanmıştır. `ASCII` tablosu Amerikalılar tarafından yalnızca İngilizce karakterleri ifade etmek için oluşturulmuştur. Bilgisayarlar yaygınlaşmaya başladığında farklı karakterlere sahip olan Türkiye gibi, Yunanistan gibi, Almanya gibi ülkeler bu `ASCII` tablosunu 8 bite çıkartıp elde edilen 128'lik yeni alanı kendi karakterlerini ifade etmek için kullanmışlardır. `ASCII` tablosunun ilk yarısı (yani [0, 128] numaraları karakterleri) standarttır. Ancak ikinci yarısı **code page (code page)** adı altında farklı ülkeler tarafından farklı yerleşimler yapılarak kullanılmaktadır. DOS zamanlarında Türkçe karakterler için `OEM 857` denilen code page kullanılıyordu. Daha sonra Microsoft Windows sistemlerinde Türkçe karakterler için `1254 code page`'i düzenledi. ISO, bu code page'leri standart hale getirmiştir. Bugün Türkçe karakterler `ISO` tarafından `ASCII 8859-9` Code page'i ile düzenlenmiştir. `ASCII` tablosu ve onların code page'leri uzun süre kullanılmış ve hala kullanılmakta olsa da maalesef karışıklıklara yol açmaktadır. İşte ortalama 20 yıldır artık karakterleri 2 byte içerisinde ifade ederek dünyanın bütün dillerinin ve ortak sembollerinin tek bir tabloya yerleştirilmesi ile ismine `UNICODE` denilen bir tablo oluşturulmuştur.

[Unicode Homepage &#x1F517;](https://home.unicode.org)

`UNICODE` tablo ISO tarafından `10646` ismiyle de bazı farklılıklarla standardize edilmiştir. `UNICODE` tablonun ilk 128 karakteri standart ASCII karakterleri, ikinci 128 karakteri `ISO 8859-9` code page'indeki karakterlerdir. Bir karakter tablosundaki code point'lerin ikilik sistemde ifade edilme biçimine **encoding** denilmektedir. ASCII code page'lerinde encoding doğrudan code point'in 1 byte'lık sayı karşılığıdır. Ancak `UNICODE` tablonun değişik encoding'leri kullanılmaktadır. `UNICODE` tablonun klasik encoding'i `UTF-16`'dır. Burada code point doğrudan 16 bit bir sayı biçiminde ifade edilir. `UTF-32` encoding'inde ise code point 32 bitlik bir sayı biçiminde ifade edilmektedir. Ancak `UNICODE` tablonun en yaygın kullanılan encoding'i `UTF-8` encoding'idir. `UTF-8` kodlamasında standart ASCII karakterler 1 byte ile, diğer karakterler 2 byte, 3 byte, 4 byte ve 5 byte ile kodlanabilmekedir. Türkçe karakterler `UTF-8` encoding'inde 2 byte yer kaplamaktadr. `UTF-8` encoding'i `UNICODE` bir yazının adeta sıkıştırılmış bir hali gibi düşünülebilir. Bugün pek çok programlama editörü default durumda dosyayı `UNICODE UTF-8` encoding'ine göre saklamaktadır.

>Aşağıdaki demo örneği çalıştırıp yuvarlama hatasını gözlemleyiniz. Kodun detaylarını şu an için önemsemeyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		double a = 0.1;
		double b = 0.2;
		double c;
		
		c = a + b;
		
		System.out.printf("c = %.20f%n", c);
		
		if (c == 0.3)
			System.out.println("Eşit");
		else
			System.out.println("Eşit değil");		
	}
}
```
>Aşağıdaki demo örneği çalıştırıp yuvarlama hatasını gözlemleyiniz. Kodun detaylarını şu an için önemsemeyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		float a = 0.1F;
		float b = 0.2F;
		float c;
		
		c = a + b;
		
		System.out.printf("a = %.20f%n", a);
		System.out.printf("b = %.20f%n", b);
		System.out.printf("c = %.20f%n", c);
		
		if (c == 0.3)
			System.out.println("Eşit");
		else
			System.out.println("Eşit değil");		
	}
}
```
##### Değişkenler

>Bellekte ayrılan bir bölge ile işlem yapılmasını sağlayan isimlerdir. Bir değişken için bellekte yer ayrılma detayları ele alınacaktır. 

**Anahtar Notlar:** Her değişken atom burada tanımlanan değişken değildir. Burada tanımlanan değişken bir değişken atomdur.

>Java'da bir isim bildirilmeden kullanılamaz. Değişken bildiriminin genel biçimi şu şekildedir: `<tür> <isim>;`.
Her değişkenin bir türü vardır. Değişken ismi, değişken isimlendirme kurallarına uygun herhangi bir isim olabilir. Bir değişkene bildirim noktasında değer verilmesine **ilk değerleme (initialization)** denir. Bir değişken isminin derleyici tarafından görülebildiği kod aralığına **faaliyet alanı (scope)** denir. Bir değişkenin bellekte kalma süresine yani yaratılması ile yok edilmesi arasındaki süreye **ömür (storage duration)** denir. Dikkat edilirse scope derleme zamanına (compile time), storage duration ise çalışma zamanına (run time) ilişkin kavramlardır. Ömür kavramı adresler konusunda detaylı olarak ele alınacaktır.
Java'de 3 çeşit değişken vardır:
>
>- Yerel değişkenler (local variables)
>- Parametre değişkenleri (parameter variables)
>- Sınıf veri elemanları (class member variables)
>
> Bir metot içerisinde `{` ile `}` arasında kalan bölgeye **blok (block)** denir. Bu anlamda metodun gövdesi de bir bloktur. Bir metot içerisinde istenildiği kadar içiçe (nested) veya ayrık (discrete/distinct) bloklar olabilir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		{
			//...
			{
				//...
			}
			
			//...
		}
		
		{
			//...
			{
				//...
			}
			{
				//...
			}
		}
	}
}

```
##### Yerel Değişkenler

>Bir blok içerisinde bildirilen değişkenlere yerel değişkenler (local variables) denir. Aynı yerde bildirilen yerel değişken aynı türdense bildirim virgül ile ayrılarak yapılabilir. Yerel bir değişkenin faaliyet alanı bildirildiği yerden bildirildiği bloğun sonuna kadardır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int a, b, c; //yerel değişken
		double d, e;
		
		//...
	}
}

class Sample {
	public static void foo()
	{
		int x, y = 10, z; //yerel değişken
		boolean t = true; //yerel değişken
		
		{
			int u, m;
			
			//...
			
			u = 10;
		}
		
		u = 34; //error
		x = 30;
	}
}
```
>Aynı faaliyet alanı içerisinde aynı isimde yerel değişken bildirimi geçersizdir. Farklı faaliyet alanları içerisinde aynı isimde yerel değişken bildirimi geçerlidir

```java
class Sample {
	public static void foo()
	{
		int x;
		double x; //error
		
		{
			float x; //error
			//...
		}
		
		{
			int a;
			//...
		}
		
		{
			int a;
			
			//...
		}
		
		int a; 
		
		//...
	}
}
```

>Farklı faaliyet alanlarında aynı isimde yerel değişken bildirimi yapılabilmesi dolayısıyla aşağıdaki foo bar metotların n isimli değişkenler ayrı ayrı bildirilebilir

```java

class Sample {
	public static void foo()
	{
		int n;
		
		//...
	}
	
	public static void bar()
	{
		int n;
		
		//...
	}
}
```
>`println` ve `print` metotları aldıkları bir değişkenin değerini ekrana basarlar

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int a = 10;
		double b = 0.45;
		
		System.out.println(a);
		System.out.println(b);
	}
}
```

>**Java'da değer verilmemiş bir değişken kullanılamaz.** Yerel değişkenlere otomatik olarak değer verilmez. Yerel bir değişkenin kullanılabilmesi için, kullanılmadan önce en az bir kez programcı tarafından değer verilmiş olması gerekir. Yani kısaca belirtmek gerekirse yerel bir değişkene değer verilmesi programcının sorumluluğundadır.
```java
package csd;

class App {
	public static void main(String [] args)
	{
		int a;	
		
		System.out.println(a);//error
		
		a = a + 3; //error
	}
}
```
**Anahtar Notlar:** Programlamada artık kullanılması önerilmez bir araç için **deprecated** terimi kullanılır. Deprecated olmanın çeşitli gerekçeleri olabilir. Programcı deprecated olan bir şeyi özel bir durum yoksa kullanmamlıdır. Deprecated olmanın gerekçeleri ve yerine kullanılacaklar çoğu zaman dökumante edilir.

##### 19 Ekim 2024

##### Değişken İsimlendirme Kuralları
Değişken isimlendirme kuralları tüm değişken atomlar için geçerlidir:
>- Değişken isimleri bir rakam karakteri ile başlatılamaz. Uygun bir karakter ile başlatılıp istenildiği kadar rakam karakteri ile devam ettirilebilir.
>- Değişken isimlerinde alfabetik karakterler kullanılabilir.
>- Değişken isimlerinde `_ (underscore)` karakteri kullanılabilir. Değişken isimleri alttire ile de başlatılabilir. Java 8 ile birlikte alttire karakterinin tek başına değişken ismi olması deprecated olmuştur, Java 9 ile birlikte de geçersiz duruma gelmiştir. Java 9 ile alttire karakteri tek başına bir anahtar sözcük durumundadır.
>- Anahtar sözcükler tek başına değişken ismi olamazlar.
> **Anahtar Notlar:** Java'da daha sonra eklenen bazı sözcükler kullanım yerine anahtar sözcük ya da değişken ismi olarak ele alınabilmektedir. Aslında bu sözcükler `Java Language Specification` dökumanında anahtar sözcükler listesinde değildir. Bu tip sözcüklere programlamada genel olara `contextual keyword` terimi kullanılmaktadır.
>- Değişken isimleri bir boşluk (whitespace) karakteri içeremez
>- Değişken isimleri büyük-küçük harf duyarlıdır (case-sensitive). Aslında Java case-sensitive bir dildir. Örneğin anahtar söcüklerin tamamı küçük harf olarak yazılmalıdır.
>- Değişken isimlerinde `UNICODE` alfabetik karakterler kullanılabilir. Örneğin değişken isimlerinde Türkçe karakterler kullanılabilir.
>**Anahtar Notlar:** Her ne kadar değişken isimlerinde `UNICODE` alfabetik karakterler kullanılabilse de programcı İngilizce alfabedeki karakterleri tercih etmelidir. Hatta programcı bir değişken ismini İngilizce dışındaki herhangi bir dile özgü de vermemelidir. Değişken isimlerinde İngilizce tercih edilmelidir.
>- Değişken isimlerinde `$` karakteri kullanılabilir. Değişken isimleri `$` karakteri ile balşatılabilir. `$` karakteri tek başına değişken ismi olabilir. Ancak `$` karakteri programcı tarafından değişken isimlerinde kullanılmamalıdır. Derleyiciler bazı durumlarda arakoda ilişkin dosyaya ve/veya arakoda içerisinde isimler üretirler. Derleyiciler ürettikleri bu isimlerde `$` karakterini de kullanırlar. Bu durumda programcının belirlediği isimler ile derleyicinin belirlediği isimlerin çakışma olasılığı yoktur. Zaten değişken isimlerinde `$` karakterinin kullanılabilmesinin nedeni budur. `JLS` dokümanında da `$` karakterinin değişken isimlendirmede kullanılabilmesi gerekçesi (rationale) bu şekilde açıklanmış ve programcıya kullanmaması önerilmiştir. 
>- JLS'de değişken isimlerinin maksimum karakter sayısı ile ilgili herhangi bir şey söylenmemiştir. Şüphesiz bir sınırı vardır. Ancak bu sınır oldukça fazla olma eğilimindedir. Dolayısıyla isimlendirme açısından bir sorun oluşturmaz.
>
>**Anahtar Notlar:**  Değişken isimlerinin okunabilirlik/algılanabilirlik açısından **kolay telaffuz edilebilir, anlamlı ve yeterince uzunlukta** olması önerilir. Bu öneri genel bir programlama `convention` olarak düşünülmelidir. Değişken isimlendirmede bazı teknikler de kullanılabilmektedir. Genel olarak programlama diline göre bir ya da birden fazla teknik kullanılabilmektedir.

##### Klavyeden Okuma İşlemleri

>Java'da klavyeden okuma yapmak (aslında `stdin`'den okuma yapmak) için pek çok sınıf ve metot bulunmaktadır. Biz kursumuzda ağırlıklı olarak `Scanner` isimli sınıfın `nextXXX` metotlarını kullanacağız. Belirli konulara gelene kadar bu kullanımları birer kalıp olarak düşüneceğiz. Kullanılan kalıpların detayları konular içerisinde anlaşılacaktır. Kullanılan kalıplarda IDE'lerin static kod analizi araçları ya da derleyici bir takım uyarı (warning) mesajları verebilecektir. İlgili konuya gelene kadar ve aksi belirtilmediği sürece bu uyarı mesajları dikkate alınmayacaktır. Buradaki kalıplarda istenen tür dışında bir değer girilmesi durumunda exception oluşacaktır.

>Aşağıdaki kalıpta int türden değerler okunmaktadır. Bu kalıpta değerler aralarında en az bir tane whitespace karakter olacak şekilde okunabilir

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}
```

>Aşağıdaki kalıpta int türden değerler okunmaktadır. Bu kalıpta değerler aralarında ENTER karakteri ayrılacak şekilde girilmelidir. Diğer whitespace karakterlerin kullanımı exception oluşuturur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		int sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}

```
>Aşağıdaki kalıpta double türden değerler okunmaktadır. Bu kalıpta değerler aralarında en az bir tane whitespace karakter olacak şekilde okunabilir

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}
```

>Aşağıdaki kalıpta double türden değerler okunmaktadır. Bu kalıpta değerler aralarında ENTER karakteri ayrılacak şekilde girilmelidir. Diğer whitespace karakterlerin kullanımı exception oluşuturur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		System.out.print("İkinci sayıyı giriniz:");
		double b = Double.parseDouble(kb.nextLine());
		double sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}
```

>Aşağıdaki kalıpta double türden değerler okunmaktadır. Bu kalıpta değerler aralarında en az bir tane whitespace karakter olacak şekilde okunabilir
```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		long a = kb.nextLong();	
		long b = kb.nextLong();
		long sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}
```

>Aşağıdaki kalıpta double türden değerler okunmaktadır. Bu kalıpta değerler aralarında ENTER karakteri ayrılacak şekilde girilmelidir. Diğer whitespace karakterlerin kullanımı exception oluşuturur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		long a = Long.parseLong(kb.nextLine());
		System.out.print("İkinci sayıyı giriniz:");
		long b = Long.parseLong(kb.nextLine());
		long sum;
		
		sum = a + b;
		
		System.out.println(sum);				
	}	
}
```
##### İfade Kavramı

>Sabitlerden operatörlerden ve değişkenlerden oluşan herhangi bir kombinasyona **ifade (expression)** denir. Bir ifade yalnızca sabitlerden (constants/literals) ve operatörlerden oluşuyorsa, bu ifadeye **sabit ifadesi (constant expression)** denir. Bir değişken ya da bi sabit tek başına bir ifadedir. Ancak bir operatör tek başına bir ifade değildir. Her ifadenin bir türü vardır. Bunun bir tane istisnası vardır ele alınacaktır.

##### Metotların Geri Dönüş Değerleri 

>Bir metodun geri dönüş değeri bilgisi yerine bir tür yazılırsa bu metodun **geri dönüş değeri (return value)** vardır denir. Tersine bir metodun geri dönüş değeri varsa geri dönüş değeri bilgisi yerine bir tür yazılır. Bir metodun değeri varsa, o metodun çağrısı bittiğinde çağrılan noktaya bir değer ile geri döner. Metodun geri dönüş değeri yoksa, metot sonlandığında çağrılan noktaya yalnızca geri döner. Yani bir değer ile geri dönmez. 
> Bir geri dönüş değeri varsa, geri dönüş değeri metot bildiriminde (yani metot içerisinde) **return deyimi (return statement)*** ile oluşuturulur. return deyiminin genel biçimi şu şekildedir:
`return [ifade]`
Görüldüğü gibi return deyimi tek başına ya da bir ifade ile kullanılabilmektedir. return deyimi nasıl kullanılırsa kullanılsın, akış return deyimine geldiğinde metot sonlanır. Yani return deyiminin birinci görevi metodu sonlandırmaktır. return deyimi ifade ile kullanılmışsa ifadenin değeri çağrılan noktaya aktarılır. Bu geri dönüş değeri denmesinin nedeni budur.

>Aşağıdaki demo örnekte add metodu çağrıldığında kullanıcıdan iki tane int türden değer istenmiş ve o değerlerin toplamına geri dönülmüştür. main metodu içerisinde ise add metodu çağrılmış, geri dönüş değeri 2 ile çarpılıp result değişkenine atanmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int result;
		
		result = NumberUtil.add() * 2;
		
		//...
		
		System.out.println(result);
	}	
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int total = a + b;
		
		return total;		
	}
}
```
>**Akış return deyimine geldiğinde return deyimine ilişkin ifade önce hesaplanır ve elde edilen değere geri dönülür.**

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int result;
		
		result = NumberUtil.add() * 2;
		
		//...
		
		System.out.println(result);
	}	
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		
		return a + b;
	}
}
```

>**Bir metodun geri dönüş değeri varsa return tek başına (yani ifade olmadan) kullanılamaz**

>Aşağıdaki demo örneği inceleyiniz

```java
class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int total = a + b;
		
		return; //error
	}
}
```
>**Bir metodun geri dönüş değeri olması akışın her noktasında metodun geri dönebiliyor olmasını yani return deyimi olmasını gerektirir. Aksi durumda error oluşur. Yani derleyici açısından metodun geri dönüş değeri varsa metot içerisinde bir değer dönülemeyeceği akış oluşmamalıdır.**

>Aşağıdaki demo örneği inceleyiniz

```java
class NumberUtil {
	public static int add() //error
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		int total;
		
		total = a + b;
		
		if (total > 0)
			return total;
		//Akış buraya gelirse herhangi bir return olmadığından error oluşur
	}
}
```
>Aşağıdaki demo örneği inceleyiniz
```java
class NumberUtil {
	public static int add() //error
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		int total;
		
		total = a + b;
		
		//Akış buraya gelirse herhangi bir return olmadığından error oluşur
	}
}
```

>Bir metodun geri dönüş değeri başka bir metodun geri dönüş olarak doğrudan yazılabilir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int result;
		
		result = Util.getTotal() * 2;
		
		//...
		
		System.out.println(result);
	}	
}

class Util {
	public static int getTotal()
	{
		//...		
		System.out.println("Util.getTotal");
		
		return NumberUtil.add();
	} 
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		
		return a + b;
	}
}
```

>Geri dönüş değeri olan bir metot için derleyici **geçici değişken (temporary variable)** yaratan ve işleme sokan bir kod üretir. Aşağıdaki demo örnekteki `**` ile belirtilen deyim için üretilen yaklaşık kod şu şekildedir:

```java
int temp = NumberUtil.add();

result = temp * 2;
```
>**Bu durumda geri dönüş değeri olan bir metot çağrısı ile geçici değişkene yapılan aktarım da bir atama (assignment) işlemidir.**

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int result;
		
		result = NumberUtil.add() * 2; //**
		
		//...
		
		System.out.println(result);
	}	
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		
		return a + b;
	}
}
```
##### 26 Ekim 2024

>Bir metodun geri dönüş değeri olmaması durumunda geri dönüş değeri bilgisi yerine **void** anahtar sözcüğü yazılır. Geri dönüş değeri olmayan metotlara **void metotlar (void methods)** denir. void bir metot sonlandığında çağrılan noktaya bir değer ile geri dönmez. Bu durumda void bir metot içerisinde return deyimi bir ifade ile kullanılamaz. Kullanılması durumunda error oluşur. void bir metot içerinde return deyimi ifade olmadan yani tek başına istenirse metodu sonlandırmak için kullanılabilir. Bu durumda void bir metot içerisinde return deyimi zorunlu değildir. void bir metot geri dönüş değeri varmış gibi yani çağırma ifadesi işleme sokulacak şekilde kullanılamaz. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		Util.printSum();
	}	
}

class Util {
	public static void printSum()
	{
		int sum = NumberUtil.add();
		
		//...
		
		System.out.println(sum);
	}
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		
		return a + b;
	}
}
```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		int a;
		
		a = Util.printSum(); //error
	}	
}

class Util {
	public static void printSum()
	{
		int sum = NumberUtil.add();
		
		//...
		
		System.out.println(sum);
	}
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		
		return a + b;
	}
}

```

>Geri dönüş değeri olan bir metodun geri dönüş değeri işleme sokulmak zorunda değildir. Yani bu anlamda geri dönüş değeri olan bir metot, geri dönüş değeri yokmuş gibi çağrılabilir. Şüphesiz çağrılacak metodun da bu şekilde kullanımının anlamlı olması gerekir. Örneğin bir sayının mutlak değerine geri dönen bir metodun geri dönüş değerinin işleme sokulmnayacak şekilde çağrılması anlamsızdır. Ya da örneğin, bir grup bilgiyi dosyaya yazan bir metodun yazılabilmiş olan bilgi sayısına geri dönmesi durumunda programcı bu bilgiye ihtiyaç duymuyorsa bu metodu, geri dönüş değerini işleme sokmayacak şekilde çağırabilir. Burada bu şekilde çağırma algoritmaya göre anlamlı olabilir. 

>Aşağıdaki demo örneği inceleyiniz. Örnekte ** ile belirtilen çağrı olmasaydı add metodunun geri dönüş değerininin işleme sokulmaması anlamlı olur muydu?

```java
package csd;

class App {
	public static void main(String [] args)
	{
		NumberUtil.add();
	}	
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		int sum = a + b;
		
		System.out.println(sum); //**
		
		return sum;
	}
}

```
>Aşağıdaki örnekte return deyimi void metodu sonlandırmak için kullanılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		Util.printSum();
	}	
}

class Util {
	public static void printSum()
	{
		int sum = NumberUtil.add();
		
		if (sum < 0)
			return;
		
		System.out.println(sum);		
	}
}

class NumberUtil {
	public static int add()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		int sum = a + b;
		
		return sum;
	}
}

```

**Anahtar Notlar:** void bir metot çağrısı da bir ifadedir. Ancak bu ifadenin türü yoktur. void bir metot çağrısına ilişkin ifadeye **void expression** da denilmektedir. 

**Anahtar Notlar:** Bir metodun geri dönüş değeri o metodun bir çıktısıdır (output).

**Anahtar Notlar:** Java'da bir metot bir tane değere geri dönebilir.

##### Metotların Parametre Değişkenleri

>Metodun gövdesinden önce parantez içerisinde bildirilen değişkenlere parametre değişkenleri denir. Metot parametre değişkenleri virgül atomu ile listelenir. Değişkenler aynı türden olsalar bile tür bilgisi yazılmalıdır. Aksi durumda error oluşur. Metot parametre değişkenleri faaliyet alanı adeta metodun başında bildirilen yerel değişken gibidir. Yani metot boyunca görülebilirdir. Metot çağrılırken parametrelere geçilen ifadelere **argüman (argument)** denir. Bu anlamda metodun parametre değişkenleri metodun girdileridir (input). Bir metodun kaç tane parametre değişkeni varsa o kadar sayıda argüman ile çağrılmalıdır. Parametre değişkenleri değerlerini metot çağrısında, ilgili parametreye geçilen argümana ilişkin ifadenin değeri olarak alırlar. **Yani metot çağrısında önce argümana ilişkin ifade hesaplanır elde edilen değer parametre değişkenine aktarılır.** Bu anlamda argümanlardan parametrelere aktarım işlemi de bir atama işlemidir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int result;
		
		result = NumberUtil.add(a, b);
		
		System.out.println(result);
		
		result = NumberUtil.multiply(a, b);
		
		System.out.println(result);		
	}	
}

class NumberUtil {
	public static int add(int a, int b)
	{		
		return a + b;
	}
	
	public static int multiply(int a, int b)
	{		
		return a * b;
	}
}

```

>Aşağıdaki durumda error oluşur. b parametre değişkeni için de tür bilgisi yazılmalıdır
```java
class NumberUtil {
	public static int add(int a, b) //error
	{		
		return a + b;
	}
}
```
>Aşağıdaki demo örnekte add metodu 3 tane argüman ile çağrıldığından error oluşur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();	
		
		int result = NumberUtil.add(a, b, 10); //error
		
		System.out.println(result);
	}	
}

class NumberUtil {
	public static int add(int a, int b) 
	{		
		return a + b;
	}
}

```

>Aşağıdaki demo örneği inceleyiniz. Örnekte `a + 2` ve `b * 3` ifadeleri hesaplandıktan sonra add metodu çağrılır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int result;
				
		result = NumberUtil.add(a + 2, b * 3);
		
		System.out.println(result);	
	}	
}

class NumberUtil {
	public static int add(int a, int b) 
	{		
		return a + b;
	}
}

```
>Aşağıdaki demo örneği inceleyiniz
>**Anahtar Notlar:** Aşağıdaki gibi kompakt olarak ifadelerin okunabililiği/algılanabilirliği olumsuz anlamda etkilememesine dikkat edilmelidir
```java
package csd;

class App {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		
		System.out.println(NumberUtil.add(a + 2, b * 3));
	}	
}

class NumberUtil {
	public static int add(int a, int b) 
	{		
		return a + b;
	}
}

```

>**Anahtar Notlar:** Java'da 3 yerde atama işlemi söz konusudur:
>1. Atama operatörleri ile yapılan atama işlemi.
>2. Bir metodun geri dönüş değerinin geçici değişkene atanması.
>3. Argümanlardan parametrelere aktarım. 

>**Metot ne işe yarar? Problemin Çözümünde Neden Metotlar Yazalım?** Bu sorunun cevabı aşağıdaki maddelerle özetlenmiştir:
>- Bir işin çok fazla yapılması durumu kod tekrarına yol açar. Yazılım geliştirmede temel prensip **zorunlu olmadıkça kod tekrarı yapmamaktır.** Bu kavrama İngilizce olarak **DO NOT REPEAT YOURSELF (DRY)** denilmektedir. Bu durumda programcı bir metot yazarak kod tekrarını, o metodu çağırarak engellemiş olur.
>- Bir problemin çözümü metot çağırma yerine her yerde kodun tekrarlaması biçiminde yazılmışsa (implementation), bu durumda programcı kodda bir değişiklik yapmak istediğinde veya bir hata olduğunu farkedip düzeltmek istediğinde her yerde bunu yapmak zorunda kalır. Halbuki bu durumda metot yazılmış ve çağrılmış olursa sadece metot içerisinde değişiklik yapması yeterli olur.
>- Bir kod parçasının metot olarak yazılması onun bağımsız olarak test edilip doğrulanması veya varsa hatalarının bulunup düzeltimesi açısından önemlidir.
>- Bir problemin çözümü metot çağırma yerine her yerde kodun tekrarlaması biçiminde yazılmışsa (implementation), bu durumda kodun okunabilirliği/algılanabilirliği de azalabilir. Yani metot çağırarak okunabilirlik/algılanabilirlik artırılabilir.
>- Metotlar yazıldığında başka projelere de çeşitli yöntemlerle taşınarak kullanılabilir. Bu kavram **code reusability** kavramının bir parçasıdır.
>- Metodu çağıran programcı metodun nasıl yazıldığına ilişkin detayları bilmek zorunda değildir. Çünkü metodun çağrıldığı noktada nasıl yazıldığının önemi yoktur, ne yaptığı önemlidir.

**Anahtar Notlar:** Yukarıda anlatılan gerekçelerin en temel çözümü metotlar yazmak ve çağırmak biçimindedir. İleride ele alacağımız başka tekniklerle de metotlarla birlikte daha yüksek seviyeli çözümler de göreceğiz.

>`System.out.printf` metodu ile formatlı yazdırma yapılabilir. Bu metodun birinci parametresine geçilen argüman bir yazı (string literal vb.) olmalıdır. Metot birinci parametresi ile birlikte istenildiği kadar argüman alabilecek şekilde tasarlanmıştır. Değişken sayıda argüman alabilen metot (vararg methods) bildirimleri bu bölümde ele alınmayacaktır. printf metodunun birinci parametresine ilişkin yazının içerisinde `%` karakteri ile birlikte bazı özel karakterler kullanılabilmektedir. Bu özel karakterlere **format karakterleri (format specifiers)** denilmektedir. Bir format karaterinin yazı içerisinde `%` karakteri ile birlikte kullanılmasına ise **yer tutucu (place holder)** denir. Bir format karakteri özel bazı karakterler dışında bir türe karşılık gelir ve o yer tutucu yerine printf'e geçilen argümanın değeri yerleştirilerek formatlama yapılır. Format karakterlerinin bazıları şunlardır:

>**d:** Tamsayı türleri kullanılır. Sayının decimal olarak formatlanmasını sağlar
**x veya X:** Tamsayı türleri kullanılır. Sayının değerinin hexadecimal olarak formatlanmasını sağlar. Format karakterinin küçük veya büyük olmasına semboller küçük veya büyük yazılırlar.
**o:** Tamsayı türleri kullanılır. Sayının değerinin octal olarak formatlanmasını sağlar.
**f:** Gerçek sayı türleri için kullanılır.
**c:** char türü için kullanılır.
**b:** boolean türü için kullanılır.
**n:** İmleci bir sonraki satırın başına çekmek için kullanılır.
**%:** % karakterinin yazı içerisinde formatlanması için kullanılır.

>Tamsayılara ilişkin format karakterleri ve n format karakteri 

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();		
		
		System.out.printf("Decimal -> %d + %d = %d%n", a, b, a + b);		
		System.out.printf("HexaDecimal -> %X + %X = %X%n", a, b, a + b);
		System.out.printf("HexaDecimal -> %x + %x = %x%n", a, b, a + b);	
		System.out.printf("Octal -> %o + %o = %o%n", a, b, a + b);
	}	
}

```

>Gerçek sayılara ilişkin format karakteri

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();		
		
		System.out.printf("%f + %f = %f%n", a, b, a + b);		
	}	
}

```

##### 27 Ekim 2024

>char türüne ilişkin format karakteri

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		char ch = 67;
		
		System.out.printf("ch = %c%n", ch);
	}	
}

```

>boolean türüne ilişkin format karakteri

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		boolean flag = true;
		
		System.out.printf("flag = %b%n", flag);
	}	
}

```

>Aşağıdaki örnekte istenilen çıktı oluşmaz
>Çıktı -> İndirim oranı:%f

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İndirim oranını giriniz:");
		double ratio = kb.nextDouble();
		
		System.out.printf("İndirim oranı:%%f%n", ratio);		
	}	
}

```

>Aşağıdaki örnekte `%` karakterinde geçerli bir format karakteri olmadığından exception oluştur

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İndirim oranını giriniz:");
		double ratio = kb.nextDouble();
		
		System.out.printf("İndirim oranı:% %f%n", ratio);		
	}	
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İndirim oranını giriniz:");
		double ratio = kb.nextDouble();
		
		System.out.printf("İndirim oranı:%% %f%n", ratio);		
	}	
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İndirim oranını giriniz:");
		double ratio = kb.nextDouble();
		
		System.out.printf("İndirim oranı:%%%f%n", ratio);		
	}	
}

```

>Tamsayılar için `%` karakterinden sonra ve format karakterinden önce bir tamsayı yazıldığında formatlanan değerin basamak sayısı yer tutucu için yazılan sayıdan küçükse bu durumda geri kalan basamaklar soldan `space` karakteri ile beslenir. Eğer, yer tutucuya yazılan sayıdan önce sıfır yazılırsa geri kalan karakterler space yerine `sıfır` ile beslenir. Bu işleme **hizalama (alignment)** da denilmektedir. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Doğum tarihini giriniz:");
		int day = kb.nextInt();
		int month = kb.nextInt();
		int year = kb.nextInt();
		
		System.out.printf("%2d/%2d/%4d%n", day, month, year);		
		System.out.printf("%02d/%02d/%04d%n", day, month, year);
	}	
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		System.out.printf("a = %08Xh%n", a);
	}	
}

```

>`f` format karakteri için `%` karakterinden önce .karakteri ile birlikte bir tamsayı verildiğinde sayının ondalık kısmının kaç basamak olarak formatlanacağı belirlenebilmektedir. Burada geri kalan basamaklar bilimsel olarak (round) yuvarlanırlar. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("%.2f + %.2f = %.10f%n", a, b, a + b);
	}	
}

```

>Format karakteri ile karşılık geldiği argumanın türü aynı değilse genel olarak exception oluşur

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("%d + %d = %d%n", a, b, a + b);
	}	
}

```

>Her argümana ilişkin yer tutucunun karşılk geldiği argüman bulunmalıdır. Aksi durumda exception oluşur

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("%f + %f = %f%n", a, b);
	}	
}

```

>`%` karakterinden sonra geçerli bir format karakteri verilmemesi durumunda exception oluşur

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("%ğ + %f = %f%n", a, b, a+ b);
	}	
}

```

>Bu format karakterleri dışında da format karakterleri bulunmaktadır. Kurs içerisinde çeşitli konularda ele alınacaktır. Bu format karakterlerinin ayrıntıları da konular içerisinde ele alınacaktır.

**Anahtar Notlar:** printf metodu gibi kullanılan yani formatlamayı aynı biçimde yapan ancak en az printf kadar karşımıza çıkan bazı önemli metotlar vardır. Bu anlamda printf'in detayları bu metotların kullanımı açısından da önemlidir. 

> **Sınıf Çalışması:** Klavyeden girilen iki tane tamsayının toplamını, farkını ve çarpımını aşağıdaki formatta ekrana yazdıran programı yazınız: Girilen sayılar 10 ve 20 ise çıktı şu şekilde olmalıdır
> `10 + 20 = 30`
> `10 - 20 = -10`
> `10 * 20 = 200`

>**Çözüm:** 
```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.printf("%d + %d = %d%n", a, b, a + b);
		System.out.printf("%d - %d = %d%n", a, b, a - b);
		System.out.printf("%d * %d = %d%n", a, b, a * b);
	}	
}

```

##### Bölme İşlemi

>Tamsayılarla bölme işleminde sonucun noktadan sonraki kısmı atılır. Elde edilen sonuç tamsayı olarak çıkar. Tamsayılarda bölme işleminde payda sıfır ise exception oluşur. `IEEE 754` formatında sayılar dışında özel bazı değerler de vardır. Örneğin `NaN`, `Infinity` değerleri sırasıyla `Not a Number` ve `sonsuz` değerlerine karşılık gelmektedir. Bu durumda gerçek bölme işlemi yapıldığında payda sıfır pay sıfır dışı bir değerse, elde edilen sonuç payın işaretine göre pozitif veya negatif `Infinity`'dir. Eğer pay da sıfırsa bu durumda `NaN` değeri elde edilir. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int result;
		
		result = a / b;
		
		System.out.printf("%d / %d = %d%n", a, b, result);		
	}	
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double result;
		
		result = a / b;
		
		System.out.printf("%f / %f = %.20f%n", a, b, result);		
	}	
}

```

##### Standart Metotlar

>JavaSE'de standart olarak bildirilen pek çok metot bulunmaktadır. Programcı bir problemin çözümüne ilişkin işlem yapan standart metotlar varsa önce onlar kullanmayı tercih etmelidir. Eğer yoksa bazı iyi kütüphanelerde varsa onları tercih etmelidir. Hala yoksa bu durumda programcı ilgili işlemleri yapan metotları yazmalıdır. Ancak bu durum, programcının kullandığı bir metodun, standart olsun ya da olmasın nasıl yazıldığını gözardı etmesi anlamına gelmemelidir. Programcı, programlama yaşamı boyunca hepsini olmasa da hazır olarak kullandığı metotların nasıl yazıldığını öğrenmesi gerekir. Bunun hemen yapılması gerekmez.  
>
>Standart metotların, metot kullanmaya da ek olarak avantajları şu şekilde özetlenebilir:
>- Testleri yapılmıştır ve yeterince etkin olarak yazılmıştır. Hatta duruma göre zamanla metodun etkinliği de artırılmış olabilir.
>- Taşınabilirdir. Yani, standart metotların çağrıldığı kodlar herhangi bir üçüncü parti koda ya da kütüphaneye ihtiyaç duymadan derlenebilir. 
>
>Bu durumda bir metodun **ne iş yaptığını** anlamak için tipik olarak bir dökumantasyon oluşturulur. JavaSE içerisinde bulunan standart metotların (ait olduğu sınıfların da) dökumantasyonu [https://docs.oracle.com/](https://docs.oracle.com/) sitesindeki çeşitli sayfalarda bulunmaktadır. Ancak yine de ilgili dökumantasyon tüm detayıyla açıklama yapmayabilir. Genel olarak Java dökumantasyonu konu hakkında fikir vermek için yazılır. Duruma göre programcı başka kaynaklardan öğrenmek zorunda kalabilir.

**Anahtar Notlar:** `java.lang` paketi içerisinde sınıf (aslında user defined type'lar) isimleri herhangi bir işleme gerek olmaksızın her yerden görülebilirdir. Yani isimlere doğrudan erişilebilir. Örneğin, `System` sınıfı bu paket içerisindedir ve ismi doğrudan kullanılabilir. Ayrıntılar paketler konusunda ayrıca ele alınacaktır.

##### Matematiksel İşlemler Yapan Metotlar

>JavaSE'de matematiksel işlemler yapan metotların büyük bölümü `Math`isimli bir sınıf içerisinde bildirilmişlerdir. Bu sınıf `java.lang` paketi içerisinde bildirilmiştir. Bu metotların bazıları pek çok yerde kullanılabilmektedir. Bazıları Matematiksel işlemlerde kullanılır. Java programcısı Matematiksel işlemler gerektiğinde önce bu sınıfa bakmalı varsa bu sınıfın elemanlarından kullanmalıdır. Yoksa duruma göre başka alternatifler aramalı ya da kendisi yazmalıdır.

>Math sınıfının `sqrt` metodu parametresi ile aldığı double türden bir değerin karaköküne geri döner:
>$$\sqrt{a}$$

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		double a = kb.nextDouble();
				
		System.out.printf("sqrt(%f) = %f%n", a, Math.sqrt(a));		
	}	
}

```

>Math sınıfının `pow` metodu parametresi ile aldığı a ve b değerleri için $$a^b$$ değerine geri döner. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Tabanı ve üssü sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
				
		System.out.printf("pow(%f, %f) = %f%n", a, b, Math.pow(a, b));		
	}	
}

```

>**Sınıf Çalışması:** Parametresi ile aldığı kartezyen düzlemde iki noktaya ilişkin koordinat bilgilerine göre Euclid uzaklığına geri dönen `distance` isimli metodu `PointUtil` isimli bir sınıf içerisinde yazınız ve aşağıdaki kod ile test ediniz.
>
>**Açıklamalar:** 
>- Koordinat bilgileri double türden olacaktır
>- Euclid uzaklığı formülü
> $$distance = \sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$$
>biçimindedir.

>**Çözüm:**

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		PointUtilTest.run();	
	}	
}

class PointUtilTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Koordinat bilgilerini giriniz:");
		double x1 = kb.nextDouble();
		double y1 = kb.nextDouble();
		double x2 = kb.nextDouble();
		double y2 = kb.nextDouble();
		double result = PointUtil.distance(x1, y1, x2, y2);
		
		System.out.printf("distance(%f, %f, %f, %f) = %f%n", x1, y1, x2, y2, result);						
	}
}

class PointUtil {
	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
```


>**Sınıf Çalışması:** Parametresi ile aldığı kartezyen düzlemde iki noktaya ait koordinat bilgilerine göre Euclid uzaklığına geri dönen `distance` isimli metodu `PointUtil` isimli bir sınıf içerisinde yazınız ve aşağıdaki kod ile test ediniz.
>
>**Açıklamalar:** 
>- Koordinat bilgileri double türden olacaktır
>- Euclid uzaklığı formülü
> $$distance = \sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$$
>biçimindedir.

>**Çözüm:**

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		PointUtilTest.run();	
	}	
}

class PointUtilTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Koordinat bilgilerini giriniz:");
		double x1 = kb.nextDouble();
		double y1 = kb.nextDouble();
		double x2 = kb.nextDouble();
		double y2 = kb.nextDouble();
		double result = PointUtil.distance(x1, y1, x2, y2);
		
		System.out.printf("distance(%f, %f, %f, %f) = %f%n", x1, y1, x2, y2, result);						
	}
}

class PointUtil {
	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
```

##### 2 Kasım 2024

>Math sınıfının `log, log10 ve log1p`metotları

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		double a = kb.nextDouble();
		
		System.out.printf("log(%f) = %f%n", a, Math.log(a));
		System.out.printf("log10(%f) = %f%n", a,  Math.log10(a));
		System.out.printf("log1p(%f) = %f%n", a, Math.log1p(a));
	}	
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		MathUtilLogTest.run();
	}	
}

class MathUtilLogTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Tabanı ve argümanı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("log(%f, %f) = %f%n", a, b, MathUtil.log(a, b));
	}
}

class MathUtil {
	public static double log(double a, double b)
	{
		return Math.log(b) / Math.log(a);
	}
}
```
>Math sınıfınının trigometrik işlemler yapan metotları `(sin, cos, tan, asin, acos, atan vb.)` radyan (radians) ölçü birimiyle çalışırlar. Ayrıca radyan ve derece dönüşümü için `toRadians ve toDegrees` isimli metotlarda bu sınıf içerisinde bulunmaktadır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Derece değerini giriniz:");
		double a = kb.nextDouble();
		
		System.out.printf("sin(%f) = %f%n", a, Math.sin(Math.toRadians(a)));
	}	
}

```

>Math sınıfının `abs` metotları mutlak değer işlemi için kullanılır.

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		double a = kb.nextDouble();
		
		System.out.printf("abs(%f) = %f%n", a, Math.abs(a));
	}	
}

```

>Aşağıdaki demo örneği inceleyiniz. Örnekteki areEquals metodunun yazılış detayları şu an için önemsizdir. Mutlak değer kullanımına odaklanınız

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		double a = 0.2, b = 0.1;
		double c;
		
		c = a + b;
		
		System.out.printf("c = %.20f%n", c);
		
		if (MathUtil.areEquals(c, 0.3, 0.00001))
			System.out.println("Eşit");
		else
			System.out.println("Eşit değil");
	}	
}

class MathUtil {
	public static boolean areEquals(double a, double b, double delta)
	{
		return Math.abs(a - b) < delta;
	}
}
```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("min(%f, %f) = %f%n", a, b, Math.min(a, b));
		System.out.printf("max(%f, %f) = %f%n", a, b, Math.max(a, b));
	}	
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		MathUtilMinMaxTest.run();
	}	
}

class MathUtilMinMaxTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Üç sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double c = kb.nextDouble();
		
		System.out.printf("min(%f, %f, %f) = %f%n", a, b, c, MathUtil.min(a, b, c));
		System.out.printf("max(%f, %f, %f) = %f%n", a, b, c, MathUtil.max(a, b, c));
	}
}
class MathUtil {
	public static double min(double a, double b, double c) 
	{
		return Math.min(Math.min(a, b), c);
	}
	
	public static double max(double a, double b, double c) 
	{
		return Math.max(Math.max(a, b), c);
	}
}
```
>Math sınıfının `round, rint, ceil ve floor` metotları tamsayıya yuvarlama işlemi yapan önemli metotlardır. `round ve rint` metotları bilimsel yuvarlama yaparlar. round metodunun double parametreli versiyonu long türüne geri döner, rint metodu ise tamsayıya yuvarlanmış değeri olarak döndürür. Bu iki metodun arasındaki diğer farklar dökumanlardan öğrenilebilir. `ceil` metodu sayıdan büyük veya eşit olan en küçük tamsayıya geri döner. `floor` metodu sayıdan küçük veya eşit olan en büyük tamsayı değerini döndürür.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		double a = kb.nextDouble();
		
		System.out.printf("round(%f) = %d%n", a, Math.round(a));
		System.out.printf("rint(%f) = %.20f%n", a, Math.rint(a));
		System.out.printf("ceil(%f) = %.20f%n", a, Math.ceil(a));
		System.out.printf("floor(%f) = %.20f%n", a, Math.floor(a));
	}	
}

```
**Anahtar Notlar:** Math sınıfında yukarıda anlatılanlar dışında pek çok metot bulunmaktadır. Burada özellikle çok kullanılanlar genel durumlarıyla ele alınmaya çalışılmıştır. Diğer metotlar da şüphesiz önemlidir. Gerekirse dökumanlardan öğrenilebilir.

##### 3 Kasım 2024

##### Sabitler

>Program içerisinde doğrudan yazılan bir değere **sabit (literals/constants)** denir. Anımsanacağı gibi iki tırnak içerisindeki yazılara **string literals** denir. **Sabitlerin de türleri vardır. Yani derleme aşamasında bir sabitin türü tespit edilir (type inference/deduction).** 


>Sabitlerin türleri aşağıdaki kurallara göre belirlenir:
>- Sayı nokta içermiyorsa, sonuna herhangi bir ek almamışsa ve int türü sınırları içerisinde kalıyorsa `int` türden bir sabittir. Sayı int türü sınırları dışındaysa error oluşur. Örneğin: 200, 100, 2000000000 vb.
>
>- Sayı nokta içermiyorsa, ve sonuna L (küçük veya büyük) ekini almışsa `long` türdendir. L son ekini bir sabit long türünün sınırları dışında ise error oluşur. Örneğin:100L, 3000000000L vb.
>**Anahtar Notlar:** Küçük harf L soneki bazı yazı türlerinde 1(bir) rakamına benzerliğinden dolayı kullanımı önerilmez. 
>
> - Java'da `byte ve short` türden sabit yoktur.
> - Sayı nokta içeriyorsa ve sonuna herhangi bir ek almamışsa `double` türdendir. Örneğin: 3.45, 0.1, 6.789 vb.
>
> - Sayı nokta içersin ya da içermesin sonuna D (küçük veya büyük) ekini alıyosa `double` türdendir. Örneğin: 10D, 10.3d vb.
>
>- Sayı nokta içersin ya da içermesin sonuna F (küçük veya büyük) ekini alıyorsa `float` türdendir. Örneğin: 10F, 3.4f vb.
>**Anahtar Notlar:** Nokta içeren ve noktadan sonraki kısmının tamamı sıfır olmayan bir double türden sabitin sonuna F (küçük ya da büyük) eki getirildiğinde sayının değeri float türü ile  temsil edilemiyorsa en yakın değerine yuvarlanır (rounding error).
>
>- `boolean` türden iki tane sabit vardır: true, false.
>
>- Tek tırnak içerisinde yazılan karakterlere ilişkin sembollere tırnakları ile beraber **karakter sabitleri (character literals)** denir. Karakter sabitleri `char` türdendir. Tek tırnak içerisinde, özel bazı durumlar dışında tek bir karakter yazılabilir. Aksi durumda error oluşur. Bir karakter sabiti ilgili karakterin karakter tablosundaki sıra numarasına karşılık gelir. Aslında biz char türden bir sabit yazarak o sabite ilişkin karakterin sıra numarasını elde etmiş olur. Bu sıra numarasını char türden bir değişken içeriisnde saklayarak mantıksal olarak o karakteri tutmuş oluruz. Bazı karakterler klavyedeki tuş kombinasyonlarıyla doğrudan yazılamazlar. Bazı karakterler ise doğrudan ekrana basılmazlar (non printable). Bu tarz karakterlere ilişkin sabitler tek tırnak içerisinde doğrudan yazılamazlar. Bu tarz karakterlere ilişkin sabitler, `\` karakteri ile birlikte özel bir karakter kullanılarak tek tırnak içerisinde yazılırlar. Sabitleri ters bölü yazılan karakterlere **escape sequence** karakterler denir. Java'da desteklenen escape sequence karakterler şunlardır:

| Karakter Sabiti  | Karakter Sabiti Adı      |
| --------------   | ------------------------ |
| `'\n'`           | Line Feed (LF)           |
| `'\r'`           | Carriage Return (CR)     |
| `'\t'`           | Tabular (horizontal tab) |
| `'\f'`           | Form feed                |
| `'\b'`           | Backspace                |
| `'\''`           | Single quote             |
| `'\"'`           | Double quote (optional)  |
| `'\\'`           | Back slash               |
| `'\0'`           | `null` character         |
| `'\s'`           | special whitespace character (Since Java 12)         |

>`LF` karakter sabiti

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c;
		
		c = '\n';
		
		System.out.print("Hello, World");
		System.out.print(c);
		System.out.print("Goodbye, World");
		System.out.print(c);
	}	
}

```

>`CR` karakter sabiti
>**Anahtar Notlar:** Aşağıdaki örneği işletim sisteminizin komut yorumlayıcı programı ile çalıştırmanız tavsiye edilir. Kullanılan IDE'lerin console pancereleri, ayarlarına göre `CR` karakterini farklı yorumlayabilir.

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c;
		
		c = '\r';
		
		System.out.print("Hello, World");
		System.out.print(c);
		System.out.print("Hi");
	}	
}

```
>Tek tırnak karakter sabiti `\` ile yazılmalıdır. Aksi durumda error oluşur. İki tırnak karakteri doğrudan ya da `\` ile yazılabilmektedir

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c1, c2, c3;
		
		c1 = '\'';
		c2 = '"';
		c3 = '\"';
	
		System.out.printf("c1 = %c, c2 = %c, c3 = %c%n", c1, c2, c3);
	}	
}

```

>Ters bölü karakterine ilişkin karakter sabiti de yine `\` ile yazılmalıdır. Aksi durumda error oluşur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c;
		
		c = '\\';		
	
		System.out.printf("c = %c%n", c);
	}	
}

```
>Tab karakter sabiti

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c;
		
		c = '\t';		
	
		System.out.print("Ankara");
		System.out.print(c);
		System.out.println("İstanbul");
	}	
}

```

>Backspace karakter sabiti

```java
package csd;

class App {
	public static void main(String [] args)
	{
		char c;
		
		c = '\b';		
	
		System.out.print("Merhaba");
		System.out.print(c);
		System.out.println("Ali");		
	}	
}

```

>Escape sequence karakterler `string literal` içerisinde kendi anlamındadır. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Hello\nWorld");
	}	
}

```

>Aşağıdaki demo örnekte tab ve LF karakterleri kullanıldığından çıktıyı inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("C:\test\numbers.txt");
	}	
}

```

>Aşağıdaki demo örnekte iki tane ters bölü kullanıldığından artık tab ve LF karakterleri kullanılmamış olur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("C:\\test\\numbers.txt");
	}	
}

```

>Aşağıdaki demo örnekte geçersiz escape sequence kullanıldığından error oluşur

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("C:\alert\virtuals.txt"); //error
	}	
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("\\\\192.168.1.103\\test\\numbers.txt"); 
	}	
}

```
>Tek tırnak karakteri string literal içerisinde doğrudan ya da `\` ile kullanılabilir. İki kullanım da tamamen aynı anlamdadır. İki tırnak karakteri string literal içerisinde ancak `\` ile kullanılabilmektedir

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("'C ve Sistem Programcıları Derneği'"); 
		System.out.println("\'C ve Sistem Programcıları Derneği\'");
		System.out.println("\"C ve Sistem Programcıları Derneği\"");
		System.out.println("\"C ve Sistem Programcıları Derneği'");		
	}	
}

```

>Bir karakter sabiti tek tırnak içerisinde `\u` ile birlikte sıra numarası yazılabilir. Sıra numarasının hexadecimal ve 2 byte olarak (4 hex digit) olarak yazılması gerekir. Aksi durumda error oluşur. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		System.out.println('\u03A3');
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int sum = 10;
		
		System.out.printf("\u03A3 of values:%d%n", sum);
	}
}

```

>Aslında `\u` değişken isimlendirmede de kullanılabilir. Ancak bu pratikte kullanılmaz.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int \u03A3OfValues = 10;
		
		System.out.println(\u03A3OfValues);
	}
}

```

**Anahtar Notlar:** Java 12 ile birlikte ismine **text block** denilen bir string sabit yazma biçimi de eklenmiştir. Text bloklar ileride ele alınacaktır.

>Sayının noktadan sonraki kısmının tamamı sıfırsa, noktadan sonraki sıfır yazılmayabilir. Benzer şekilde sayının noktadan önceki kısmının tamamı sıfırsa yine noktadan önce sıfır yazılmayabilir. Yani `1.0` ile `1.` sabitleri birebir aynıdır, benzer şekilde `0.3` ile `.3` sabitleri birebir aynıdır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println(1.0);
		System.out.println(1.);
		System.out.println(.3);
		System.out.println(0.3);		
	}	
}

```
>Bir sabit üstel olarak gösterilebilirler. Bu gösterilişe **bilimsel gösteriliş (scientific notation)** ya da **üstel gösteriliş (exponential notation)** denilmektedir. Üstel olarak gösterilen sabitler, değeri ne olursa olsun `double` türdendir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{	
		System.out.printf("%.0f%n", 6.02E+23);
		System.out.printf("%.0f%n", 6.02E23);
		System.out.printf("%.0f%n", 6.02e+23);
		System.out.printf("%.0f%n", 6.02e23);
	}	
}

```
>Tamsayı sabitleri `decimal`, `hexadecimal`, `octal` ve Java 7'den itibaren `binary` olarak yazılabilmektedir. Sabitin başına 0x (sıfır ve küçük veya büyük X) yazılırsa hexadecimal, sıfır yazılırsa octal ve 0b (sıfır ve küçük veya büyük B) yazılırsa binat olarak ele alınır. Yazılan sabitte ilgili sistemde geçerli olmayan bir basamak yazılması error oluşturur. 


>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String [] args)
	{	
		int a = 10;
		int b = 0xA;
		int c = 012;
		int d = 0b1010;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}	
}

```
>Java 7 ile birlikte sabitlerin basamakları arasında alttire karakteri yazılabilmektedir. Alttire karakteri yalnızca iki basamak arasında istenildiği kadar sayıda yazılabilir. Yani örneğin hexadecimal bir sabitin öneki ile sabit arasında yazılamaz. Bu durumun bir tek istisnası vardır. Octal bir sabitin öneki ile sabit arasında alttire kullanımı geçerlidir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args)
	{
		int a = 1____________0;
		int b = 0x000_0000_1010_0001;
		int c = 0_12;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}

```
###### Derleyicilerin Kod Optimizasyonu

>Derleyiciler yazılan bir kodun algoritmasını değiştirmeden, kodun daha iyi çalışmasını sağlamaya çalışır. Buna **derleyicilerin kod optimizasyonu (compiler code optimization)** denir. Derleyicilerin optimizasyonu genel olarak ikiye ayrılır: **speed optimization**, **size optimization**. Speed optimaztion hızlandırmak, size optimization ise kodu az yer kaplamasını sağlamak için yapılır. Burada hızlandırılan kodun algoritmanın değiştirilmesi olmadığı unutulmamalıdır. Yani bir derleyicinin programcının algoritmasını iyileştirmek gibi bir hedefi yoktur. Buradaki iyileştirme algoritmayı (yani hedefi) değiştirmeden yapılır. Derleyicilerin pek çok optimizasyonu bulunur. 

##### Constant Folding Optimization

>Derleyici sabit ifadelerinin değerlerini hesaplayıp byte code'a yazarlar. Buna **constant folding optimization** denir. Yani aslında sabit ifadelerinin hesaplanmasının çalışma zamanına bir etkisi yoktur. 

>Aşağıdaki demo örnekte 1 ile belirtilen ifadedeki sabit ifadesi hesaplanıp arakoda yazılır

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		for (int i = 0; i < 10; ++i) {
			double value = 6.02E23 * 2.7182; //1
			
			//...
		}
	}
}

```

##### 9 Kasım 2024

##### Temel Operatörler

>Belirli bir işleme yol açan ve bu işlem sonucunda bir değer üreten atomlara **operatör (operator)** denir. Bir operatör ile işleme giren ifadelere (expression) **operand** denir. Bu bölümde temel operatörler ele alınacaktır. Bazı operatörler ilerleyen konular içerisinde, bazıları ise Java ile Uygulama geliştirme kurslarında ele alınacaktır. Bir operatörün öğrenilmesi, o operatör için aşağıdaki özelliklerin incelenmesi demektir:
>
>**Operatörün sınıflandırılması:**
>1. İşlevlerine göre sınıflandırma: İşlevlerine göre operatörler şu şekilde sınıflandırılabilir:
>- Aritmetik operatörler (Arithmetic operators)
>- Karşılaştırma operatörleri (Comparison operators)
>- Mantıksal operatörler (logical operators)
>- Bitsel operatörler (Bitwise operators)
>- Özel amaçlı operatörler (special pupose operators)
>
>2. Operand sayısına göre sınıflandırma:
>- Tek operandlı (unary)
>- İki operandlı (binary)
>- Üç operandlı (ternary)
>
>3. Operatörün konumuna göre sınıflandırma: Operatörün operandlarına göre nerede olduğu bilgisidir:
>- Önek (prefix)
>- Araek (infix)
>- Sonek (postfix)
>
>**Operatörün ürettiği değer (product value):** Operatörün işlemi sonucunda elde edilen değerdir.
>**Operatörün kısıtı (constraint):** Operatörün kullanımına ilişkin zorunluluklardır.
>**Operatörün yan etkisi (side effect):** Operatörün, operand ya da operandlarının değerini değiştirip değiştirmediği durumudur. Değiştiriyorsa operatörün yan etkisi vardır, değiştirmiyorsa yoktur.
>**Operatörün önceliği (precedence):** Operatör önceliği bir ifadede önceliği olan operatörün genel olarak daha önce işleme girmesidir. Bu durumun bazı istisnaları vardır. Aslında terminolojik olarak operatörün önceliği (operator precedence) ve işleme giriş sırası (order of evaluation) her operatör için aynı şeyler anlamına gelmez. Bazı operatörler öncelikli olmasına işlem sıraları farklı olabilmektedir. Önceliğe ilişkin basit bir örnek şu şekilde verilebilir: 
`a = b + c * d` işleminin yapılış sırası şöyledir:
`i1: c * d`
`i2: b + i1`
`i3: a = i2`
> Bir işlemi önceliklendirmek için Matematikteki gibi ifade parantez içerisine alınır. Önceliklendirme parantezi de aslında bir operatördür:
>`a = (b + c) * d` işleminin yapılış sırası şöyledir:
>
>`i1: b + c`
`i2: i1 * d`
`i3: a = i2`
>
>Bazı operatörler aynı öncelik seviyesinde olabilirler. Bu durumda, aynı öncelik seviyesindeki operatörlerin nasıl ele alınacağı **associativity** denilen bir kavram ile belirlidir. Bu anlamda **left associative** ve **right associative** terimleri kullanılır. Örneğin
>`a = b + c - d` işleminin yapılış sırası şöyledir:
>
>`i1: b + c`
`i2: i1 - d`
`i3: a = i2`

###### Aritmetik Operatörler
>Aritmetik operatörler şunlardır: `+, -, *, /, %, -, +, --, ++`. Bu operatörlerin operandları `boolean` türden olamaz. 

>`+, -, *, /` operatörleri iki operandlı ve araek durumundadır. Bu operatörler işlemin sonuca ilişkin değeri üretirler. Bu operatörlerin yan etkileri yoktur. `/` ve `*` operatörleri `+` ve `-` operatörlerinden yüksek önceliktedir. `/` ve `*` aynı öncelik grubundadır ve bu grup left asscociative'dir. `+` ve `-` aynı öncelik grubundadır ve bu grup da yine left asscociative'dir.

>Aşağıdaki demo örneği inceleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.printf("%d + %d = %d%n", a, b, a + b);
		System.out.printf("%d - %d = %d%n", a, b, a - b);
		System.out.printf("%d * %d = %d%n", a, b, a * b);
		System.out.printf("%d / %d = %d%n", a, b, a / b);
	}
}

```
>Mod işlemi için `%` atomu kullanılır. Mod alma işlemi de bölme işlemi kullanılarak yapıldığından bu operatör `/` ve `*` operatörleri ile aynı seviyededir. Bu operatör daha çok tamsayılarla kullanılsa da gerçek sayılar için de kullanılabilmektedir. Bu operatörün ikinci operandının negatif olmasının bir önemi yoktur. n pozitif bir sayı olmak üzere, bir sayının n sayısına göre modunu almakla -n sayısına göre modunu almak aynı sonucu verir. Bu opetörün birinci operandının pozitif olması durumu Matematikteki ile aynıdır ancak negatif olması durumunda operandın pozitif olması durumunda elde edilen değerin negatifi elde edilir. Yani bu operatörün birinci operandının negatif olması durumda elde edilen Matematikteki mod işleminden farklıdır.

>Aşağıdaki demo örneği çeşitli değerler ile sonuçları gözlemleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.printf("%d %% %d = %d%n", a, b, a % b);
	}
}

```

>**Sınıf Çalışması:** Parametresi ile aldığı 3 basamaklı bir sayının basamakları toplamına geri dönen `sumOf3Digits` metodunu `NumberUtil` sınıfı içerisinde yazınız ve aşağıdaki kod ile test ediniz.
>**Açıklamalar:** 
>- Metot sayının 3 basamaklı olup olmadığına ilişkin kontrol yapmayacaktır.
>- Metot negatif için basamakları toplamını pozitif olarak döndürecektir.
>- Metot içerisinde döngü kullanılmayacaktır. Zaten gerek de yoktur.
>**Çözüm 1**:
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		NumberUtilSumOfDigitsTest.run();
	}
}


class NumberUtilSumOfDigitsTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("3 basamaklı bir sayı giriniz:");
		int a = kb.nextInt();
		
		System.out.printf("%d sayısının basamakları toplamı:%d%n", a, NumberUtil.sumOf3Digits(a));
	}
}

class NumberUtil {
	public static int sumOf3Digits(int val)
	{
		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;
		
		return Math.abs(a + b + c);
	}
}

```

>**Çözüm 2:**
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		NumberUtilSumOfDigitsTest.run();
	}
}


class NumberUtilSumOfDigitsTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("3 basamaklı bir sayı giriniz:");
		int a = kb.nextInt();
		
		System.out.printf("%d sayısının basamakları toplamı:%d%n", a, NumberUtil.sumOf3Digits(a));
	}
}

class NumberUtil {
	public static int sumOf3Digits(int val)
	{
		int a = val / 100;
		int b = val % 100 / 10;
		int c = val % 10;
		
		return Math.abs(a + b + c);
	}
}

```
>Aşağıdaki demo örneği inceleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		
		System.out.printf("%f %% %f = %f%n", a, b, a % b);
	}
}
```

>İşaret `-` operatörü tek operandlı ve önek durumundadır. Bu operatör operandına ilişkin ifadenin değerinin ters işaretlisini üretir. Operatörün yan etkisi yoktur. Operatör ikinci öncelik seviyesindedir. Bu öncelik seviyesindeki operatörler `right associative` olarak ele alınırlar. İşaret `+' operatörü operandı olan ifade ile aynı değeri üretir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		int b, c;
		
		b = -a;
		c = +a;
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```
>Aslında teknik olarak doğrudan negatif sabit yoktur. Nagatif bir sabit aslında bir sabite işaret `-` uygulamyarak yazılmış olur

**Anahtar Notlar:** Okunabilirlik/algılanabilirlik açısından binary bir operatör ile operandları arasında bir ve yalnız bir tane space karakteri yazılır. Yine özel bazı operatörler dışında unary bir operatör ile operandı bitişik olarak yazılır. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 3, b = 2;
		int c;
		
		c = a - - - - - - - - - -b;
		
		System.out.printf("c = %d%n", c);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int c = - - - - - - - - - -2;
		
		System.out.printf("c = %d%n", c);
	}
}

```

##### 10 Kasım 2024

>`++` (increment) ve `--` (decrement) operatörleri tek operandlı operatörlerdir. Bu operatörler hem önek hem de sonek durumunda kullanılabilirler. Bu operatörlerin operandları değişken olmalıdır. Bu operatörlerin yan etkisi vardır.Bu operatörler boolean dışında kalan temel türden değişkenler ile kullanılabilirler. '++' operatörü operandına ilişkin değişkenin değerini 1 (bir) artırır, `--` operatörü operandına ilişkin değişkenin değerini 1(bir) azaltır. Bu operatörler konum olarak nasıl kullanılırsa kullanılsın ilgili yan etkiyi operandlarına yansıtırlar. Bu operatörlerin prefix ve postfix kullanımları arasındaki fark ürettiği değerdedir (işleme giren değer). `++` operatörü prefix kullanımda artırılmış değeri üretir, postfix kullanımda ise artırılmamış değeri üretir.  `--` operatörü prefix kullanımda azaltılmış değeri üretir, postfix kullanımda ise azaltılmamış değeri üretir. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		++a; //a = a + 1
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		a++; //a = a + 1
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		int b;
		
		b = ++a; 
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		int b;
		
		b = a++; 
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		--a; //a = a - 1
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		a--; //a = a - 1
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		int b;
		
		b = --a; 
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		int b;
		
		b = a--; 
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```

>Java derleyicisi soldan sağa ve yukarıdan aşağıya doğru anlamlı en uzun ifadeyi atomlarına ayıracak (tokenizing) şekilde işlem yapar. Bu kurala genel olarak **maximal/maximum munch** denir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3;
		int c;
		
		c = a+++b;
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3;
		int c;
		
		c = a++b; //error
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3;
		int c;
		
		c = a+-++b; 
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2;
		int b;
		
		b = a++ + a--; 
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java

package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2;
		int b = 3;
		int c;
		
		c = ++a * ++b - --b / 3;
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

>Aşağıdaki demo örneği giriniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2;
		int b = 4;
		int c;
		
		c = ++a + ++b - --b / 3;
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```
###### Temel Karşılaştırma Operatörleri

>Temel karşılaştırma operatörleri 6 tanedir: `>`, `<`, `<=`, `>=`, `==`, `!=`.
>Bu operatörler iki operandlı ve araek durumdadır. Bu operatörlerin ürettiği `boolean` türdendir. Karşılaştırma işlemi doğru `true`, yanlış ise `false` değerini üretirler. Bu operatörlerin yan etkisi yoktur. `>`, `<`, `<=`, `>=` operatörleri bilinen yani klasik karşılaştırma işlemi yapan operatörlerdir. `==` operatörü operandlarına ilişkin ifadelerin değerleri eşit ise `true`, değilse `false` değerini üretir. `!=` operatörü operandlarına ilişkin ifadelerin değerleri eşit değilse `true`, eşitse `false` değerini üretir. Bu operatörler ilgili işleme göre karşılaştırılabilen türler ile kullanılabilmektedir. Örneğin int türden iki değer `>` operatörü ile karşılaştırılabilir ancak boolean türden iki değer `>` operatörü ile karşılaştırılamaz. Örneğin, boolean türden iki ifade `==` ve `!=` operatörleri ile işleme sokulabilir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İki sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(a >= b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);
	}
}

```

###### Metot Çağırma Operatörü

>Java'da metot çağırma metot çağırma operatörü (method call/invoke operator) ile yapılır. Bu operatör özel amaçlı ve araek durumundadır. Bu operatör operatör öncelik tablosunun birinci seviyesindedir. Bu operatör ilgili metot çağrılır ve metodun geri dönüş değeri varsa o değer üretilmiş olur. void bir metot çağrısı için bu operatöre ilişkin ifade void bir ifadedir (void expression). void expression'lar değeri olmaz. 

###### 16 Kasım 2024

###### Mantıksal Operatörler

>Mantıksal operatörler şunlardır: `&&`, `||', `!`. `&&` operatörü mantıksal VE (logical AND), `||` operatörü mantıksal VEYA (logical OR), `!` operatörü mantıksal DEĞİL (logical NOT) işlemlerini yaparlar. Bu operatörlerin operandları boolean türden olmalıdır. Aksi durumda error oluşur. Operatörlerin ürettiği değer de boolean türdendir. Bu operatörlerin yan etkileri yoktur.

>`&&` ve `||` operatörleri iki operandlı ve araek durumundadır. Bu operatörler `Mantık`'taki iligili operatörlere karşılık gelirler. `&&` ve `||` operatörlerine ilişkin doğruluk tablosu (truth table) aşağıdaki gibidir:

| a     | b     | a `&&` b    | a `\|\|`b   |
|:-----:|:-----:|:-----------:|:-----------:|
| T     | T     | T           | T           |
| T     | F     | F           | T           |
| F     | T     | F           | T           |
| F     | F     | F           | F           |

>Bu doğruluk tablosundan kısaca şu sonuçlar çıkartılabilir:
>- `&&` işlemi için en az biri yanlışsa sonuç yanlıştır.
>- `||` işlemi için en az biri doğruysa sonuç doğrudur.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.foo() && Sample.bar();
		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}

```
>Aşağıdaki demo örneği inceleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.bar() || Sample.foo();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}

```
>**Bu operatörler doğru sonuca (yani Matematiksel olarak elde edilmesi gereken sonuca) en kısa yoldan ulaşmaya çalışırlar. Yani derleyici bu operatörlere ilişkin ifadeler için en kısa yoldan doğru sonuca ulaşacak kodu üretir. Bu sebeple bu operatörlerin bulunduğu ifadeler hesaplanmaya her zaman en soldan başlanır.** `&&`ve `||` operatörlerinin birinci operandı hesaplandığında elde edilen sonuç, ikinci operand hesaplansa bile değişmeyecekse ikinci operand hesaplanmaz. Örneğin `&&` işleminde birinci operanda ilişkin ifadenin sonucu false elde edilirse ikinci operanda ilişkin ifade hesaplanmaz. Çünkü hesaplansa bile sonuç değişmez. Benzer şekilde `||` işleminde birinci operanda ilişkin ifadenin sonucu true elde edilirse ikinci operanda ilişkin ifade hesaplanmaz. Çünkü hesaplansa bile sonuç değişmez. Buna **kısa devre davranışı (short circuit behaivor)** denilmektedir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.bar() && Sample.foo();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.foo() || Sample.bar();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}

```

>Bu operatörler için doğru sonuca en kısa yoldan ulaşmak söz konusu olduğundan operatör önceliği ile işlem önceliği farklı olabilmektedir. Yani bu operatörlerin olduğu bir ifadede operatör önceliği ne olursa olsun işlem önceliği soldan başlayacak şekilde yapılır. Ancak elde edilen sonuç, operatör önceliğine uyularak elde edilen sonuç ile aynıdır. Yani bu operatörler kısa devre davranışını da kullanarak ile doğru sonuca en kısa yoldan ulaşırlar. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.foo() || Sample.bar() && Sample.tar();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.bar() && Sample.foo() || Sample.tar();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}
}

```

>`&` (bitwise AND) ve `|` (bitwise OR) operatörleri tamsayılarla ve boolean türü ile kullanılabilen operatörlerdir. Bu operatörler karşılıkları bitleri ilgili işlemlere sokarlar ve ilgili sonucu üretirler. Bu operatörler ve diğer bitsel operatörlere ilişkin detaylar bu bölümde ele alınayacaktır.

>Aşağıdaki demo örneği inceleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10; //0000000A <-> 00000000000000000000000000001010
		int b = 11; //0000000B <-> 00000000000000000000000000001011
		int c;
		
		c = a & b; //0000000A <-> 00000000000000000000000000001010
		System.out.printf("c = %08X%n", c); 
		c = a | b; //0000000B <-> 00000000000000000000000000001011
		System.out.printf("c = %08X%n", c);
	}
}

```

>`&` ve `|` operatörleri boolean türden ifadeler ile kullanıldığında mantıksal karşılıkları tek fark kısa devre davranışının olmamasıdır. Diğer bütün özellikler aynıdır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean result;
		
		result = Sample.foo() | Sample.bar() & Sample.tar();		
		System.out.printf("result = %b%n", result);
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}
}
```
>`!` (logical NOT) operatörü tek operandlı ve önek durumundadır. Operatörün yan etkisi yoktur. Bu operatör operandına ilişkin ifadenin değilini (yani true ise false, false ise true değerini) üretir. Bu operatörün doğruluk tablosu şu şekildedir:

| a     | `!a`  |
|:-----:|:-----:|
| T     | F     |
| F     | T     |

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		boolean flag = true;
		
		flag = !flag;		
		System.out.println(flag);		
	}
}

```
>Atama operatörü (assignment operator) özel amaçlı, iki operandlı ve araek durumundadır. Operatörün birinci operandı bir değişken olmalıdır.  Operatörün yan etkisi vardır. Operatör sağdan sola önceliklidir. Operatörün ürettiği değer atanan değerdir. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a, b, c;
		
		a = b = c = 10;
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

>Aşağıdaki demo örnekte soldan sağa ikinci atama operatörünün birinci operandı değişken olmadığından error oluşur

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3, c = 4;
		
		(a = b) = c = 10; //error
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz. Örnek geçerlidir değil mi?

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3, c = 3;
		
		a = b = (c = 10);
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```
>Aşağıdaki demo örneği inceleyiniz. Örnek geçerlidir değil mi?

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3, c = 3;
		
		a = (b = c = 10);
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

>Java'da bir grup işlemli atama operatörü (compound/augmented assignmet operator) vardır. Bu operatörler iki operandlı ve araek durumundadır. Bu operatörlerin genel biçimi şu şekildedir:
>
>`<ifade1> <op>= <ifade2>`

>Bu biçimin yaklaşık karşılığı şu şekildedir:

>`<ifade1> = <ifade1> <op> <ifade2>`

>Bu operatörler atama işleminde kullanıldığından ifade1'in değişken olması zorunludur. Bu operatör kullanılabildiği durumda kesinlikle tercih edilmelidir. Örneğin programcı

>`a = a + b`

>ifadesini
>`a += b`
>biçiminde yazmalıdır. Operatörün ürettiği değer yine atanan değerdir. Aslında bu operatör okunabilirliği/algılanabilirliği artırması yanında bazı ifadeleri daha basit (yalın) olarak yazılmasını sağlar.

**Anahtar Notlar:** Aslında işlemli atama operatörlerinin genel biçimi yukarıdakinden biraz daha detaylıdır. Bu detaylar ileride ele alınacaktır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3;
		
		a += b; //a = a + b
		
		System.out.printf("a = %d, b = %d%n", a, b);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 2, b = 3, c = 2;
		
		a *= b + c; //a = a * (b + c);
		
		System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
	}
}

```

#### Operatör öncelik tablosu

| Operatör                                  | İlişkisi     |
|-------------------------------------------|--------------|
| () . [] new                               | Soldan sağa  |
| + - ++ -- ! ~ ()                          | Sağdan sola  |
| * / %                                     | Soldan sağa  |
| + -                                       | Soldan sağa  |
| << >> >>>                                 | Soldan sağa  |
| > < >= <= instanceof                      | Soldan sağa  |
| == !=                                     | Soldan sağa  |
| &                                         | Soldan sağa  |
| ^                                         | Soldan sağa  |
| \|                                        | Soldan sağa  |
| &&                                        | Soldan sağa  |
| \|\|                                      | Soldan sağa  |
| ?:                                        | Sağdan sola  |
| = *= /= %= += -= <<= >>= &= ^= \|= >>>=   | Sağdan sola  |

>`;` (noktalı virgül) Java 'da **sonlandırıcı karakter (terminator)** olarak kullanılır. Java'da başka sonlandırıcı karakter yoktur. Noktalı virgül genel olarak ifadeleri ve bazı deyimleri sonlandırmak için kullanılır. 

>Java'da **etkisiz ifadeler (code has no effect)** geçersizdir

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10, b = 10;
		
		a + b; //error
	}
}

```

>Derleyici akışın hiç bir zaman bir noktaya gelemeyeceğini anlayacağı kodlar için genel olarak error oluşturur. Bu tarz kodlara genel olara **unreachable codes** denir

```java
class Util {
	public static int square(int a)
	{
		return a * a;
		
		System.out.println("Unreachable code"); //error
	}
}
```

>Aşağıdaki demo örneği inceleyiniz. Hiç güzel bir örnek değil değil mi?

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		a = a++;
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örneği inceleyiniz. Hiç güzel bir örnek değil değil mi?

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		int a = 10;
		
		a = ++a;
		
		System.out.printf("a = %d%n", a);
	}
}

```
##### 17 Kasım 2024

##### Deyimler

>Programın çalıştırılan parçalarına **deyim (statement)** denir. Bir program deyimlerin çalıştırılmasıyla çalışır. Java'da deyimler şunlardır:
>- **Basit Deyimler (Simple Statements):** Bir ifadenin sonuna noktalı virgül konduğunda oluşan deyimlerdir. Örneğin `System.out.println("Hello, World");` ya da örneğin `a = b + c;`. Basit deyim çalıştırıldığında, deyime ilişkin ifade hesaplanır. 
>- **Bileşik Deyimler (Compound Statements):** `{ ve }` arasında kalan yani bir blok bileşik deyimdir. Bileşik deyim çelıştırıldığında blok içerisindeki deyimler soldan sağa ve yukarıdan aşağıya olmak üzere sırasıyla çalıştırılır. Bu anlamda metodun gövdesi de aslında bir bileşik deyimdir. 
>- **Bildirim Deyimleri (Declaration Statements):** Bir değişkenin bildirildiği deyimlerdir. Bildirimi deyimi çalıştırıldığında bellekte o değişken için yer ayrılır. Örneğin `int a;` ya da `int a = 10;`
>- **Kontrol Deyimleri (Control Statements):** Akışa yön veren deyimlerdir. Her kontrol deyiminin kendine özgü çalıştırılma biçimi vardır. Dolayısıyla o deyim için ayrıca öğrenilmelidir. Java'da önemli bazı kontrol deyimleri şunlardır: **return deyimi (return statement)**, **if deyimi (if statement)**, **döngü deyimleri (loop statements)**, **break deyimi (break statement)**, **continue deyimi (continue statement)**, **switch deyimi (switch statement).** 
>- **Boş Deyim (Null/Empty Statement):** Noktalı virgülün tek başına kullanılması sonucunda oluşan deyimdir. Boş deyim çalıştırıldığında her hangi bir şey yapılmaz.

##### Temel Kontrol Deyimleri

Bu bölümde şu temel kontrol deyimleri ele alınacaktır: `if deyimi`, `döngü deyimleri (while, do-while, for)`, `break deyimi`, `continue deyimi`, `switch deyimi (ve switch expression)`.

###### if deyimi

>Neredeyse tüm programlama dillerinde bulunan bir deyimdir. Bu deyim koşula bağlı olarak akışın yönlenmesini sağlar. if deyiminin genel biçimi şu şekildedir:

```java
if (<koşul ifadesi>)
	<deyim>
[
else
	<deyim>
]
```
>if deyiminde koşul ifadesi (condition expression/predicate) boolean türden olmalıdır. Aksi durumda error oluşur. if deyiminde koşul ifadesinin değeri true ise doğru kısmına ilişkin deyim çalıştırılır, false ise else ismine ilişkin deyim (yani yanlış kısmına ilişkin deyim) çalıştırılır. if deyiminin else kısmı olmak zorunda değildir. if deyiminin else kısmı yoksa ve koşul ifadesinin değeri false ise, akış if deyiminden sonraki deyimden devam eder. if deyimi (varsa) else kısmı ile birlikte tek bir deyimdir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a % 2 == 0)
			a /= 2;
		else
			a *= 2;
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örnekte if deyiminin doğru kısmında ve else kısmında bileşik deyim kullanılmıştır
```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a % 2 == 0) {
			System.out.println("Çift sayı girdiniz");
			a /= 2;
		}
		else {
			System.out.println("Tek sayı girdiniz");
			a *= 2;
		}
		
		System.out.printf("a = %d%n", a);
	}
}

```

**Anahtar Notlar:** if deyiminde (ve döngü deyimlerinde) basit deyimin kullanılabildiği durumlarda bazı programcılar yine bileşik deyim kullanmayı tercih ederler. Diğer bir deyişle bu tip durumlarda hiç bir zaman basit deyim kullanmazlar. Bazı programcılar ise basit deyimin kullanılabildiği yerlerde bileşik deyim kullanmamayı tercih ederler. Bu yaklaşımların her ikisi de normal ve doğru yaklaşımlardır. Bir programcı ya da bir bir geliştirm takımı bu yaklaşımlar her hangi birisini tercih edebilir. Ancak bu tip durumlarda kotü yaklaşım karışık olarak kullanmaktır.

>Aşağıdaki demo örnekte if deyiminin else kısmı yoktur

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a % 2 == 0)		
			a /= 2;	
		
		System.out.printf("a = %d%n", a);
	}
}

```
>Aşağıdaki demo örnekte, if deyiminin doğru kısmında yanlışlıkla noktalı virgül konmasından dolayı boş deyim kullanılmış olur. Bu durumda error oluşmaz ancak şüphesiz algoritma doğru yazılmamış olur

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a % 2 == 0);
			a /= 2;	
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örnekte else'in ait olduğu bir if deyimi olmadığından error oluşur.

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a % 2 == 0);			
			a /= 2;	
		else //error
			a *= 2;
		
		System.out.printf("a = %d%n", a);
	}
}

```

>Aşağıdaki demo örnekte else içteki if deyimine ait olur. Bu durumda `dangling else` denilmektedir. Bu durumda program doğru yazılmadı değil mi?

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0)
			if (a % 2 == 0)
				System.out.println("Pozitif çift sayı girdiniz");
		else
			System.out.println("Pozitif sayı girmediniz");
	}
}

```

>Yukarıdaki dangling else durumundan oluşan hatalı yaklaşım bileşik deyim kullanılarak aşağıdaki gibi düzeltilebilir

```java

package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0) {
			if (a % 2 == 0)
				System.out.println("Pozitif çift sayı girdiniz");
		}
		else
			System.out.println("Pozitif sayı girmediniz");
	}
}

```
>Aşağıdaki demo örnekte dangling else durumu yoktur

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0)
			if (a % 2 == 0)
				System.out.println("Pozitif çift sayı girdiniz");
			else 
				System.out.println("Pozitif tek sayı giriniz");
		else
			System.out.println("Pozitif sayı girmediniz");
	}
}

```
>Aşağıdaki if deyiminin else kısmında bir if deyimi vardır

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0)
			System.out.printf("%d pozitif bir sayıdır%n", a);
		else
			if (a == 0)
				System.out.println("Sıfır girdiniz");
			else
				System.out.printf("%d negatif bir sayıdır%n", a);
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
>Yukarıdaki örnek aşağıdaki gibi daha okunabilir/algılanabilir yazılabilir. 

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0)
			System.out.printf("%d pozitif bir sayıdır%n", a);
		else if (a == 0)
			System.out.println("Sıfır girdiniz");
		else
			System.out.printf("%d negatif bir sayıdır%n", a);
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```

>Yukarıdaki örnek aşağıdaki gibi yazılsaydı, problemin senaryosu gereği doğru çalışacaktı. Ancak koşullar ayrık (discrete/independent) olduğundan `else if` biçiminde yazılması hem gereksiz kontrolleri ortadan kaldıracak hem de okunabilir/algılanabilir yazılmış olacaktır. Bu durumda ayrık koşulların `else if` biçiminde yazılması ayrık olmayan koşulların okunabilirliğini/algılanabilirliğini artırır. 

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 0)
			System.out.printf("%d pozitif bir sayıdır%n", a);
		if (a == 0)
			System.out.println("Sıfır girdiniz");
		if (a < 0)
			System.out.printf("%d negatif bir sayıdır%n", a);
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```

>Aşağıdaki demo örnekte koşulların ayrık olmadığı gözlemleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 6)
			System.out.printf("%d > 6%n", a);
		if (a > 10)
			System.out.printf("%d > 10%n", a);
		if (a > 11)
			System.out.printf("%d > 11%n", a);
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
##### 23 Kasım 2024

>boolean türden ifadelerin koşul ifadelerinde `==` ve `!=` operatörleri ile kullanılması tavsiye ediilmez. Buna göre `==` operatörü ile kullanım yerine ifadenin doğrudan yazılması tavsiye edilir. `!=` operatörü yerine ise ifadenin mantıksal değili (logical not) yazılması tavsiye edilir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		Util.printEvenStatusByFlag(a % 2 == 0);
	}
}

class Util {
	public static void printEvenStatusByFlag(boolean flag) 
	{
		if (flag) //if (flag == true)
			System.out.println("Çift");
		else 
			System.out.println("Tek");			
	}
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		Util.printEvenStatusByFlag(a % 2 == 0);
	}
}

class Util {
	public static void printEvenStatusByFlag(boolean flag) 
	{
		if (!flag) //if (flag != true)
			System.out.println("Tek");
		else 
			System.out.println("Çift");			
	}
}

``` 

**Anahtar Notlar:** Geri dönüş değeri boolean olan metotların isimlendirilmesinde is, are, can vb. gibi önekler getirilir. Eğer metot ismi bir fiil  belirtiyorsa isimlendirme o fiilin çekimine göre yapılır. Örneğin bir ismin dosyada var olup olmadığını test eden metodun ismi `exists` veya `nameExits` biçiminde verilebilir.

>return deyiminin temel görevi metodu sonlandırmak olduğundan aşağıdaki isEven metodunda else anahtar sözcüğü gereksizdir. Bu şekilde kesinlikle yazılmaması tavsiye edilir.

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (NumberUtil.isEven(a))
			System.out.println("Çift sayı girdiniz");
		else
			System.out.println("Tek sayı girdiniz");
	}
}

class NumberUtil {
	public static boolean isEven(int a)
	{
		if (a % 2 == 0)
			return true;
		else
			return false;
	}
}
```

>Yukarıdaki örnek if deyimi kullanılacaksa aşağıdaki gibi yazılmalıdır

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (NumberUtil.isEven(a))
			System.out.println("Çift sayı girdiniz");
		else
			System.out.println("Tek sayı girdiniz");
	}
}

class NumberUtil {
	public static boolean isEven(int a)
	{
		if (a % 2 == 0)
			return true;
		
		return false;
	}
}
```

>Yukarıdaki isEven metodu aşağıdaki gibi yazılmalıdır

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (NumberUtil.isEven(a))
			System.out.println("Çift sayı girdiniz");
		else
			System.out.println("Tek sayı girdiniz");
	}
}

class NumberUtil {
	public static boolean isEven(int a)
	{
		return a % 2 == 0;
	}
}
```

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (NumberUtil.isOdd(a))
			System.out.println("Tek sayı girdiniz");
		else
			System.out.println("Çift sayı girdiniz");
	}
}

class NumberUtil {
	public static boolean isEven(int a)
	{
		return a % 2 == 0;
	}
	
	public static boolean isOdd(int a)
	{
		return !isEven(a);
	}
}
```

>**Sınıf Çalışması:** Katsayıları klavyeden alınan ikinci dereceden bir denklemin köklerini bulup ekrana basan programı aşağıdaki açıklamalara göre yazınız
>**Açıklamalar:**
- Program şu ana gördüklerimiz kullanılarak yazılacaktır.

- İkinci dereceden (quadratic) bir denklem

$$ax^2 + bx + c = 0$$

olsun. Buna göre delta $\Delta$ (discriminant)
$$\Delta = b^2 - 4ac$$
olarak belirlenir. Buna göre kökler şu şekilde hesaplanır:

1. if $\Delta$ > 0 ise kökler
	$$x_1 = \frac{-b + \sqrt{\Delta}}{2a}$$
	$$x_2 = \frac{-b - \sqrt{\Delta}}{2a}$$

2. if $\Delta$ = 0 ise kökler
	$$x_1 = x_2 = \frac{-b}{2a}$$

3. if $\Delta$ < 0 ise gerçek kök yok

**Not:** İleride daha iyisi yazılacaktır
**Çözüm:**

**Çözüm:**

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		QuadtraticEquationSolverApp.run();
	}
}

class QuadtraticEquationSolverApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İkinci dereceden denklemin katsayılarını giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double c = kb.nextDouble();
		
		EquationUtil.findQuadraticEquationRoots(a, b, c);
	}
}

class EquationUtil  {
	public static void printRoots(double a, double b, double delta)
	{
		double sqrtDelta = Math.sqrt(delta);		
		double x1 = (-b + sqrtDelta) / (2 * a);
		double x2 = (-b - sqrtDelta) / (2 * a);
		
		System.out.printf("x1 = %f, x2 = %f%n", x1, x2);
	}
	
	public static void printRoot(double a, double b)
	{
		System.out.printf("x1 = x2 = %f%n", -b / (2 * a));
	}
	
	public static double calculateDelta(double a, double b, double c)
	{
		return b * b - 4 * a * c;
	}
	
	public static void findQuadraticEquationRoots(double a, double b, double c)
	{
		double delta = calculateDelta(a, b, c);
		
		if (delta > 0) 
			printRoots(a, b, delta);
		else if (delta == 0) 
			printRoot(a, b);
		else 
			System.out.println("Gerçek kök yok");
	}
}
``` 

**Çözüm:**

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		QuadtraticEquationSolverApp.run();
	}
}

class QuadtraticEquationSolverApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("İkinci dereceden denklemin katsayılarını giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double c = kb.nextDouble();
		
		EquationUtil.findQuadraticEquationRoots(a, b, c);
	}
}

class EquationUtil  {
	public static void printRoots(double a, double b, double delta)
	{
		double sqrtDelta = Math.sqrt(delta);		
		double x1 = (-b + sqrtDelta) / (2 * a);
		double x2 = (-b - sqrtDelta) / (2 * a);
		
		System.out.printf("x1 = %f, x2 = %f%n", x1, x2);
	}
		
	public static double calculateDelta(double a, double b, double c)
	{
		return b * b - 4 * a * c;
	}
	
	public static void findQuadraticEquationRoots(double a, double b, double c)
	{
		double delta = calculateDelta(a, b, c);
		
		if (delta >= 0) 
			printRoots(a, b, delta);
		else 
			System.out.println("Gerçek kök yok");
	}
}
```

##### Döngü Deyimleri

>Bir işin yinelemeli olarak yapılmasını sağlayan deyimlere **döngü deyimleri (loop statements)** denir. Java'da döngü deyimleri şunlardır:
>1.while döngü deyimi
>- Kontrolün başta yapıldığı while döngüsü (while döngüsü)
>- Kontrolün sonda yapıldığı while döngüsü (do-while)
>2.for döngü deyimi
>3.for-each (enhanced for loop) döngü deyimi  

**Anahtar Notlar:** while döngüsü dendiğinde akla ilk gelen kontrolün başta yapıldığı while döngüsüdür. Kontrolün sonra yapıldığı while döngüsü `do-while` döngüsü olarak adlandırılır. Buna göre kursumuz while döngüsü dendiğinde kontrolün başta yapıldığı, do-while döngüsü dendiğinde ise kontrolün sonra yapıldığı while döngüsü anlaşılacaktır.

**Anahtar Notlar:** for-each ileride ele alınacaktır.

###### Kontrolün başta yapıldığı while döngüsü

>Bu deyimin genel biçimi şu şekildedir:
```java
while (<koşul ifadesi>) 
	<deyim>
```

>Burada koşul ifadesi boolean türden olmalıdır. Aksi durumda error oluşur. Burada koşul ifadesi true olduğu sürece döngü içerisindeki deyim yinelenir. Akış döngüye geldiğinde koşulun gerçeklenip gerçeklenmediğine bakılır, duruma göre döngüye hiç girilmeyebilir.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i = 0;
		
		while (i < n) {
			System.out.printf("%d ", i);
			++i;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
>Her zaman koşulu sağlayan yani koşul ifadesinin değeri her zaman true olan bir döngüye **sonsuz döngü (infinite loop)** denir. Sonsuz döng program boyunca sürekli yinelenen bir döngü olmak zorunda değildir. Örneğin sonsuz döngü içerisinde return deyimi kullanılıdığında döngünün içerisinde bulunduğu metot sonlanacağından döngü de dolaylı olarak sonlanmış olur. while döngüsü ile sonsuz döngü tipik olarak aşağıdaki gibi oluşturulabilir:
```java
while (true) 
	<deyim>
``` 
>while döngüsünde yanlışlıkla noktalı virgül konması durumu
```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i = 0;
		
		while (i < n); {
			System.out.printf("%d ", i);
			++i;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
>while döngüsü ile `n-kez yinelenen` döngü şu şekilde oluşturulabilir
```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i = 0;
		
		while (i < n) {
			System.out.printf("%d ", i);
			++i;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
>while döngüsü ile `n-kez yinelenen` döngü şu şekilde oluşturulabilir
```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i = n - 1;
		
		while (i >= 0) {
			System.out.printf("%d ", i);
			--i;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```

>Aşağıdaki döngü kalıbı bazı programcılar tarafından kullanılan `n-kez yinelenen` bir döngüdür. Bu döngü kalıbını Java programcısı kullanmayacak olsa bile gördüğü zaman tanımalıdır. Bu döngü deyiminde `n` değerinin döngüden sonra artık eski değerinde olmadığına (-1 olur) dikkat ediniz. Demo örneği çeşitli değerler ile çalıştırıp sonucu gözlemleyiniz
```java
package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();	
		
		while (n-- > 0) 
			System.out.printf("n = %d%n", n);
		
		System.out.printf("Döngü sonrası -> n = %d%n", n);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
##### 30 Kasım 2024

>while döngüsünün koşul ifadesinde bir metodun geri dönüş değerinin bir değişkene atanması ve atanan değerin kontrol edilmesi idiomu bazı uygulamalarda kullanılabilmektedir. Bu idiomun okunabilirliği/algılanabilirliği olumsuz olarak etkilememesine dikkat edilmelidir.

>Aşağıdaki demo örneği inceleyiniz. Örnekte klavyeden sıfır girilene kadar alınan sayıların toplamı bulunmuştur. `(val = Integer.parseInt(kb.nextLine())) != 0` ifadesinde atama işleminin önceliklendirildiğine, aksi durumda error oluşacağına dikkat ediniz

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.println("Sayıları girmeye başlayınız:");
		int total = 0;
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0)
			total += val;
		
		System.out.printf("Toplam:%d%n", total);		
	}
}

```
>**Sınıf Çalışması:** Klavyeden sıfır girilene kadar alınan sayılardan pozitif olanların ve negatif olanların toplamlarını kaçar tane olduğunu ekrana yazdıran programı aşağıdaki örnek çıktılara göre yazınız:
>**Örnekler:** 
>10 tane pozitif ve 12 tane negatifi sayı girilmiş olsun ve toplamları sırasıyla 123 ve -45 olsun bu durumda çıktı şu şekilde olacaktır:

>_Toplam 10 tane pozitif sayı girdiniz. Girilen sayıların toplamı:123_
_Toplam 12 tane negatif sayı girdiniz. Girilen sayıların toplamı:-45_

>Hiç pozitif ya da negatif sayı girilmezse ilgili mesaj aşağıdaki gibi verilecektir:

>_Hiç pozitif sayı girmediniz_
>_Toplam 12 tane negatif sayı girdiniz. Girilen sayıların toplamı:-45_

>ya da 

>_Toplam 10 tane pozitif sayı girdiniz. Girilen sayıların toplamı:123_
>_Hiç negatif sayı girmediniz_

>ya da

>_Hiç pozitif sayı girmediniz_
>_Hiç negatif sayı girmediniz_

>**Çözüm:**
```java
package csd;

class App {
	public static void main(String[] args)
	{		
		PositiveNegativeSumCountApp.run();		
	}
}

class PositiveNegativeSumCountApp {
	public static void printPositivesReport(int posTotal, int posCount)
	{
		if (posCount != 0)
			System.out.printf("Toplam %d tane pozitif sayı girdiniz. Girilen sayıların toplamı:%d%n", posCount, posTotal);
		else
			System.out.println("Hiç pozitif sayı girmediniz");
	}
	
	public static void printNegativesReport(int negTotal, int negCount)
	{
		if (negCount != 0)
			System.out.printf("Toplam %d tane negatif sayı girdiniz. Girilen sayıların toplamı:%d%n", negCount, negTotal);
		else
			System.out.println("Hiç negatif sayı girmediniz");
	}
	
	public static void printReport(int posTotal, int posCount, int negTotal, int negCount)
	{
		printPositivesReport(posTotal, posCount);
		printNegativesReport(negTotal, negCount);
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int posTotal, negTotal, posCount, negCount;
		
		posTotal = negTotal = posCount = negCount = 0;
		
		int val = 0;
		
		
		System.out.println("Sayıları girmeye başlayınız:");
		while ((val = Integer.parseInt(kb.nextLine())) != 0) 
			if (val > 0) {
				posTotal += val;
				++posCount;
			}
			else {
				negTotal += val;
				++negCount;
			}
		
		printReport(posTotal, posCount, negTotal, negCount);				
	}
}

```

>**Sınıf Çalışması:** Parametresi ile alıdığı int türden bir sayının basamak sayısını döndüren `countDigits` isimli metodu `NumberUtil` sınıfı içerisinde yazınız ve test ediniz.
>**Çözüm:**
```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilCountDigitsTest.run();		
	}
}

class NumberUtilCountDigitsTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d sayısının basamak sayısı:%d%n", a, NumberUtil.countDigits(a));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static int countDigits(int a)
	{
		if (a == 0)
			return 1;
		
		int count = 0;
		
		while (a != 0) {
			++count;
			a /= 10;
		}
		
		return count;
	}
}
```

>**Sınıf Çalışması:** Parametresi ile alıdığı int türden bir sayının basamakları toplamını döndüren `digitsSum` isimli metodu `NumberUtil` sınıfı içerisinde yazınız ve test ediniz.
>**Açıklamalar:**
>Metot negatif sayılar çin basamakların toplamını pozitif olarak döndürecektir
>**Çözüm:**
```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilDigitsSumTest.run();		
	}
}

class NumberUtilDigitsSumTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d sayısının basamakları toplamı:%d%n", a, NumberUtil.digitsSum(a));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static int digitsSum(int a)
	{
		int total = 0;
		
		while (a != 0) {
			total += a % 10;
			a /= 10;
		}		
		
		return Math.abs(total);
	}
}
```

>**Sınıf Çalışması:** Parametresi ile aldığı int türden bir sayının tersini döndüren `reverse` isimli metodu `NumberUtil` sınıfı içerisinde yazınız ve test ediniz
**İpucu:** Bir sayının tersini aşağıdaki örneğe göre basit olarak bulabilirsiniz:

> Sayı 123 olsun: 3 -> 3 * 10 + 2 = 32 -> 32 * 10 + 1 = 321
**Çözüm:**
```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilReverseTest.run();		
	}
}

class NumberUtilReverseTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d sayısının tersi:%d%n", a, NumberUtil.reverse(a));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static int reverse(int a)
	{
		int result = 0;
		
		while (a != 0) {
			result = result * 10 + a % 10;
			a /= 10;
		}
		
		return result;
	}
}
```

>**Sınıf Çalışması:** Parametresi ile aldığı bir sayının Armstrong sayısı olup olmadığını test eden `isArmstrong` isimli metodu aşağıdaki açıklamalara göre `NumberUtil` sınıfı içerisinde yazınız.

>**Açıklamalar:**
>- Basamaklarının basamak sayıncı kuvvetleri toplamı kendisine eşit olan sayılara Armstrong sayıları denir. Örneğin 153 bir Armstrong sayısıdır.
>- Metot negatif sayılar için false değerine geri dönecektir.
>- Metodunuzu 1 basamaklı, 2 basamaklı, 3 basamaklı, 4 basamaklı ve 5 basamaklı Armstrong sayılarını ekrana yazdıran bir kod ile test edebilirsiniz.
>- Math sınıfının pow metodu yerine parametreleri int türden olan bir pow metodu yazıp kullanınız.

**Çözüm:**

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsArmstrongTest.run();		
	}
}

class NumberUtilIsArmstrongTest {
	public static void run()
	{
		int n = -1;
		
		while (n < 100_000) {
			if (NumberUtil.isArmstrong(n))
				System.out.println(n);
			
			++n;
		}
	}
}

class NumberUtil {
	public static boolean isArmstrong(int a)
	{
		return a >= 0 && calculateDigitsPowSum(a) == a;
	}
	
	public static int calculateDigitsPowSum(int a)
	{
		int result = 0;
		int n = countDigits(a);
		
		while (a != 0) {
			result += pow(a % 10, n);
			a /= 10;
		}
		
		return result;
	}
	
	public static int pow(int a, int b)
	{
		int result = 1;
		
		while (b-- > 0)
			result *= a;
		
		return result;
	}
	
	public static int countDigits(int a)
	{
		if (a == 0)
			return 1;
		
		int count = 0;
		
		while (a != 0) {
			++count;
			a /= 10;
		}
		
		return count;
	}
}
```
###### Kontrolün sonda yapıldığı while döngü deyimi

>Bu döngü deyimine `do-while` döngüsü de denilmektedir. Bu döngünün genel biçimi şu şekildedir:
```java
do 
	<deyim>
while (<koşul ifadesi>);
```

>Bu döngüde akış döngü deyimine geldiğinde koşul ifadesi hesaplanmaz yani koşul kontrol edilmez. Buna göre bu döngü deyiminin en az bir kez çalışacağı garanti altındadır. Yani bu döngüde ilk adım her zaman yapılır. while döngüsü kadar sık kullanılmasa da okunabilirliği/algılanabilirliği artırmak için tercih edilebilir. Bu döngü deyiminin kullanılırken okunabilirliğin/algılanabilirliğin olumsuz etkileneceği biçimde kullanılmamasına dikkat edilmelidir. 

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i = 0;
		
		do {
			System.out.printf("%d ", i);
			++i;
		} while (i < n);
	}
}

```
>**Sınıf Çalışması:** Parametresi ile aldığı bir sayının Armstrong sayısı olup olmadığını test eden `isArmstrong` isimli metodu aşağıdaki açıklamalara göre `NumberUtil` sınıfı içerisinde yazınız.

>**Açıklamalar:**
>- Basamaklarının basamak sayıncı kuvvetleri toplamı kendisine eşit olan sayılara Armstrong sayıları denir. Örneğin 153 bir Armstrong sayısıdır.
>- Metot negatif sayılar için false değerine geri dönecektir.
>- Metodunuzu 1 basamaklı, 2 basamaklı, 3 basamaklı, 4 basamaklı ve 5 basamaklı Armstrong sayılarını ekrana yazdıran bir kod ile test edebilirsiniz.
>- Math sınıfının pow metodu yerine parametreleri int türden olan bir pow metodu yazıp kullanınız.

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsArmstrongTest.run();		
	}
}

class NumberUtilIsArmstrongTest {
	public static void run()
	{
		int n = -1;
		
		while (n < 100_000) {
			if (NumberUtil.isArmstrong(n))
				System.out.println(n);
			
			++n;
		}
	}
}

class NumberUtil {
	public static boolean isArmstrong(int a)
	{
		return a >= 0 && calculateDigitsPowSum(a) == a;
	}
	
	public static int calculateDigitsPowSum(int a)
	{
		int result = 0;
		int n = countDigits(a);
		
		while (a != 0) {
			result += pow(a % 10, n);
			a /= 10;
		}
		
		return result;
	}
	
	public static int pow(int a, int b)
	{
		int result = 1;
		
		while (b-- > 0)
			result *= a;
		
		return result;
	}
	
	public static int countDigits(int a)
	{
		int count = 0;
		
		do {
			++count;
			a /= 10;
		} while (a != 0);
		
		return count;	
	}
}
```
>Yerel değişkenlerin faaliyet alanı (scope) kuralları gereği do-while döngüsü içerisinde bildirilen bir değişkene koşul ifadesinde erişilemez

>Aşağıdaki demo örneği inceleyiniz
```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		do {
			System.out.print("Bir sayı giriniz:");			
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d * %d = %d%n", a, a, a * a);
		} while (a != 0); //error
	}
}
```
>Yukarıdaki örnek aşağıdaki gibi yapılabilir

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		int a;
		
		do {
			System.out.print("Bir sayı giriniz:");			
			a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d * %d = %d%n", a, a, a * a);
		} while (a != 0);
	}
}

```

##### 1 Aralık 2024

##### for Döngü Deyimi

>for döngü deyimi Java'nın en kapsamlı ve dolayısıyla yetenekli döngü deyimidir. Adeta diğer döngü deyimlerini de kapsar. for döngü deyiminin genel biçimi şu şekildedir:

```java
for ([Birinci kısım]; [İkinci kısım]; [Üçüncü kısım])
	<deyim>
```

>Bu döngünün kısımlarına ilişkin ifadelerin hesaplanması şu şekildedir:
- Birinci kısım: Akış for döngü deyimine geldiğinde yapılır. Bu ifade bir kez yapılır
- İkinci kısım: Burası koşul ifadesine ilişkin kısımdır, boolean türden olmalıdır.
- Üçüncü kısım: Döngünün bir adımı tamamlandığında bir sonraki adım için koşulun kontrol edilmesinden önce yapılır. 

>Bu döngü deyiminin kısımlarının boş bırakılması ayrıca ele alınacaktır.

>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
	
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i;
		
		for (i = 0; i < n; ++i)
			System.out.printf("%d ", i);
		
		System.out.println();
		
	}
}

```
>Aşağıdaki demo örneği inceleyiniz

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
	
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		int i;
		
		for (i = n - 1; i >= 0; --i)
			System.out.printf("%d ", i);
		
		System.out.println();
		
	}
}
```


