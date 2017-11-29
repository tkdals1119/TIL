# TENSORFLOW
 - 데이터 플로우 그래프(노드로 이루어짐)를 사용해서 numerical 한 computation 계산을 할 수 있는 라이브러리

 - Tensor 는 기본적으로 Array 를 뜻함
   - Rank
     - 스칼라 : rank=1, 1,2차원Array : rank=2
   - Shape
     - [[1,2,3], [2,3,4], [4,5,6]] = [3,3](shape)
      - none = 1차원 Array 고 아무값이나 들어올 수 있다
   - Type
     - 대부분은 float32, int32를 많이 씀

## Machine Learning
 - 프로그램 자체가 데이터를 보고 학습해서 뭔가를 배우는 능력을 갖는 프로그램
    - Supervised Learning
       - 정해져 있는 데이터, 레이블이 정해져 있음. 즉, training set 으로 학습
       - **regression** : ex) 0 ~ 100점 중 예측해봄
       - **binary classification** : ex) 'pass / non-pass' 둘 중에 하나를 고름
       - **multi-label classification** : ex) 'A,B,C,D,F' 등급 중 하나를 고름(레이블이 많음)

    - Unsupervised Learning
       - 레이블이 정해져 있지 않음

  - 노드생성->세션생성->그래프실행
     - 세션을 생성안하고 노드 자체를 출력할 경우 결과값이 아닌 Tensor 값이 나온다
        - 결과값을 출력하기 위해선 **Session** 정의

  - placeholder : 학습용 데이터를 담는 일종의 그릇 역할
     - 필요한 값들은 sess.run 할 때 feed_dict 로 담으면 된다

  - Cost function(Loss function)
     - 세운 가설과 실제 데이터와의 차이를 나타냄
     - H(X):예측값, y:실제값
     - 모든 데이터의 (H(x)-y)^2 를 구해 더하고 데이터 개수로 나누면 Cost function
     - cost 값의 최소화가 목표

## python
```
> 가장 기본
import tensorflow as tf
hello = tf.constant("hello, tensorflow!") // "hello, tensorflow!"라는 텍스트를 가진 hello노드 생성

sess = tf.Session() // computation 그래프를 실행시키기 위함
print(sess.run(hello))
```
  - tf.reduce_maen : 평균 구하는 함수
  - variable 을 사용했으면 run 할 때 sess.run(tf.global_variables_initializer()) 을 해야함

  - cost 를 최소화 하는 과정
  ```
  cost = tf.reduce_mean(tf.square(hypothesis - y_train))

  optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
  train = optimizer.minimize(cost)
  ```
