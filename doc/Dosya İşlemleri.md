
###### 18 Mart 2026

##### Temel Dosya İşlemleri
  
>Java'da giriş/çıkış (input/output) işlemleri tarihsel süreç içerisinde çeşitli değişikliklere uğramış ve yine pek çok eklenti yapılmıştır. Dosya işlemleri de giriş çıkış işlemleri olduğundan bu tarihsel süreçten  etkilenmiştir. Burada temel olan ve en çok kullanılanlar ele alınacaktır. Bu anlamda diğer detaylar `Java ile Uygulama Geliştirme I ve II`  kurslarında ele alınacaktır.  

>İkincil belleklerde (secondary memory) organize edilmiş alanlara dosya (file) denir. Dosyaların isimleri ve özellikleri vardır.  Dosya işlemleri aslında işletim sistemi tarafından yapılır. İşletim sisteminin dosya işlemleri ile ilgili faaliyetlerinden oluşan bölümüne dosya sistemi (file system) denir. Java'nın bu konudaki sınıfları dolaylı olarak işletim sisteminin sistem fonksiyonları  veya API (Application Programming Interface) fonksiyonlarını çağırmaktadır.  

>Bir dosyanın yerini belirten yazısal ifadeye **yol ifadesi (path)** denilmektedir. Windows'ta dizin (directory) geçişleri  genel olarak `\` karakteri ile UNIX/Linux ve Mac OS X sistemlerinde `/` ile belirtilir. Windows sistemlerinde ayrıca bir de  sürücü (drive) kavramı vardır. UNIX/Linux sistemlerinde ve Mac OS X sistemlerinde sürücü kavramı yoktur. Windows  sistemlerinde her sürücünün ayrı bir kökü ve dizin ağacı (directory tree) vardır. Sürücünün kök dizini onun en dış  dizinidir.  
  
>Yol ifadeleri, **mutlak (absolute)** ve **göreli (relative)** olmak üzere ikiye ayrılmaktadır. Eğer sürücü ifadesinden  sonraki (yol ifadesinde sürücü de belirtilmeyebilir) ilk karakter `\` veya `/` ise böyle yol ifadelerine mutlak,  değilse göreli yol ifadeleri denilmektedir. Örneğin:  


`c:\a\b\c.dat ---> mutlak yol ifadesi`  
`\x\y\z.txt ---> mutlak yol ifadesi`  
`x\y\z.txt ---> göreli`  
`x.txt ---> göreli`  
`c:/a/b/c.dat ---> mutlak yol ifadesi`  
`/x/y/z.txt ---> mutlak yol ifadesi`  
`x/y/z.txt ---> göreli`  
 
>Her process'in bir **çalışma dizini (current working directory)** vardır. Programın çalışma dizini göreli yol ifadelerinin  çözülmesi (resolve) için orijin belirtir. Örneğin, process'imizin çalışma dizini (cwd) `c:\temp` olsun. Biz bu programda  `x\y\z.dat` biçiminde bir yol ifadesi kullanırsak toplamda `c:\temp\x\y\z.dat` dosyasını belirtmiş oluruz. Prosesin  çalışma dizini istenildiği zaman değiştirilebilir. Ancak işin başında genel olarak programın çalıştırıldığı dizindir.  Buradaki. örnek Windows işletim sistemi için anlatılmıştır. Benzer şekilde örneğin cwd `/tmp` dizini ise `x/y/z.dat` biçimindeki göreli yol ifadesi toplamda `/tmp/x/y/z.dat` biçiminde olacaktır.  
  
>Mutlak yol ifadeleri kök dizinden itibaren çözülür. Windows sistemlerine özgü olarak eğer mutlak yol ifadesinde sürücü  belirtilmemişse prosesin çalışma dizininin bulunduğu sürücü o mutlak yol ifadesindeki sürücü olarak alınır. Örneğin  prosesin çalışma dizini `d:\temp` olsun. `\a\b\c.dat` mutlak yol ifadesi d'nin kök dizininden itibaren yol belirtir yani örnekteki yol ifadesi `d:\a\b\c.dat` olarak ele alınır.   

>Java'da process'in çalışma dizini System sınıfının getProperty metoduna `user.dir` string sabiti argüman olarak  geçilerek elde edilebilir. Bununla birlikte process'in çalışma dizinini değiştirmek için System sınıfının setProperty  metodu yine "user.dir" string sabiti ile kullanılabilir.  

>Aşağıdaki demo örneği inceleyeniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import static org.csystem.util.console.commanline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
        Console.writeLine("Current working directory:%s", System.getProperty("user.dir"));  
        System.setProperty("user.dir", args[0]);  
        Console.writeLine("Current working directory:%s", System.getProperty("user.dir"));  
    }  
}
```
  
>Aslında Java'da sisteme yönelik pek çok bilgi de çeşitli property isimleriyle alınabilir. Şüphesiz bunların hepsi  değiştirilemez. Aşağıda bazı bilgilere ilişkin anahtarlar (key) kullanılmıştır.


```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Console.writeLine("File separator:%s", System.getProperty("file.separator"));  
        Console.writeLine("System:%s",  System.getProperty("file.separator").charAt(0) == '/' ? "Unix-Linux" : "Windows");  
        Console.writeLine("Java Version:%s", System.getProperty("java.version"));  
        Console.writeLine("OS architecture:%s", System.getProperty("os.arch"));  
        Console.writeLine("OS version:%s", System.getProperty("os.version"));  
        Console.writeLine("OS name:%s", System.getProperty("os.name"));  
        Console.writeLine("Java Vendor:%s", System.getProperty("java.vendor"));  
        Console.writeLine("User name:%s", System.getProperty("user.name"));  
    }  
}
```
###### 2 Mayıs 2026

>Windows’ta dosya ve dizin isimlerinin büyük harf küçük harf duyarlılığı yoktur. Windows dosyanın ismini bizim  belirttiğimiz gibi saklar. Ancak işleme sokarken büyük harf küçük harf farkını dikkate almaz ancak UNIX/Linux  sistemlerinde (Mac OS X dahil) dosya ve dizin isimlerinin büyük harf küçük harf duyarlılığı vardır.  Yol ifadelerinde kullanabileceğimiz iki özel dizin ismi vardır. Bunlar `.` ve `..` isimleridir. `.` o anda belirtilen  dizinin aynısı, `..` ise o anda belirtilen dizinin üst dizini (parent directory) anlamına gelir. Örneğin `a\b\..\.txt`  yol ifadesi aslında `a\x.txt` ile eşdeğerdir.    
  
**Anahtar Notlar:** Dosya işlemleri sırasında bir çok durum oluşabilir. Örneğin, bir dosya ilgili dizinde bulunamayabilir,  o anki process'in o dosyaya yazma hakkı olmayabilir vs. Bu durumda genel olarak metotlar exception'lar fırlatabilmektedir.  Programcı bu exceptionlara dikkat etmelidir. Bu exception sınıfları genel olarak IOException veya IOException sınıfından türetilmiş olan exception sınıflarıdır. IOException sınıfının checked bir exception sınıfı olduğuna dikkat ediniz.
  
###### Text ve Binary Dosyalar  
  
>Bilgisayar dünyasında içeriklerine göre dosyalar kabaca “text” ve “binary” dosyalar biçiminde ikiye ayrılmaktadır.  Aslında bu ayrım tamamen mantıksal düzeydedir. Dosyanın içerisinde ne olursa olsun dosyalar byte topluluklarından  oluşurlar. Dosyaların uzantıları (extension) onların içerisinde ne olduğuna yönelik bir ipucu vermek için düşünülmüştür.  İçerisinde yalnızca yazıların bulunduğu dosyalara **text** dosyalar, içerisinde yazıların dışında başka birtakım  bilgilerin de bulunduğu dosyalara **binary** dosyalar denilmektedir. Örneğin notepad’te oluşturmuş olduğumuz dosyalar tipik text dosyalardır. Halbuki uzantısı “.exe” veya “.obj” olan dosyaların içerisinde yazı yoktur. Bunlar tipik  binary dosyalardır. Uzantısı “.doc” olan veya “.docx” olan dosyalar da aslında “binary” dosyalardır. Her ne kadar bu dosyaların içerisinde yazılar varsa da yazıların dışında başka metadata bilgileri de vardır.  

>Text ve binary modda açılan dosyalar için Windows ve Unix/Linux (Mac OS X dahil) sistemlerinde farklılıklar bulunmaktadır. Bir dosya text modda açılmışsa ve çalışılan sistem windows ise yazma yapan herhangi bir fonksiyon  Line feed (LF) (`\n`) karakterini yazdığında aslında dosyaya Carriage Return (CR)(`\r`) ve LF karakterlerinin ikisi birden yazılır. Benzer şekilde dosyadan okuma yapan fonksiyonlar çalışılan sistem Windows ise ve dosya text modda  açılmışsa CRLF karakterlerini yan yana gördüğünde yalnızca LF olarak okuma yaparlar. Bu konu ileride detaylandırılacaktır.  
##### Dosya İşlemlerine İlişkin Standart Türler

>Java'da dosyalar üzerinde işlem yapan pek çok tür vardır. Bunları iki gruba ayırabiliriz:
>
>- Dosyanın bütünü üzerinde işlem yapan türler. Örneğin, bir dosyayı silen, kopyalayan, yer değiştiren gibi.  
>
>- Dosyanın içerisindeki veriler üzerinde işlem yapan türler. Örneğin, dosyaya yazma yapan, dosyadan okuma yapan sınıflar gibi.  

>Java'da dosya işlemi yapan sınıflar genel olarak `java.io` ve `java.nio` paketlerinde bulunmaktadır.

###### Dosyanın Bütünü Üzerinde İşlem Yapan Sınıflar, Arayüzler ve Metotlar  

>Burada dosyanın bütünü üzerinde işlem yapan çeşitli UDT'ler ve metotları ele alınacaktır.

>**File Sınıfı:**  Bu sınıf bir dosya ya da dizine (directory) ilişkin bütünsel işlemleri yapar. File sınıfının kullanılması için önce programcı dosya yolunu (path) vererek bir File nesnesi oluşturur. Sınıfın dosyanın bütünü üzerinde işlem yapan birçok yararlı metodu bulunmaktadır. File sınıfının ayrıca başka parametreli ctor'ları da bulunmaktadır. File sınıfının hemen hemen tüm metotları SecurityException fırlatabilirler. Bu exception özel durumlarda fırlatılır. Bu exception'a ilişkin durumlar burada ele alınmayacaktır. Aslında input/output'a yönelik bir çok metot bu exception'ı  fırlatır.  

>File sınıfı türünden nesne yaratıldığında yol ifadesinin geçerli olup olmadığı kontrol edilmez. File sınıfının **exists**  metodu verilen yol ifadesine ilişkin dosya ya da dizinin varlığını test etmek amaçlı kullanılabilir. File sınıfının  **isDirectory** ve **isFile** metotları ilgili path'in bir dizin ve dosya belirtip belirtmediğini test etmek için kullanılabilir. Bu metotlar yol ifadesinin bulunmaması olması durumunda da false değerine geri dönerler. Bu  sebeple yol ifadesi geçerliliği gerekirse ayrıca kontrol edilmelidir. İşletim sistemlerinde dosya gibi ele alınan  ancak ne teknik anlamda dosya ne de teknik anlamda directory olan yapılar da bulunmaktadır. Bunlar sisteme göre değişiklik gösterebilmektedir. 

>Aşağıdaki demo örneği inceleyiniz ve çeşitli işletim sistemlerinde çalıştırarak test ediniz.

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commanline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.exists()) {  
            if (file.isFile())  
                Console.writeLine("%s is a file", args[0]);  
            else if (file.isDirectory())  
                Console.writeLine("%s is a directory", args[0]);  
            else  
                Console.writeLine("%s is another type", args[0]);  
        }  
        else  
            Console.writeLine("%s not found", args[0]);  
    }  
}
```

XXXXXXXXXXXXXXXXXXXXXXXXXXX

>File sınıfının getAbsolutePath isimli metodu ile File sınıfına verilen yol ifadesi mutlak olarak elde edilir. Zaten  mutlak verilmişse aynısı, mutlak verilmemişse çalışma dizini ile birleştirilmiş hali elde edilir. File sınıfının  getName isimli metodu ile yol ifadesine ilişkin dosyanın veya dizinin doğrudan ismi elde edilebilir. Benzer şekilde getParent isimli metodu ile de dosya ya da dizinin üst dizini (parent) elde edilebilir. geParentFile isimli metodu ile üst dizine ilişkin File referansı elde edilebilir. getParent ve getParentFile metotları, içerisinde hiç `/` ve `\` olmayan bir yol ifadesi ile yaratılmış File nesnesinden elde ediliyorsa null değere dönerler. Bu durumda en iyi     yöntem getAbsoluteFile metodu ile mutlak yol ifadesine ilişkin File referansı alınıp getParent veya getParentFile çağrılmalıdır  
  
  
>File sınıfının delete metodu ilgili yol ifadesinde bulunan dosya ya da dizini silmektedir. Boş olmayan dizinler silinemez. Bunun için önce dizinin boşaltılması sonra silinmesi gerekir. File sınıfının delete metodunun geri dönüş değeri yol ifadesine ilişkin bilginin silinip silinmediğine belirten boolean türündendir. Bu geri dönüş değerinden dosyanın hangi sebepten silinemediği anlaşılamaz
  
>File nesnesi bir dizin gösteriyorsa bu durumda o dizin içerisindeki dosyalar ve dizinler elde edilebilir. Bir dizin içerisindeki dosyaların ve dizinlerin isimleri list metoduyla elde edilebilir. list metodu eğer File nesnesine ilişkin yol ifadesi bir dizin değilse veya bir IO problemi oluşursa null değerine geri döner  
  
>Bir dizin içerisindeki dosyalara ve dizinlere işlişkin File referanlarından oluşan dizi listFiles metodu ile elde edilebilir.  listFiles metodu eğer File nesnesine ilişkin yol ifadesi bir dizin değilse veya IO problemi oluşursa null değerine  geri döner. File sınıfının length metodu ile ilgili dosyanın uzunluğu byte cinsinden elde edilebilir.  
  
**Anahtar Notlar:** İşletim sistemlerinde dizinlerin uzunlukları (length) dizine ilişkin bir bilgi olarak tutulmaz. Bu durumda dizin ağacı dolaşılarak içerisindeki dosyalardan hesaplanması gerekir. Bu sebeple bir dizine ilişkin File nesnesi ile length metodu çağrıldığında sisteme göre farklı değerler elde edilebilir. Yani aslında bu length bilgisinin bir dizinin kapladığı alan anlamında doğrudan bir ilişkisi yoktur.
  
>File sınıfının mkdir metodu verilen yol ifadesine ilişkin bir dizin yaratır. Eğer yol ifadesine ilişkin dizin varsa bu durumda hiç birşey yapmaz. Metodun geri dönüş değeri dizinin yaratılıp yaratılmadığını gösteren boolean türden değerdir. mkdir metodu yaratılmak istenen dizine ilişkin yol ifadesi geçersizse dizini yaratamaz ve false değerine döner.  

>Verilen yol ifadesine ilişkin tüm dizinlerin yaratılabilmesi için mkdirs metodu kullanılmalıdır  

  
>Dosyanın bütünü üzerinde işlem yapan bazı sınıflar ve arayüzler JavaSE'ye daha sonradan eklenmiştir. Yeni eklenen bu  sınıflar ve arayüzler genel olarak `java.nio` paketi içerisinde bulunurlar.
  
>**Path Arayüzü, Paths ve Files Sınıfları**  Path arayüzü dosya ve dizinler üzerinde daha kolay işlem yapılmasını sağlayan bir arayüzdür. Kullanımı karışık gibi  gözükse de birçok işlemi kolaylaştırmaktadır. Tipik olarak bir Path referansı elde etmek için Java 11 ile birlikte  of metodu kullanılabilir. Java 11 öncesinde Path referansı elde etmek için genel olarak Paths isimli sınıfın get  metotları kullanılıyordu. Ancak bu sınıfın dökümanlarına göre ileride "deprecated" olabileceği söylendiğinden Java 11+  için bu sınıfın kullanımı tavsiye edilmez. Path arayüzü, Paths sınıfı ve Files sınıfı java.nio.file paketi içerisinde  bildirilmiştir ve Java 7 ile birlikte eklenmiştir.
  
  
>Aşağıdaki basit örnek Java 11 öncesi Path referansı elde edilmesinin Paths sınıfıyla yapılışını göstermektedir. Paths  sınıfının get metodu formatı geçersiz bir path için InvalidPathException fırlatır.   
  
  
 >Aşağıdaki basit örnek Java 11+ için Path referansı elde edilmesinin of metodu ile yapılışını göstermektedir. Path  arayüzünün of metodu formatı geçersiz bir path için InvalidPathException fırlatır
  

**Anahtar Notlar:** Bir path'in geçerli veya geçersiz olmasına yönelik formatı işletime sistemine özgüdür, değişiklik  gösterebilmektedir  

 
>Files utility sınıfı birçok yararlı static metot barındırır. Aslında File sınıfının da içerisinde bulunan birçok yararlı metodu barındırır. Ancak File sınıfında da Files'da da olmayan bazı metotlar vardır. Benzer şekilde Files sınıfında da File sınıfında olmayan bazı metotlar vardır. Aslında genel olarak Files sınıfı, File sınıfının birçok işleminin daha detaylandırılmış biçimidir. Files sınıfı (aslında bazı metotları anlamında File sınıfı da) yalnızca dosyanın bütünü  üzerinde işlemler yapan metotlara sahip değildir. Dosyanın verileri üzerinde işlem yapan çeşitli metotları da vardır.  Dosyanın verileri üzerinde işlem yapan metotlar ileride ele alınacaktır. Files sınıfının bir çok metodu yol ifadesini Path arayüzü olarak alırlar. Files sınıfının metotları çeşitli durumlar için çeşitli exception'lar fırlatırlar  
  
  
  
>Files sınıfının exists, notExists, isRegularFile, isDirectory gibi metotları vardır. Bu metotların LinkOption parametresi optional'dır, geçilmeyebilir. Bu parametrenin anlamı bu kursta ele alınmayacaktır. Files sınıfının delete ve deleteIfExists metotları path'e ilişkin dosyayı silerler. delete metodu parametresi ile aldığı path'e ilişkin dosya yoksa NoSuchFileException fırlatır. Path bir dizin belirtiyorsa ve boş değilse DirectoryNotEmptyException fırlatır. Herhangi bir IO problemi oluşursa IOException fırlatır. deleteIfExists metodu aldığı path'e ilişkin dosya yoksa false, varsa true değerine geri döner. Bu metot'da directory için doluysa DirectoryNotEmptyException fırlatır. Herhangi bir IO problemi oluşursa IOException fırlatır. Files sınıfının exists ve notExists isimli metotları da vardır. Bu metotların da LinkOption parametreleri optional'dır, geçilmeyebilir.
  


  
>Yukarıdaki örnekte path'in kontrolü exists metodu ile aşağıdaki gibi yapılabilir  



>Yukarıdaki örnekte path'in kontrolü notExists metodu ile aşağıdaki gibi yapılabilir  
  
  
  
  
>Files sınıfının copy metotları belirli bir kaynaktan başka bir kaynağa kopyalama yapmak amaçlı kullanılmaktadır. Bu  metodun bir çok overload'u bulunmaktadır. Path türünden iki argümanla çağrılabilen overload'u birinci parametre ile  alınan path'in, ikinci parametredeki path'e doğrudan kopyalanmasını sağlar. Bu metot kaynak (source) path ile belirtilen dosyayı bulamazsa NoSuchFileException fırlatır. Metot iki argüman ile çağrıldığında, hedef (destination/target) path'e ilişkin bir dosya mevcutsa bu durumda FileAlreadyExistsException nesnesini fırlatır. Bu metot hedef Path referansına geri döner  
  

>Files sınıfının aşağıda kullanılan copy metodu CopyOption arayüzü türünden bir referans alır. Bu arayüzü destekleyen  StandardCopyOption isimli bir enum ile bu argüman verilebilir. REPLACE_EXISTING isimli enum sabiti ile hedef dosya  varsa bile yenisi ile değiştirilir. REPLACE_EXISTING değeri ile dizin kopyalaması yapıldığında hedef dizin varsa  ve içi boş değilse DirectoryEmptyException nesnesi fırlatılır. COPY_ATTRIBUTES isimli enum sabiti dosyanın tüm  özelliklerini hedef dosya için de kopyalar. Bir dosyaya ilişkin attribute'lar sistemden sisteme değişiklik gösterebilmektedir.  Bir standardı yoktur. ATOMIC_MOVE move metodu ve "multi-threaded" uygulamalara yöneliktir. Burada ele alınmayacaktır  
  
  
>Files sınıfının move metodu kaynak yol ifadesinden hedef yol ifadesine taşıma işlemi yapar. copy metoduna benzer  şekilde kullanılabilir. move metodu iki argüman ile çağrılırsa exception bakımından copy metodu gibi davranır. Ayrıca  move metodu "rename" için de kullanılabilir. move metodu COPY_ATTRIBUTES sabitini desteklemez. Bu sabitin geçilmesi  durumunda UnsupportedOperationExceoption fırlatılır  
  
  
>Aşağıdaki örneği inceleyiniz  

  
>Aşağıdaki örneği inceleyiniz  

  
 >**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı yazınız:  
 
`java org.csystem.app.io.file.copy.BackupAndCopyApp <src> <dest> `

 >Program src ile aldığı dosyayı dest ile aldığı dosya olarak kopyalayacaktır. Hedef dosya varsa hedef dosya ismi ve  uzantısının sonuna "-bak" eklenerek yedeklenecektir. Daha önce yedeklenmişse üzerine yazılacaktır. Bu işlemden sonra  kopyalama yapılacaktır  
  
  
>**Sınıf Çalışması:** Yukarıdaki örneği backup yapılan dosya varsa kullanıcıya  aşağıdaki gibi soracak biçime getiriniz:   

`Backup file exists. Do you want to overwrite?`

>Cevabın Y ve N olmasına göre işlemi yapınız. Burada Y veya N karakteri dışında bir karakter için hiç bir işlem yapılmayacaktır. Eğer N girilirse hedef dosya, yedekeleme yapılmadan kopyalanacaktır.


>Files sınıfının createDirectory metodu aldığı Path'e ilişkin dizini yaratmak için kullanılabilir. Bu matodun ikinci  parametresi dosya özelliklerine (file attributes) ilişkindir. Sistemden sisteme değişiklik gösterebilmektedir. Burada  ele alınmayacaktır. Metodun ikinci parametresine argüman geçilmediğinde default attribute'lar geçerli olacaktır. Metot  yaratılmak istenen directory'ye ilişkin path varsa FileAlreadyExistsException fırlatır. İkinci parametreye geçilen  argüman geçersizse (aslında o sistemde desteklenmiyorsa) UnsupportedOperationException fırlatır. Herhangi bir IO problemi  durumunda IOException fırlatır. createDirectory metodu yaratılmak istenen dizine ilişkin parent directory'ler yoksa  yaratmaz. Parent directory'lerin de birlikte yaratılması için createDirectories metodu kullanılabilir.
  

>Aşağıdaki örneği inceleyiniz  

###### Dosya Verileri Üzerinde İşlem Yapan Sınıflar  

