package forFactory;

import group.GroupPage;
import ok.LoginPage;
import ok.ProductsPage;

public interface MainPage {
    public String getName();
    public GroupPage openGroupPage();
    public ProductsPage openProductsPage();
    public LoginPage exit();
}
