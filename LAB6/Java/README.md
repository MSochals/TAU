# EasyMock

EasyMock to oparty na Javie framework do mockowania, którego używa się w połączeniu z innymi frameworkami do testowania jednostkowego, takimi jak JUnit i TestNG. EasyMock jest bardzo podobny do frameworku Mockito.

EasyMock pozwala na tworzenie mocków konkretnych interfejsów i klas, aby określać ich zachowania. Później możemy użyć utworzonych mocków do napisania kodu testującego nasze główne klasy. W ten sposób pisanie testów jednostkowych jest dużo łatwiejsze, ponieważ nie musimy przejmować się zewnętrznymi zależnościami.

### Czym jest mockowanie?

Mockowanie to symulowanie odpowiedzi jakiegoś serwisu, aby była zgodna z naszymi oczekiwaniami. Oznacza to, że możemy zasymulować, iż usługa na przykład działa lub nie, aby w łatwiejszy sposób wywołać wszystkie testy.

## Przypisy i metody

Przypisy, które dostępne są w bibliotece EasyMock:

* `@Mock` - określa obszar, który ma zostać zmockowany
* `@TestSubject` - używany wraz z obszarem, dzięki temu EasyMock wstrzyknie mocki utworzone za pomocą `@Mock` do swojego obszaru
* `@BeforeEach` - w nim musimy użyć metody `EasyMockSupport.injectMocks(Object)` aby zainicjować i wstrzyknąć zmockowane objekty

## Ograniczenia

* Za pomocą frameworku EasyMock nie możemy mockować metod prywatnych (private) i ostatecznych (final/finally).
* EasyMock posiada wbudowane zachowanie metod `equals()`, `toString()`, `hashCode()` i `finalize()`. Oznacza to, że nie możemy narzucać spersonalizowanego zachowania dla tych metod.
  
## Wymagania

* Framework do testów jednostkowych (np. JUnit, TestNG)
* Maven

## Instalacja

Należy dodać poniższą dependencję do pliku pom.xml
```xml
<dependency>
	<groupId>org.easymock</groupId>
	<artifactId>easymock</artifactId>
	<version>3.6</version>
	<scope>test</scope>
</dependency>
```

## Przykłady

* plik [pom.xml](https://github.com/MSochals/TAU/tree/main/LAB6/Java/examples/pom.xml) z dodaną biblioteką JUnit oraz EasyMock
* plik [main.java](https://github.com/MSochals/TAU/tree/main/LAB6/Java/examples/main.java) z dodaną przykładową klasą oraz interfejsem
* plik [test.java](https://github.com/MSochals/TAU/tree/main/LAB6/Java/examples/test.java) z dodanymi przykładowymi testami oraz mockiem
