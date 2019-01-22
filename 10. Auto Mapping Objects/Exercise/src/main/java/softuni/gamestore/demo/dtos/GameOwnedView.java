package softuni.gamestore.demo.dtos;

public class GameOwnedView {private String title;

    public GameOwnedView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

