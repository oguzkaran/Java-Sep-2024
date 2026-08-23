
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
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
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
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
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

###### 16 Mayıs 2026

>File sınıfının **getAbsolutePtath** isimli metodu ile File sınıfına verilen yol ifadesi mutlak olarak elde edilir. Zaten  mutlak verilmişse aynısı, mutlak verilmemişse çalışma dizini ile birleştirilmiş hali elde edilir. File sınıfının  **getName** isimli metodu ile yol ifadesine ilişkin dosyanın veya dizinin doğrudan ismi elde edilebilir. Benzer şekilde **getParent** isimli metodu ile de dosya ya da dizinin üst dizini (parent) elde edilebilir. **getParentFile** isimli metodu ile üst dizine ilişkin File referansı elde edilebilir. **getParent** ve **getParentFile** metotları, içerisinde hiç `/` ve `\` olmayan bir yol ifadesi ile yaratılmış File nesnesinden elde ediliyorsa `null` değere dönerler. Bu durumda en iyi yöntem **getAbsoluteFile** metodu ile mutlak yol ifadesine ilişkin File referansı alınıp **getParent** veya **getParentFile** çağrılmalıdır.

>Aşağıdaki demo örneği inceleyiniz ve çeşitli yol ifadeleri ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        Console.writeLine("Absolute Path:%s", file.getAbsolutePath());  
        Console.writeLine("Absolute Path:%s", file.getAbsoluteFile().getAbsolutePath());  
        Console.writeLine("Parent:%s", file.getParent());  
        Console.writeLine("Parent:%s", file.getParentFile() == null ? "null" : file.getParentFile().getAbsolutePath());  
        Console.writeLine("Parent:%s", file.getAbsoluteFile().getParent());  
        Console.writeLine("Parent:%s", file.getAbsoluteFile().getParentFile().getAbsolutePath());  
        Console.writeLine("Name:%s", file.getName());  
    }  
}
```
  
>File sınıfının **delete** metodu ilgili yol ifadesinde bulunan dosya ya da dizini silmektedir. Boş olmayan dizinler bu metot ile silinemez. Bunun için önce dizinin boşaltılması sonra silinmesi gerekir. File sınıfının **delete** metodunun geri dönüş değeri yol ifadesine ilişkin bilginin silinip silinmediğini belirtir. Bu geri dönüş değerinden dosyanın hangi sebepten silinemediği anlaşılamaz.


>Aşağıdaki demo örneği inceleyiniz ve çeşitli yol ifadeleri ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.exists()) {  
            boolean result = file.delete();  
  
            if (file.isDirectory()) {  
                if (result)  
                    Console.writeLine("Directory '%s' deleted", args[0]);  
                else  
                    Console.writeLine("Directory '%s' can not be deleted", args[0]);  
            }  
            else {  
                if (result)  
                    Console.writeLine("File '%s' deleted", args[0]);  
                else  
                    Console.writeLine("File '%s' can not be deleted", args[0]);  
            }  
        }  
        else  
            Console.writeLine("%s not found", args[0]);  
    }  
}
```


>File nesnesi bir dizin gösteriyorsa bu durumda o dizin içerisindeki dosyalar ve dizinler elde edilebilir. Bir dizin içerisindeki dosyaların ve dizinlerin isimleri **list** metoduyla elde edilebilir. **list** metodu eğer File nesnesine ilişkin yol ifadesi bir dizin değilse veya bir IO problemi oluşursa null değerine geri döner.

>Aşağıdaki demo örneği inceleyiniz ve çeşitli yol ifadeleri ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.exists()) {  
            if (file.isDirectory()) {  
                String [] files = file.list();  
  
                if (files != null) {  
                    for (String s : files)  
                        Console.writeLine(s);  
                }  
                else  
                    Console.writeLine("IO problem occurred");  
            }  
            else  
                Console.writeLine("'%s' is not a directory", file.getAbsolutePath());  
        }  
        else  
            Console.writeLine("%s not found", args[0]);  
    }  
}
```

>Bir dizin içerisindeki dosyalara ve dizinlere ilişkin File referanslarından oluşan dizi **listFiles** metodu ile elde edilebilir.  **listFiles** metodu eğer File nesnesine ilişkin yol ifadesi bir dizin değilse veya IO problemi oluşursa null değerine  geri döner. 

>Aşağıdaki demo örneği inceleyiniz ve çeşitli yol ifadeleri ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.exists()) {  
            if (file.isDirectory()) {  
                File [] files = file.listFiles();  
  
                if (files != null) {  
                    for (File f : files)  
                        Console.writeLine(f.getAbsolutePath());  
                }  
                else  
                    Console.writeLine("IO problem occurred");  
            }  
            else  
                Console.writeLine("'%s' is not a directory", file.getAbsolutePath());  
        }  
        else  
            Console.writeLine("%s not found", args[0]);  
    }  
}
```

###### 14 Haziran 2026

File sınıfının **length** metodu ile ilgili dosyanın byte uzunluğu elde edilebilir.  

**Anahtar Notlar:** İşletim sistemlerinde dizinlerin uzunlukları (length) dizine ilişkin bir bilgi olarak tutulmaz. Bu durumda dizin ağacı dolaşılarak içerisindeki dosyalardan hesaplanması gerekir. Bu sebeple bir dizine ilişkin File nesnesi ile length metodu çağrıldığında sisteme göre farklı değerler elde edilebilir. Yani aslında bu length bilgisinin bir dizinin kapladığı alan anlamında doğrudan bir ilişkisi yoktur.

>Aşağıdaki demo örneği inceleyiniz ve çeşitli yol ifadeleri ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.exists()) {  
            if (file.isDirectory()) {  
                File [] files = file.listFiles();  
  
                if (files != null) {  
                    for (File f : files)  
                        Console.writeLine("%s %s", f.getName(), f.isDirectory() ? "<DIR>" : "%s B".formatted(f.length()));  
                }  
                else  
                    Console.writeLine("IO problem occurred");  
            }  
            else  
                Console.writeLine("'%s' is not a directory", file.getAbsolutePath());  
        }  
        else  
            Console.writeLine("%s not found", args[0]);  
    }  
}
```
  
>File sınıfının **mkdir** metodu verilen yol ifadesine ilişkin bir dizin yaratır. Eğer yol ifadesine ilişkin dizin varsa bu durumda hiç bir şey yapmaz. Metodun geri dönüş değeri dizinin yaratılıp yaratılmadığını gösteren boolean türden değerdir. mkdir metodu yaratılmak istenen dizine ilişkin yol ifadesi geçersizse dizini yaratamaz ve false değerine döner. 

>Aşağıdaki demo örneği inceleyiniz. Örnekte dizinin var olmasından dolayı mı ya da yol ifadesinin yanlış olmasından dolayı mı ya da dizin yaratma hakkı olmamasından dolayı yaratılamadığı anlaşılamaz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        Console.writeLine(file.mkdir() ? "Created" : "Not created");  
    }  
}
```
>Aşağıdaki demo örneği inceleyiniz. Örnekte dizinin var olmasından dolayı mı ya da yol ifadesinin yanlış olmasından dolayı yaratılamadığı anlaşılmaktadır ancak dizin yaratma hakkı olmadığından dolayı yaratılamadığı anlaşılamamaktadır. Dizin yaratma hakkı sistemden sisteme değişiklik gösterebilir, dolayısıyla genel bir kontrol yöntemi yoktur
```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        if (file.getAbsoluteFile().getParentFile().exists())  
            Console.writeLine(file.mkdir() ? "Created" : "Not created");  
        else  
            Console.writeLine("'%s' not exist", file.getAbsoluteFile().getParentFile().getAbsolutePath());  
    }  
}
```

>Verilen yol ifadesine ilişkin tüm dizinlerin yaratılabilmesi için **mkdirs** metodu kullanılmalıdır.

>Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.File;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        var file = new File(args[0]);  
  
        Console.writeLine(file.mkdirs() ? "Created" : "Not created");  
    }  
}
```

>Dosyanın bütünü üzerinde işlem yapan bazı sınıflar ve arayüzler JavaSE'ye daha sonradan eklenmiştir. Yeni eklenen bu  sınıflar ve arayüzler genel olarak `java.nio` paketi içerisinde bulunurlar.

###### 4 Temmuz 2026

>**Path Arayüzü, Paths ve Files Sınıfları**  Path arayüzü dosya ve dizinler üzerinde daha kolay işlem yapılmasını sağlayan bir arayüzdür. Kullanımı karışık gibi  gözükse de birçok işlemi kolaylaştırmaktadır. Tipik olarak bir Path referansı elde etmek için Java 11 ile birlikte  **of** metodu kullanılabilir. Java 11 öncesinde Path referansı elde etmek için genel olarak Paths isimli sınıfın **get**  metotları kullanılıyordu. Ancak bu sınıfın dökümanlarına göre ileride "deprecated" olabileceği söylendiğinden Java 11+  için bu sınıfın kullanımı tavsiye edilmez. Path arayüzü, Paths sınıfı ve Files sınıfı **java.nio.file** paketi içerisinde  bildirilmiştir ve Java 7 ile birlikte eklenmiştir. Path sınıfının **toString** metodu ile ilgili Path referansına ilişkin yol ifadesi String olarak elde edilebilir.
  
>Aşağıdaki basit örnek Java 11 öncesi Path referansı elde edilmesinin Paths sınıfıyla yapılışını göstermektedir. Paths  sınıfının get metodu formatı geçersiz bir path için `InvalidPathException` fırlatır

  ```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.nio.file.InvalidPathException;  
import java.nio.file.Path;  
import java.nio.file.Paths;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        try {  
            checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
            Path path = Paths.get(args[0]);  
  
            Console.writeLine("Path:%s", path);  
        }  
        catch (InvalidPathException e) {  
            Console.writeErrLine("Invalid Path:%s", e.getInput());  
        }  
    }  
}
  ```
  
 >Aşağıdaki basit örnek Java 11+ için Path referansı elde edilmesinin of metodu ile yapılışını göstermektedir. Path  arayüzünün of metodu da formatı geçersiz bir path için `InvalidPathException` fırlatır
 
 ```java
 package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.nio.file.InvalidPathException;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        try {  
            checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
            Path path = Path.of(args[0]);  
  
            Console.writeLine("Path:%s", path);  
        }  
        catch (InvalidPathException e) {  
            Console.writeErrLine("Invalid Path:%s", e.getInput());  
        }  
    }  
}
 ```
  

**Anahtar Notlar:** Bir yol ifadesinin (path) geçerli veya geçersiz olmasına yönelik formatı işletim sistemine özgüdür, değişiklik gösterebilmektedir. 

**Anahtar Notlar:** Path arayüzünün diğer metotları kullandıkça ele alınacaktır. Gerektiğinde dokümantasyondan bakılabilir.
 
>**Files Sınıfı:** Files utility sınıfı birçok yararlı static metot barındırır. Aslında File sınıfının da içerisinde bulunan birçok yararlı metodu barındırır. Ancak File sınıfında da Files'da da olmayan bazı metotlar vardır. Benzer şekilde Files sınıfında da File sınıfında olmayan bazı metotlar vardır. Aslında genel olarak Files sınıfı, File sınıfının birçok işleminin daha detaylandırılmış biçimidir. Files sınıfı (aslında bazı metotları anlamında File sınıfı da) yalnızca dosyanın bütünü  üzerinde işlemler yapan metotlara sahip değildir. Dosyanın verileri üzerinde işlem yapan çeşitli metotları da vardır.  Dosyanın verileri üzerinde işlem yapan metotlar ileride ele alınacaktır. Files sınıfının bir çok metodu yol ifadesini Path arayüzü olarak alırlar. Files sınıfının metotları çeşitli durumlar için çeşitli exception'lar fırlatırlar.
>
>Files sınıfının **exists, notExists, isRegularFile, isDirectory** gibi metotları vardır. Bu metotların LinkOption parametresi optional'dır, geçilmeyebilir. Bu parametrenin anlamı bu kursta ele alınmayacaktır. Files sınıfının **delete** ve **deleteIfExists** metotları path'e ilişkin dosyayı silerler. delete metodu parametresi ile aldığı path'e ilişkin dosya yoksa **NoSuchFileException** fırlatır. Path bir dizin belirtiyorsa ve boş değilse **DirectoryNotEmptyException** fırlatır. Herhangi bir IO problemi oluşursa **IOException** fırlatır. deleteIfExists metodu aldığı path'e ilişkin dosya yoksa false, varsa true değerine geri döner. Bu metot'da directory için doluysa **DirectoryNotEmptyException** fırlatır. Herhangi bir IO problemi oluşursa **IOException** fırlatır.

>Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.DirectoryNotEmptyException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        Path path = Path.of(args[0]);  
  
        try {  
            if (Files.exists(path)) {  
                boolean isDirectory = Files.isDirectory(path);  
                Files.delete(path);  
  
                if (isDirectory)  
                    Console.writeLine("Directory '%s' deleted", args[0]);  
                else  
                    Console.writeLine("File '%s' deleted", args[0]);  
            }  
            else  
                Console.writeLine("%s not found", args[0]);  
        }  
        catch (DirectoryNotEmptyException e) {  
            Console.writeErrLine("Non empty directory can not be deleted:%s", e.getMessage());  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```


>Yukarıdaki örnek aşağıdaki gibi de yapılabilir

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.DirectoryNotEmptyException;  
import java.nio.file.Files;  
import java.nio.file.NoSuchFileException;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        Path path = Path.of(args[0]);  
  
        try {  
            Files.delete(path);  
            if (Files.isDirectory(path))  
                Console.writeLine("Directory '%s' deleted", args[0]);  
            else  
                Console.writeLine("File '%s' deleted", args[0]);  
        }  
        catch (NoSuchFileException e) {  
            Console.writeLine("%s not found", e.getMessage());  
        }  
        catch (DirectoryNotEmptyException e) {  
            Console.writeErrLine("Non empty directory can not be deleted:%s", e.getMessage());  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```


>Yukarıdaki örnek `deleteIfExists` metodu ile aşağıdaki gibi de yapılabilir

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.DirectoryNotEmptyException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        Path path = Path.of(args[0]);  
  
        try {  
            boolean result = Files.deleteIfExists(path);  
  
            if (result) {  
                if (Files.isDirectory(path))  
                    Console.writeLine("Directory '%s' deleted", args[0]);  
                else  
                    Console.writeLine("File '%s' deleted", args[0]);  
            }  
            else  
                Console.writeLine("%s not found", args[0]);  
        }  
        catch (DirectoryNotEmptyException e) {  
            Console.writeErrLine("Non empty directory can not be deleted:%s", e.getMessage());  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```

###### 19 Temmuz 2026

>Files sınıfının **copy** metotları belirli bir kaynaktan başka bir kaynağa kopyalama yapmak amaçlı kullanılmaktadır. Bu  metodun overload'ları bulunmaktadır. Path türünden iki argümanla çağrılabilen overload'u birinci parametre ile alınan path'in, ikinci parametredeki path'e doğrudan kopyalanmasını sağlar. Bu metot kaynak (source) path ile belirtilen dosyayı bulamazsa `NoSuchFileException` fırlatır. Metot iki argüman ile çağrıldığında, hedef (destination/target) path'e ilişkin bir dosya mevcutsa bu durumda `FileAlreadyExistsException` nesnesini fırlatır. Bu metot hedef Path referansına geri döner

>Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            Path srcPath = Path.of(args[0]);  
            Path destPath = Path.of(args[1]);  
  
            Files.copy(srcPath, destPath);  
            Console.writeLine("File successfully copied");  
        }  
        catch (FileAlreadyExistsException ignore) {  
            Console.writeErrLine("File already exists:%s", args[1]);  
        }
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```
  
>Files sınıfının aşağıda kullanılan copy metodu **CopyOption** arayüzü türünden bir referans alır. Bu arayüzü destekleyen  **StandardCopyOption** isimli bir enum ile bu argüman verilebilir. **REPLACE_EXISTING** isimli enum sabiti ile hedef dosya  varsa bile yenisi ile değiştirilir. REPLACE_EXISTING değeri ile dizin kopyalaması yapıldığında hedef dizin varsa  ve içi boş değilse `DirectoryEmptyException` nesnesi fırlatılır. **COPY_ATTRIBUTES** isimli enum sabiti dosyanın tüm  özelliklerini hedef dosya için de kopyalar. Bir dosyaya ilişkin attribute'lar sistemden sisteme değişiklik gösterebilmektedir.  Bir standardı yoktur. **ATOMIC_MOVE** move metodu ve `multi-threaded` uygulamalara yöneliktir. Burada ele alınmayacaktır.  

>Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.DirectoryNotEmptyException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;  
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            Path srcPath = Path.of(args[0]);  
            Path destPath = Path.of(args[1]);  
  
            Files.copy(srcPath, destPath, REPLACE_EXISTING, COPY_ATTRIBUTES);  
            Console.writeLine("File successfully copied");  
        }  
        catch (DirectoryNotEmptyException ignore) {  
            Console.writeErrLine("Non empty directory:%s", args[1]);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```

>Files sınıfının **move** metodu kaynak yol ifadesinden hedef yol ifadesine taşıma işlemi yapar. copy metoduna benzer  şekilde kullanılabilir. move metodu iki argüman ile çağrılırsa exception bakımından copy metodu gibi davranır. Ayrıca  move metodu `rename` için de kullanılabilir. move metodu `COPY_ATTRIBUTES` sabitini desteklemez. Bu sabitin geçilmesi  durumunda `UnsupportedOperationException` fırlatılır  
    
>Aşağıdaki örneği inceleyiniz  

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.FileAlreadyExistsException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            Path srcPath = Path.of(args[0]);  
            Path destPath = Path.of(args[1]);  
  
            Files.move(srcPath, destPath);  
            Console.writeLine("File successfully moved");  
        }  
        catch (FileAlreadyExistsException ignore) {  
            Console.writeErrLine("File already exists:%s", args[1]);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```
  
>Aşağıdaki örneği inceleyiniz  

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.DirectoryNotEmptyException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            Path srcPath = Path.of(args[0]);  
            Path destPath = Path.of(args[1]);  
  
            Files.move(srcPath, destPath, REPLACE_EXISTING);  
            Console.writeLine("File successfully copied");  
        }  
        catch (DirectoryNotEmptyException ignore) {  
            Console.writeErrLine("Non empty directory:%s", args[1]);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```

###### 26 Temmuz 2026

 >**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı yazınız:  
 
`java org.csystem.app.io.file.copy.BackupAndCopyApp <src> <dest> `

 >Program src ile aldığı dosyayı dest ile aldığı dosya olarak kopyalayacaktır. Hedef dosya varsa hedef dosya ismi ve uzantısının sonuna "-bak" eklenerek yedeklenecektir. Daha önce yedeklenmişse yedeğin üzerine yazılacaktır. Bu işlemden sonra  kopyalama yapılacaktır.

>**Çözüm:**

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.io.file.copy.BackupAndCopy;  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.Path;  
  
public class BackupAndCopyApp {  
    private static void run(String[] args)  
    {  
        try {  
            BackupAsBakFile backupAsBakFile = new BackupAsBakFile();  
            BackupAndCopy backupAndCopy = new BackupAndCopy(Path.of(args[0]), Path.of(args[1]), backupAsBakFile);  
  
            backupAndCopy.copy();  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.function.IPredicate;  
  
import java.nio.file.Files;  
import java.nio.file.Path;  
import java.nio.file.StandardCopyOption;  
  
public class BackupAsBakFile implements IPredicate<Path> {  
    public boolean test(Path path) throws Exception  
    {  
        Files.copy(path, Path.of("%s-bak".formatted(path.toString())),  StandardCopyOption.REPLACE_EXISTING);  
  
        return true;  
    }  
}
```

###### 1 Ağustos 2026

>**Sınıf Çalışması:** Yukarıdaki örneği backup yapılan dosya varsa kullanıcıya  aşağıdaki gibi soracak biçime getiriniz:

`Backup file exists. Do you want to overwrite?`

>Cevabın `Y, y, N ve n` olmasına göre işlemi yapınız. Burada karakterler dışında bir karakter için hiç bir işlem yapılmayacaktır. Eğer `N` veya `n` girilirse hedef dosya, yedekleme yapılmadan üzerine (overwrite) kopyalanacaktır.

**Çözüm:**

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.io.file.copy.BackupAndCopy;  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.Path;  
  
public class BackupViaPromptAndCopyApp {  
    private static void run(String[] args)  
    {  
        try {  
            BackupViaPrompt backupViaPrompt = new BackupViaPrompt();  
            BackupAndCopy backupAndCopy = new BackupAndCopy(Path.of(args[0]), Path.of(args[1]), backupViaPrompt);  
  
            backupAndCopy.copy();  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.function.IPredicate;  
import org.csystem.util.console.Console;  
  
import java.nio.file.Files;  
import java.nio.file.Path;  
import java.nio.file.StandardCopyOption;  
  
public class BackupViaPrompt implements IPredicate<Path> {  
    private static char getOption()  
    {  
        char c;  
  
        do  
            c = Console.readChar("Backup file exists. Do you want to overwrite?");  
        while (c != 'Y' && c != 'y' && c != 'N' && c != 'n');  
  
        return c;  
    }  
  
    public boolean test(Path path) throws Exception  
    {  
        Path backPath = Path.of("%s-bak".formatted(path.toString()));  
        char option;  
  
        if (Files.notExists(backPath) || (option = getOption()) == 'Y' || option == 'y')  
            Files.copy(path, backPath, StandardCopyOption.REPLACE_EXISTING);  
  
        return true;  
    }  
}
```

>Yukarıdaki iki örnekte kullanılan UDT'ler

>IPredicate arayüzü

```java
package org.csystem.function;  
  
public interface IPredicate<T> {  
    boolean test(T t) throws Exception;  
}
```

>BackupAndCopy sınıfı

```java
package org.csystem.io.file.copy;  
  
import org.csystem.function.IPredicate;  
  
import java.io.IOException;  
import java.nio.file.FileAlreadyExistsException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
import java.nio.file.StandardCopyOption;  
  
public class BackupAndCopy {  
    private final Path m_srcPath;  
    private final Path m_destPath;  
    private final IPredicate<? super Path> m_predicate;  
  
    private void doIfDestinationPathExists() throws IOException  
    {  
        try {  
            if (m_predicate.test(m_destPath))  
                Files.copy(m_srcPath, m_destPath, StandardCopyOption.REPLACE_EXISTING);  
        } catch (Exception e) {  
            throw new IOException(e.getMessage());  
        }  
    }  
  
    public BackupAndCopy(Path srcPath, Path destPath, IPredicate<? super Path> predicate)  
    {  
        m_srcPath = srcPath;  
        m_destPath = destPath;  
        m_predicate = predicate;  
    }  
  
    public void copy() throws IOException  
    {  
        try {  
            Files.copy(m_srcPath, m_destPath);  
        }  
        catch (FileAlreadyExistsException ignore) {  
            doIfDestinationPathExists();  
        }  
    }  
}
```


>Files sınıfının **createDirectory** metodu aldığı Path'e ilişkin dizini yaratmak için kullanılabilir. Bu metodun ikinci  parametresi dosya özelliklerine (file attributes) ilişkindir. Sistemden sisteme değişiklik gösterebilmektedir. Burada  ele alınmayacaktır. Metodun ikinci parametresine argüman geçilmediğinde default attribute'lar geçerli olacaktır. Metot  yaratılmak istenen directory'ye ilişkin path varsa `FileAlreadyExistsException` fırlatır. İkinci parametreye geçilen argüman geçersizse (aslında o sistemde desteklenmiyorsa) `UnsupportedOperationException` fırlatır. Herhangi bir IO problemi  durumunda IOException fırlatır. createDirectory metodu yaratılmak istenen dizine ilişkin parent directory'ler yoksa  yaratmaz. Parent directory'lerin de birlikte yaratılması için **createDirectories** metodu kullanılabilir. Bu metot ilgili path varsa ve directory değilse `FileAlreadyExistsException` fırlatır.
  
>Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.FileAlreadyExistsException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        try {  
            Path path = Path.of(args[0]);  
  
            Files.createDirectory(path);  
            Console.writeLine("Directory '%s' created", args[0]);  
        }  
        catch (FileAlreadyExistsException e) {  
            Console.writeErrLine("'%s' exists", e.getFile());  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```

>Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import org.csystem.util.console.Console;  
  
import java.io.IOException;  
import java.nio.file.Files;  
import java.nio.file.Path;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
class Application {  
    public static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        try {  
            Path path = Path.of(args[0]);  
  
            Files.createDirectories(path);  
            Console.writeLine("Directory '%s' created", args[0]);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
}
```

###### 9 Ağustos 2026
###### Dosya Verileri Üzerinde İşlem Yapan Sınıflar

>Dosyanın verileri üzerinde işlem yapan sınıflar genel olarak iki kategoriye ayrılmıştır: **Dosyaya yazma (output) yapan  sınıflar ve dosyadan okuma (input) yapan sınıflar.** Aslında Java'da genel olarak tüm giriş çıkış (input/output) işlemleri bu  şekilde yapılmaktadır.  
  
>**InputStream ve OutputStream Sınıfları:** Temel giriş/çıkış işlemleri için `InputStream` ve `OutputStream` isimli iki adet abstract sınıf bulunmaktadır. Bu sınıflar sadece dosyalar için değil, diğer giriş çıkış işlemleri için de kullanılabilmektedir. Yani Java'da **okuma (read) ve yazma (write)** ya da daha genel ismiyle **giriş (input) ve çıkış (output)** işlemleri bu sınıflar ile soyutlanmıştır (abstraction). Bu  sınıflar Closeable arayüzünü desteklerler.  

>**FileInputStream ve FileOutputStream Sınıfları:** Dosya işlemleri için temel iki sınıf `FileInputStream` ve `FileOutputStream` sınıflarıdır. FileOutputStream sınıfı OutputStream sınıfından, FileInputStream sınıfı da InputStream sınıfından türetilmiştir. Bu sınıflar Closeable ve  dolayısıyla AutoCloseable arayüzünü desteklediklerinden `try with resources (twr)` deyimi ile kullanılabilirler. Bir dosyanın verileri üzerinde işlem yapılmadan önce o dosyanın `açılması (open)` gerekir. Dosyanın açılması demek işletim sistemi  düzeyinde aşağı seviyeli bazı işlemlerin yapılması demektir. Dosyanın açılması işlemi bu sınıfların ctor'ları tarafından  yapılmaktadır. Kapatılması için de `close` metodu kullanılmalıdır. Bilindiği gibi Java 7 ile eklenen `twr` deyimi close işlemini otomatik olarak yapmaktadır. Bu sınıflar java.io paketi içerisinde bildirilmişlerdir.

>**Dosya Göstericisi (file pointer) Kavramı:** Uzantı ne olursa olsun dosyaların içerisinde byte yığınları vardır. Biz de temelde dosyalardan byte okuyup onlara byte yazarız. Dosya içerisindeki her bir byte'ın ilk byte 0(sıfır) olmak üzere artan sırada bir `pozisyon (position)` numarası vardır. Buna dosya terminolojisinde **ilgili byte’ın offset’i** denilmektedir. Dosya göstericisi bir imleç gibi (kalemin ucu gibi) düşünülebilir. Dosya göstericisi o anda dosyanın neresinden itibaren okuma ya da yazma yapılacağını anlatan bir `konum (offset)` belirtir:  

```
x x x x x x x x  
0 1 2 3 4 5 6 7
```

>Bu örnekte dosya göstericisinin 2 numaralı offset'i gösterdiğini düşünelim. Biz artık 2 byte'lık bir okuma yaparsak 2 ve 3 numaralı offset'teki byte'ları okuruz. Okuma ve yazma yapan metotlar okunan ya da yazılan miktar kadar dosya  göstericisini otomatik ilerletmektedir. Dosya açıldığında dosya göstericisi özel modlarda açılmamışsa başlangıçta 0(sıfır)'ıncı offset'tedir. Yazma sırasında dosya göstericisinin gösterdiği yerden itibaren eski bilgiler ezilerek yeni bilgiler yazılır. Fakat, özel bir durum olarak dosya göstericisi dosyanın sonundaysa dosyaya yazma yapıldığında dosya büyütülmektedir. Başka bir deyişle bu durumda dosyaya yazma işlemi **ekleme (append)** anlamına gelir.  
  
>**Dosya Göstericisinin EOF Durumu:**  Dosya göstericisinin dosyanın son byte'ından sonraki byte'ı göstermesi durumuna **EOF (End Of File)** durumu denir. EOF durumundan okuma yapılamaz. Fakat dosya göstericisi EOF durumundayken dosyaya yazma yapılabilir. Bu durum dosyaya ekleme anlamına gelir. **Dosyaya ekleme yapmanın taşınabilir (portable) başka bir yolu yoktur.** **Dosya göstericisinin dosyanın son byte’ından sonraki byte’ı göstermesi taşınabilir olarak mümkündür. Ancak daha ileride bir yeri taşınabilir olarak göstermesi söz konusu değildir.**  
  
**Anahtar Notlar:** Bazı işletim sistemleri dosyanın sonundan daha ileriye konumlanmaya ve veri yazmaya izin verebilmektedir. Bu duruma genel olarak `dosya delikleri (file holes)` denir. Aşağı seviyede anlamlıdır. Her işletim sistemi desteklemeyebileceğinden, Java'da doğrudan yapılamaz. Ayrıca yapılsa bile program taşınabilir olmaz.  
###### 15 Ağustos 2026

>FileOutputStream sınıfının File türden ve String türden tek parametreli ctor'ları yeni bir dosya yaratıp dosyayı açar.  Eğer dosya varsa dosyayı **sıfırlayarak (truncate)**, yani bilgileri kaybederek açar. Yazma işlemi için en temel metot  bir byte'lık bilgiyi yazan **write** metodudur. Bu ctor'lar path'in normal dizin (directory) belirtmesi durumunda veya dosya yoksa ve yaratılamıyorsa veya yaratılmaya ilişkin herhangi bir problem oluşuyorsa **FileNotFoundException** fırlatır.

```java
package org.csystem.app.io.file.output;  
  
import org.csystem.util.console.Console;  
  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Random;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class WriteRandomBytesApp {  
    private static void writeFile(String path, int count)  
    {  
        try (FileOutputStream fos = new FileOutputStream(path)) {  
            Random r = new Random();  
  
            for (int i = 0; i < count; ++i) {  
                byte v = (byte)r.nextInt(-128, 128);  
  
                Console.write("%d ", v);  
                fos.write(v);  
            }  
  
            Console.writeLine();  
        }  
        catch (FileNotFoundException ignore) {  
            Console.writeErrLine("Error occurred while creating file:%s", path);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            int count = Integer.parseInt(args[1]);  
  
            if (count < 1)  
                throw new NumberFormatException();  
  
            writeFile(args[0], count);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Count must be a positive integer");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

>FileInputStream sınıfının File türden ve String türden ctor'ları varolan bir dosyayı dosya göstericisi başta olacak  şekilde (yani dosya göstericisi sıfır numaralı offset'i gösterecek şekilde) açar.  Bu ctor'lar path'in normal dizin (directory) belirtmesi durumunda veya dosya yoksa veya herhangi bir problem oluşuyorsa **FileNotFoundException** fırlatır. Okuma işlemi en temel olarak 1 byte okuma yapan parametresiz **read** metodu ile yapılabilir. read metodu dosya sonuna gelindiğinde -1 değerine geri döner. read metodunun başarı durumunda döndürdüğü değerin düşük anlamlı 1 byte'lık kısmında bilgi saklanır. Bu durumda programcı başarı durumunda tür dönüştürme operatörü kullanarak değeri elde edebilir.

```java
package org.csystem.app.io.file.input;  
  
import org.csystem.util.console.Console;  
  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class ReadBytesApp {  
    private static void readFile(String path)  
    {  
        try (FileInputStream fis = new FileInputStream(path)) {  
            int v;  
  
            while ((v = fis.read()) != -1) {  
                byte b = (byte)v;  
  
                Console.write("%d ", b);  
            }  
  
            Console.writeLine();  
        }  
        catch (FileNotFoundException ignore) {  
            Console.writeErrLine("Error occurred while opening file:%s", path);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(1, args.length, "Wrong number of arguments");  
  
        try {  
            readFile(args[0]);  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

>FileOutputStream sınıfının boolean türden parametresi de olan ctor'ları ile bu parametre true ise dosyanın sonuna ekleme yapılabilir. Bu durumda dosya varsa truncate işlemi yapılmaz. Bu parametrenin false verilmesi tek parametreli ctor'ları ile aynı anlamdadır.

```java
package org.csystem.app.io.file.output;  
  
import org.csystem.util.console.Console;  
  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Random;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class AppendRandomBytesApp {  
    private static void writeFile(String path, int count)  
    {  
        try (FileOutputStream fos = new FileOutputStream(path, true)) {  
            Random r = new Random();  
  
            for (int i = 0; i < count; ++i) {  
                byte v = (byte)r.nextInt(-128, 128);  
  
                Console.write("%d ", v);  
                fos.write(v);  
            }  
  
            Console.writeLine();  
        }  
        catch (FileNotFoundException ignore) {  
            Console.writeErrLine("Error occurred while creating file:%s", path);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            int count = Integer.parseInt(args[1]);  
  
            if (count < 1)  
                throw new NumberFormatException();  
  
            writeFile(args[0], count);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Count must be a positive integer");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

###### 22 Ağustos 2026

>FileOutputStream sınıfının byte türden dizi parametreli write metotları ile yazma işlemi yapılabilir

**Anahtar Notlar:** Random sınıfının `nextBytes` metodu (RandomGenerator arayüzünde default olarak bildirilmiştir) parametresi ile aldığı byte türden diziyi rassal olarak üretilmiş değerler ile doldurur

```java
package org.csystem.app.io.file.output;  
  
import org.csystem.util.console.Console;  
  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Random;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class AppendRandomByteArrayApp {  
    private static void writeFile(String path, int count)  
    {  
        try (FileOutputStream fos = new FileOutputStream(path, true)) {  
            Random r = new Random();  
            byte [] buf = new byte[count];  
  
            r.nextBytes(buf);  
  
            Console.write("Generated data:");  
            for (byte d : buf)  
                Console.write("%d ", d);  
  
            fos.write(buf);  
            Console.writeLine();  
        }  
        catch (FileNotFoundException ignore) {  
            Console.writeErrLine("Error occurred while creating file:%s", path);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            int count = Integer.parseInt(args[1]);  
  
            if (count < 1)  
                throw new NumberFormatException();  
  
            writeFile(args[0], count);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Count must be a positive integer");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

>FileInputStream sınıfının byte dizi parametreli read metotları byte türden dizinin içerisine dosyadaki bilgileri okur. **Ne kadar okuduğu miktarı ile de geri döner.** Bu durumda programcının ne kadar okunduğu miktarına göre dizinin elemanlarını kullanması gerekir. Yani aslında dizinin uzunluğu ya da okumak için verilen sayı en fazla ne kadar okunacağını belirtir.

```java
package org.csystem.app.io.file.input;  
  
import org.csystem.util.array.ArrayUtil;  
import org.csystem.util.console.Console;  
  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class ReadBytesViaChunkApp {  
    private static void readFile(String path, int chunkSize)  
    {  
        try (FileInputStream fis = new FileInputStream(path)) {  
            byte [] buf = new byte[chunkSize];  
            int result;  
  
            while ((result = fis.read(buf)) != -1)  
                ArrayUtil.print(buf, result, " ", ", ");  
  
            Console.writeLine();  
        }  
        catch (FileNotFoundException ignore) {  
            Console.writeErrLine("Error occurred while opening file:%s", path);  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(2, args.length, "Wrong number of arguments");  
  
        try {  
            int chunkSize = Integer.parseInt(args[1]);  
  
            if (chunkSize <= 0)  
                throw new NumberFormatException();  
  
            readFile(args[0], chunkSize);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Invalid chunk size");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

>**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı açıklamalara göre yazınız:  

```java
java org.csystem.app.io.file.copy.CopyFileViaBlockApp <src> <dest> <block> 
```

>**Açıklamalar:**
- Programda Files sınıfı <u>kullanılmayacaktır</u>.
- Program `src` ile belirtilen yol ifadesine ilişkin dosyayı `dest` ile belirtilen yol ifadesine ilişkin dosyaya kopyalayacaktır.
- Dosya varsa `truncate` edilecektir.
- Dosya bloklar halinde kopayalanacak ve blok uzunluğu da komut satırı argümanından alınacaktır. 

**Anahtar Notlar:** Files kullanılarak yapılanın daha iyi olduğu söylenebilir. Çünkü işletim sistemine özgü bazı özel  fonksiyonlar da Files sınıfının metotları içerisinde kullanılır.

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.util.console.Console;  
  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class CopyFileViaBlockApp {  
    private static void copyFile(String srcPath, String destPath, int blockSize)  
    {  
        try (FileInputStream fis = new FileInputStream(srcPath); FileOutputStream fos = new FileOutputStream(destPath)) {  
            byte [] buf = new byte[blockSize];  
            int result;  
  
            while ((result = fis.read(buf)) > 0)  
                fos.write(buf, 0, result);  
  
            Console.writeLine("File copied successfully");  
        }  
        catch (IOException e) {  
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(3, args.length, "Wrong number of arguments");  
  
        try {  
            int blockSize = Integer.parseInt(args[2]);  
  
            if (blockSize <= 0)  
                throw new NumberFormatException("Wrong number of arguments");  
  
            copyFile(args[0], args[1], blockSize);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Invalid block size");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```

>Yukarıdaki örnek aşağıdaki gibi `FileUtil` sınıfı kullanılarak da yapılabilir

```java
package org.csystem.app.io.file.copy;  
  
import org.csystem.util.console.Console;  
import org.csystem.util.io.file.FileUtil;  
  
import java.io.UncheckedIOException;  
  
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;  
  
public class CopyFileViaFileUtilApp {  
    private static void copyFile(String srcPath, String destPath, int blockSize)  
    {  
        try {  
            FileUtil.copy(srcPath, destPath, blockSize);  
            Console.writeLine("File copied successfully");  
        }  
        catch (UncheckedIOException e) {  
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());  
        }  
    }  
  
    private static void run(String[] args)  
    {  
        checkLengthEquals(3, args.length, "Wrong number of arguments");  
  
        try {  
            int blockSize = Integer.parseInt(args[2]);  
  
            if (blockSize <= 0)  
                throw new NumberFormatException("Wrong number of arguments");  
  
            copyFile(args[0], args[1], blockSize);  
        }  
        catch (NumberFormatException ignore) {  
            Console.writeErrLine("Invalid block size");  
        }  
        catch (Exception e) {  
            Console.writeErrLine("Error occurred:%s", e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        run(args);  
    }  
}
```


>**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı yazınız:  
```java
java org.csystem.app.io.file.copy.CopyExistFilesApp <dest directory> <file path1> <file path2> ... <file pathN>  
```

>**Açıklamalar:**  
- Program komut satırı argümanları ile aldığı dosyaları, ilk komut satırı argümanı ile aldığı dizine kopyalayacaktır. 
- Olmayan dosyalar için uygun mesajları verecek ve kopyalama işlemine devam edecektir.
- Program dizinde varolan dosyaların üzerine yazacaktır (overwrite). Üzerine yazdığını uygun bir mesajla bildirecektir.
- Directory yoksa yaratılacaktır  
 
 
>**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı yazınız:  

```java
java org.csystem.app.io.file.copy.CopyNotExistFilesApp <dest directory> <file path1> <file path2> ... <file pathN>  
```

>**Açıklamalar:** 
- Program komut satırı argümanları ile aldığı dosyaları, ilk komut satırı argümanı ile aldığı dizine kopyalayacaktır. 
- Olmayan dosyalar için uygun mesajları verecek ve kopyalama işlemine devam edecektir.
- Program dizinde varolan dosyalar için ilgili mesajları verecek ve kopyalamayacaktır.
- Directory yoksa yaratılacaktır.

  
  
  
**Sınıf Çalışması:** Komut satırından aşağıdaki gibi çalışan programı yazınız:  
```java
java org.csystem.app.io.file.copy.CopyExistFilesViaOptionApp <dest directory> <file path1> <file path2> ... <file pathN>  
```

**Açıklamalar:**  
- Program komut satırı argümanları ile aldığı dosyaları, ilk komut satırı argümanı ile aldığı dizine kopyalayacaktır. 
- Olmayan dosyalar için uygun mesajları verecek ve kopyalama işlemine devam edecektir.  
- Program dizinde varolan dosyalar için aşağıdaki gibi bir menü çıkartacak ve seçime göre uygun işlemi yapacaktır:  
	- Overwrite  
	- Append  
	- Skip for other options  
* Directory yoksa yaratılacaktır  
  
>