## 스택
Paging3, RecyclerView, ViewPager2, Hilt, Glide, MVVM, DataBinding, Navigation, ViewModel, Coroutine, Retrofit2
## 앱 구조
### Main
![image](https://user-images.githubusercontent.com/88112525/211182164-34018286-4746-4f7e-a1ec-7c9328369fb2.png)
### Broad
![image](https://user-images.githubusercontent.com/88112525/211182174-35ca5182-ac5f-4ee7-a2ef-c5cae05ec160.png)
## 설명
MVVM 패턴을 사용하여 Model과 View의 관심사를 분리시키고 AAC ViewModel이 MVVM의 ViewModel 역할을 하도록구현하였습니다.
따라서 ViewModel은 Hilt 라이브러리를 사용하여 Repository를 주입받고 Repository는 네트워크 통신을 위해 Retrofit요청 메소드가 존재하는 인터페이스를 주입받습니다.
Repository에게 전달 받은 데이터는 데이터스트림 형태로 바뀌고 MVVM의 의도에 맞게 DataBinding을 통해 동기화하여 화면을 업데이트합니다. 따라서 Activity, Fragment의 코드를 최소화 할 수 있었습니다.
