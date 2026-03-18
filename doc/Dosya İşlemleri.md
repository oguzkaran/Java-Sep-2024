
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

