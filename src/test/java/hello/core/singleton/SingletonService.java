package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private 으로 선언
    // 코드 올라올 때 자바 내부에 이미 생성됨 => 아래 getInstance 로는 생성하지 않고 그냥 호출
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자 private 으로
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
