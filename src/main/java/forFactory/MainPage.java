package forFactory;

import group.GroupPage;
import ok.LoginPage;

public interface MainPage {
    public String getName();
    public GroupPage openGroupPage();
    public LoginPage exit();
}
