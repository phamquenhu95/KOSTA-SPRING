package hello.core.singleton;

public class SingleTonService {
  private static final SingleTonService instance = new SingleTonService();

  private SingleTonService() {}

  public static SingleTonService getInstance() {
    return instance;
  }

  public void logic() {
    System.out.println("아무 로직 ==> 실글톤 객체의 메서드 호출");
  }

}
