# 나중에 찾아보기 쉽게 정리
- #### 버터나이프 추가
  - @Bind와 @BindView 는 버전차이(@Bind가 옛날 버전)
````
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:25.0.1'
    compile 'com.android.support:design:25.0.1'
    compile 'com.jakewharton:butterknife:8.8.0'

    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.0' // 이거 꼭해야함. 이거 안해서 하루종일 시간날림

}

````
## 레이아웃
- #### 오른쪽 배치
  - `android:layout_gravity="right"`


- #### content
  - `wrap_content` = 자식 컴포넌트 크기에 맞게 할당 됨
  - `match_content` = 부모 레이아웃의 크기에 맞게 할당 됨
