package challengeThisisjava16;

public class ButtonExample {
  public static void main(String[] args) {
    Button btnOk = new Button();
    btnOk.setClickListener(() -> System.out.println("OK 클릭"));
    btnOk.click();
    Button btnCancel = new Button();
    btnCancel.setClickListener(() -> System.out.println("Cancel 클릭"));
    btnCancel.click();
  }
}

class Button {
  //정적 멤버 인터페이스(함수형 인터페이스)
  @FunctionalInterface
  public static interface ClickListener {
    void onClick();
  }

  private ClickListener clickListener;

  public void setClickListener(ClickListener clickListener) {
    this.clickListener = clickListener;
  }

  public void click() {
    this.clickListener.onClick();
  }
}