MVC   (MVC란 무엇인가? : https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm)
===========================================================
MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

​

Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

​

View - View represents the visualization of the data that model contains.

​

Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

​

Implementation



We are going to create a Student object acting as a model.StudentView will be a view class which can print student details on console and StudentController is the controller class responsible to store data in Student object and update view StudentView accordingly.

​

---------------------------------------------------------------------------------------------------




예전에 자바 상속이랑 객체 조오오금 이해한 걸 난 이제 모든 걸 다 안다며 이런 저런 검색하다가 자바는 스프링이란 말을 들었다. 



무턱대로 spring을 배우겠다며 책 사서 아직까지 20페이지 밖에 못 읽었다. 



뭔가 아닌 거 같아서 jsp를 배우고 있다. 지금 jsp 책을 다 끝내면 spring 다시 들어간다.



그때 MVC가 뭔지 궁금해서 구글링하여 얻은 정보를 블로그에 작성했고 그 내용을 조금 잘라서 이 md파일 상단에 작성했다.


```
modle : 자바빈, DB연동으로 데이터를 삭제, 추가, 수정, 삽입 등을 할 수 있다.
        자바빈과 자바의 클래스를 모델로 사용한다.

view :  controller에서 받은 데이터를 활용한다.
        jsp 페이지를 뷰로 사용한다.

controller : view와 model 사이에서 역할을 한다. 웹 브라우저에서 요청이 들어오면 model에게 데이터를 다루게 중간 다리 역할을 하고
            model이 전한 데이터, 정보들을 view에게 보내는 중간 다리 역할을 한다.
            서블릿을 컨트롤러로 사용한다.
```



## 모델 1
```
내가 여태 책을 통해 배운 내용은 model 1 방식이었다.
jsp 파일에서 controller와 view 역할을 했고 javaBean은 model 역할을 했다.
장점 : 모델 1의 장점은 크지 않은 프로젝트에 적합하고 수준 높은 지식은 필요하지 않는다.

단점 : 모델 1의 단점은 웹 애플리케이션이 복잡해질수록 다루기 힘들다. 유지보수가 어렵다는 건데 프로그래밍에서는 유지보수가 중요하다.
      유지보수가 어렵다는 건 시간과 노력이 그만큼 든다는 거고 그렇다는 건 복잡한 구조로 설계되었다는 결과가 나온다.
      만일 신입이나 다른 사람들이 수정하기 어렵다는 건데 그런 복잡한 프로젝트는 선호하지 않는다.
      그리고 view와 controller를 하나로 다룬다는 건 디자이너와 개발자의 역할을 제대로 할 수 없게 된다.
```

## 모델 2
```
모델 2는 controller와 view가 분리되었다.
웹브라우저에서 요청을 받은 controller는 model에게 웹브라우자가 원하는 정보를 다루길 요청한다.
model의 정보를 받은 controller는 그대로 view에게 그 정보를 전달한다.
그럼 view는 웹브라우저에 응답하게 되는 거다. 뷰는 어떠한 처리 로직을 포함하지 않는다.

이렇게 각자의 역할이 분리되어 있다는 건 디자이너와 개발자의 역할도 명확하게 분리되어 있다는 의미이다.
모델 1과 달리 더 복잡한 프로젝트에 적합하다.

단점으로는 초기에 구조 설계를 위한 많은 시간이 필요하기 때문에 개발 기간이 길어지고
모델 1보다 복잡한 구조를 지니고 있어서 팀원들의 높은 수준을 요구한다.

모델 2 간단한 예제 실습했는데 복잡하다. 왜 굳이 이렇게 할까 싶은데 그런 이유가 있다고 하니 그런가 보다 싶다.
```


여태 나는 model이라고 하니까 뭐 변수 설정하고 그런, 말 그대로 형체만 지닌 줄 알았다.



controller라고 하니까 모든 로직을 구현하는 줄 알았다.



예를 들어 말 그대로 모델과 디자이너 이런 느낌이랄까.



오늘 공부를 하니 내가 이상하게 이해하고 있구나, 생각했다.
