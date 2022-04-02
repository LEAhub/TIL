자바빈과 의존 관계
=====================

### 1. 컴포넌트 방식으로 스프링 빈 등록하기

```
Controller를 통해서 외부 요청을 받음

Repository에서 데이터를 저장

Service 로직을 만듦
```

```
Controller에는 @Controller를 입력
Service에는 @Service를 입력

Controller 내에서 생성자 메소드에 @Autowired된 @Service 객체를 주입함 Dependency Injection
											의존 관계를 주입함
Service  내에서는 생성자 메소드에 @Autowired된 매개변수로 받은 클래스의 객체를 주입함

----> 위의 어노테이션에는 component가 있음 그래서 컴포넌트 스캔 방식이라 부름
```


```
컴포넌트와 관련된 어노테이션이 있으면 
스프링이 컴포넌트 관련된 어노테이션이 붙은 클래스의 객체를 생성하여
스프링컨테이너에 등록함
```


```
@component :스프링 빈으로 자동 등록된다. 
@Autowired : 선을 연결해주는 역할, 연관관계를 만들어줌
```


```
그렇다고 모든 패키지의 클래스에 어노테이션이 붙는다고 스프링 빈으로 컴포넌트 스캔이 되나?
아니다. 인텔리제이 기준, ~~~Application.java가 존재하는 패키지 내에서 생성한 클래스들만 기능 구현 가능하고
그 밖에 생성한 패키지의 클래스는 기능을 구현할 수 없다. 어떠한 설정이 있으면 가능하긴 하지만
기본적으로 컴포넌트 스캔 대상에 포함되지 않는다.


스프링 빈을 등록할 때 객체 하나만(싱글톤) 등록한다. 따라서 같은 스프링 빈이면 모두 같은 인스턴스다.
```

### 2. 자바 코드로 직접 스프링 빈 등록하기

```
보통 Controller 클래스는 @Controller, @Autowired 어노테이션을 입력해야 한다.
하지만 Repository와 Service에서는 컴포넌트 관련 어노테이션이 없는데 어떻게 해야 할까?
자바 코드로 직접 스프링을 등록하는 방법이 있다.
따로 클래스를 생성하여 아래와 같이 코드를 입력한다. 아래의 코드는 예시다.
```

```
@Configuration
public class SpringConfig {
    @Bean
    public BookService bookService(){
        return new BookService(bookRepository());
    }

    @Bean
    public BookRepository bookRepository(){
        return new MemoryBookRepository();
    }
}

MemoryBookRepository는 인터페이스 BookRepository를 구현한 클래스이다.
```

```
스프링이 해당 클래스의 @Configuration 어노테이션을 만나면
클래스 안의 해당 @Bean 어노테이션을 찾아가 해당 인스턴스(빈)을 스프링 컨테이너에 저장한다.
```
```
그럼 자바 코드로 작성한 스프링빈을 사용하며 얻는 이점은 무엇이 있을까?
우선 학습하는 동안은 DB연동 없이 Repository로 데이터를 저장하는 가정으로 수업을 진행했다.
만일 후에 DB연동을 하게 되었는데 코드를 모두 바꿔야 하나? 스프링 빈을 사용하면 그런 수고를 덜게 된다.
만일 컴포넌트를 사용하게 되면 코드 수정이 들어가지만 자바 코드로 작성한 스프링빈을 사용하면
@Configuration이 입력된 해당 클래스만 코드 수정이 들어가므로 프로젝트를 좀 더 간단하게 다룰 수 있다.
```