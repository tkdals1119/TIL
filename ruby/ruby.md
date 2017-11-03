# RUBY

- json 형식의 데이터 리턴
  - `rendor json: @변수명`

- DB에 데이터 중복 여부 확인
  - `User.exist?(id: 변수, name: 변수)`
    - return 은 true || false

- boolean value -> json
  - `{'변수명'=>'true or false'}.to_json`

- rails/db 에서 loginid 로 유저 name 찾기
  - `@id = params[:loginid]`
  - `@name = Loginusers.find_by(userid: @id)`
  - `rendor json: @name`

- rails 에서 보낸 json 객체를 레트로핏이 받을 때 모델의 각 변수의 시리얼라이즈 네임이 동일해야함
